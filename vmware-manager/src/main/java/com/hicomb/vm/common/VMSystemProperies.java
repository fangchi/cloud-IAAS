package com.hicomb.vm.common;

import java.io.IOException;
import java.util.Properties;

/**
 * Properties常量
 */
public class VMSystemProperies {

	/**
	 * The prefix used by all properties.
	 */
	public static final String PROPERTY_PREFIX = "com.hicomb.vm.";

	protected static Properties props = new Properties();

	static {
		loadProperties();
	}

	/**
	 * Loads a properties file from the classpath.
	 * 
	 * @param name
	 *            the resource name
	 * @param defaults
	 *            the default properties
	 * @return the loaded properties if the resource is found, <code>null</code>
	 *         otherwise
	 */
	public static Properties loadProperties() {
		try {
			props.load(VMSystemProperies.class
					.getResourceAsStream("vmsystem.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	/**
	 * Returns the value of the property.
	 * 
	 * @param key
	 *            the key
	 * @return the property value
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * Returns a property as a boolean value.
	 * 
	 * @param key
	 *            the key
	 * @return the property value as a boolean
	 */
	public static boolean getBooleanProperty(String key) {
		return asBoolean(props.getProperty(key));
	}

	/**
	 * Returns a property as an integer value.
	 * 
	 * @param key
	 *            the key
	 * @return the property value as an integer
	 */
	public static int getIntegerProperty(String key) {
		return asInteger(props.getProperty(key));
	}

	/**
	 * Returns a property as a float value.
	 * 
	 * @param key
	 *            the key
	 * @return the property value as a float
	 */
	public static float getFloatProperty(String key) {
		return asFloat(props.getProperty(key));
	}

	/**
	 * Converts a <code>String</code> value into a <code>boolean</code>.
	 * 
	 * @param value
	 *            the value
	 * @return the value as a <code>boolean</code>
	 */
	public static boolean asBoolean(String value) {
		return Boolean.valueOf(value).booleanValue();
	}

	/**
	 * Converts a <code>String</code> value into a <code>int</code>.
	 * 
	 * @param value
	 *            the value
	 * @return the value as a <code>int</code>
	 */
	public static int asInteger(String value) {
		return Integer.parseInt(value);
	}

	/**
	 * Converts a <code>String</code> value into a <code>float</code>.
	 * 
	 * @param value
	 *            the value
	 * @return the value as a <code>float</code>
	 */
	public static float asFloat(String value) {
		return Float.parseFloat(value);
	}

	/**
	 * Sets the value of a property.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void setProperty(String key, String value) {
		props.setProperty(key, value);
	}

	/**
	 * Sets the value of a property.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void setProperty(String key, boolean value) {
		props.setProperty(key, String.valueOf(value));
	}

	/**
	 * Removes the value set for a property.
	 * 
	 * <p>
	 * This method removes values set in report.properties or via the
	 * {@link #setProperty(String, String) setProperty} method. Built-in default
	 * property values are not affected; if the property has a default value it
	 * will be used after calling this method for the property.
	 * </p>
	 * 
	 * @param key
	 *            the property key
	 */
	public static void removePropertyValue(String key) {
		props.remove(key);
	}
}
