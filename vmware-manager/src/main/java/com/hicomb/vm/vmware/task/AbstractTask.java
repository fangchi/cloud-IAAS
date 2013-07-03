package com.hicomb.vm.vmware.task;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.ObjectUpdateKind;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyChangeOp;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;

/**
 * 抽象任务类
 * @param <T> 任务返回泛型
 */
public abstract class AbstractTask<T> extends Task<T> {

	/**
	 * 根据属性过滤
	 * @param container 要过滤的容器
	 * @param morefType 过滤的类型
	 * @param morefProperties 文件夹名称列表
	 * @param connection 连接
	 * @return 符合条件的数据
	 * @throws RuntimeFault
	 * @throws RemoteException
	 */
	protected Map<ManagedObjectReference, Map<String, Object>> getMOREFsInContainerByType(
	         ManagedObjectReference container, String morefType,
	         String[] morefProperties,VMWareConnection connection) throws RuntimeFault, RemoteException {
	      ManagedObjectReference viewManager = connection.getServiceContent().getViewManager();
	      ManagedObjectReference containerView =
	    	  connection.getService().createContainerView(viewManager, container,
	    			  new String[] { morefType } , true);//构建容器View
	     
	      Map<ManagedObjectReference, Map<String, Object>> tgtMoref =
	            new HashMap<ManagedObjectReference, Map<String, Object>>();

	      // Create Property Spec
	      PropertySpec propertySpec = new PropertySpec();
	      propertySpec.setAll(Boolean.FALSE);
	      propertySpec.setType(morefType);
	      propertySpec.setPathSet(morefProperties);

	      TraversalSpec ts = new TraversalSpec();
	      ts.setName("view");
	      ts.setPath("view");
	      ts.setSkip(false);
	      ts.setType("ContainerView");

	      // Now create Object Spec
	      ObjectSpec objectSpec = new ObjectSpec();
	      objectSpec.setObj(containerView);
	      objectSpec.setSkip(Boolean.TRUE);
	      objectSpec.setSelectSet(new TraversalSpec[]{ts});

	      // Create PropertyFilterSpec using the PropertySpec and ObjectPec
	      // created above.
	      PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
	      propertyFilterSpec.setPropSet(new PropertySpec[]{propertySpec});
	      propertyFilterSpec.setObjectSet(new ObjectSpec[]{objectSpec});

	      ObjectContent[] oCont =
	    	  connection.getService().retrieveProperties(connection.getPropCol(),
	                  new PropertyFilterSpec[]{propertyFilterSpec});
	      oCont = (oCont!=null ? oCont : new ObjectContent[0]);
          for (ObjectContent oc : oCont) {
            Map<String, Object> propMap = new HashMap<String, Object>();
            DynamicProperty[] dps = oc.getPropSet();
            dps = (dps!=null ? dps : new DynamicProperty[0]);
            for (DynamicProperty dp : dps) {
            	propMap.put(dp.getName(), dp.getVal());
            }
            tgtMoref.put(oc.getObj(), propMap);
         }
	     return tgtMoref;
	}
	
	
	/**
	 * 获取属性过滤器配置
	 * @param moref 容器
	 * @param type 类型
	 * @param properties 属性配置
	 * @return
	 */
	protected PropertyFilterSpec[] getPropertyFilterSpec(
			ManagedObjectReference moref, String type, String[] properties) {
		// Create Property Spec
		PropertySpec propertySpec = new PropertySpec();
		propertySpec.setAll(Boolean.FALSE);
		propertySpec.setPathSet(properties);
		propertySpec.setType(type);
		PropertySpec[] propertySpecs = new PropertySpec[] { propertySpec };

		// Now create Object Spec
		ObjectSpec objectSpec = new ObjectSpec();
		objectSpec.setObj(moref);
		objectSpec.setSkip(Boolean.FALSE);
		// objectSpec.setSelectSet(new SelectionSpec[]{tSpec});
		ObjectSpec[] objectSpecs = new ObjectSpec[] { objectSpec };

		// Create PropertyFilterSpec using the PropertySpec and ObjectPec
		// created above.
		PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
		propertyFilterSpec.setPropSet(propertySpecs);
		propertyFilterSpec.setObjectSet(objectSpecs);

		PropertyFilterSpec[] pfSpecList = new PropertyFilterSpec[] { propertyFilterSpec };

		return pfSpecList;
	}

	/**
	 * Handle Updates for a single object. waits till expected values of
	 * properties to check are reached Destroys the ObjectFilter when done.
	 * 
	 * @param objmor
	 *            MOR of the Object to wait for</param>
	 * @param filterProps
	 *            Properties list to filter
	 * @param endWaitProps
	 *            Properties list to check for expected values these be
	 *            properties of a property in the filter properties list
	 * @param expectedVals
	 *            values for properties to end the wait
	 * @return true indicating expected values were met, and false otherwise
	 */
	protected Object[] waitForValues(ManagedObjectReference objmor,
			String[] filterProps, String[] endWaitProps, Object[][] expectedVals)
			throws Exception {
		// version string is initially null
		String version = "";
		Object[] endVals = new Object[endWaitProps.length];
		Object[] filterVals = new Object[filterProps.length];

		PropertyFilterSpec spec = new PropertyFilterSpec();
		spec.setObjectSet(new ObjectSpec[] { new ObjectSpec() });
		spec.getObjectSet(0).setObj(objmor);

		spec.setPropSet(new PropertySpec[] { new PropertySpec() });
		spec.getPropSet(0).setPathSet(filterProps);
		spec.getPropSet(0).setType(objmor.getType());

		spec.getObjectSet(0).setSelectSet(null);
		spec.getObjectSet(0).setSkip(Boolean.FALSE);

		ManagedObjectReference filterSpecRef = connection.getService().createFilter(
				connection.getPropCol(), spec, true);

		boolean reached = false;

		UpdateSet updateset = null;
		PropertyFilterUpdate[] filtupary = null;
		PropertyFilterUpdate filtup = null;
		ObjectUpdate[] objupary = null;
		ObjectUpdate objup = null;
		PropertyChange[] propchgary = null;
		PropertyChange propchg = null;
		while (!reached) {
			updateset = connection.getService().waitForUpdates(connection.getPropCol(), version);

			version = updateset.getVersion();

			if (updateset == null || updateset.getFilterSet() == null) {
				continue;
			}
			// Make this code more general purpose when PropCol changes later.
			filtupary = updateset.getFilterSet();
			filtup = null;
			for (int fi = 0; fi < filtupary.length; fi++) {
				filtup = filtupary[fi];
				objupary = filtup.getObjectSet();
				objup = null;
				propchgary = null;
				for (int oi = 0; oi < objupary.length; oi++) {
					objup = objupary[oi];

					// TODO: Handle all "kind"s of updates.
					if (objup.getKind() == ObjectUpdateKind.modify
							|| objup.getKind() == ObjectUpdateKind.enter
							|| objup.getKind() == ObjectUpdateKind.leave) {
						propchgary = objup.getChangeSet();
						for (int ci = 0; ci < propchgary.length; ci++) {
							propchg = propchgary[ci];
							updateValues(endWaitProps, endVals, propchg);
							updateValues(filterProps, filterVals, propchg);
						}
					}
				}
			}

			Object expctdval = null;
			// Check if the expected values have been reached and exit the loop
			// if done.
			// Also exit the WaitForUpdates loop if this is the case.
			for (int chgi = 0; chgi < endVals.length && !reached; chgi++) {
				for (int vali = 0; vali < expectedVals[chgi].length && !reached; vali++) {
					expctdval = expectedVals[chgi][vali];

					reached = expctdval.equals(endVals[chgi]) || reached;
				}
			}
		}

		// Destroy the filter when we are done.
		connection.getService().destroyPropertyFilter(filterSpecRef);
		return filterVals;
	}
	
	
	protected void updateValues(String[] props, Object[] vals, PropertyChange propchg) {
	      for (int findi = 0; findi < props.length; findi++) {
	         if (propchg.getName().lastIndexOf(props[findi]) >= 0) {
	            if (propchg.getOp() == PropertyChangeOp.remove) {
	               vals[findi] = "";
	            } else {
	               vals[findi] = propchg.getVal();
	            }
	         }
	      }
	   }
}
