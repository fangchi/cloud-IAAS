package com.hicomb.rest.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * osgi Activator for osgi framework
 * @author fangchi
 */
public class Activator implements BundleActivator{

	public void start(BundleContext arg0) throws Exception {
		System.out.println("loading RestEngine...");
	}

	public void stop(BundleContext arg0) throws Exception {
		System.out.println("removing RestEngine...");
	}

}
