package com.hicomb.rest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * The RESTUtilities class contain common methods for performing common
 * operations.
 */
public class RESTUtilities {

	// logger
	private static final Log logger = LogFactory.getLog(RESTUtilities.class);

	// basic escaping for characters \ and "
	private final static String ESCAPE_REG_EXP = "([\\\\\"])";
	private final static String ESCAPE_REG_EXP_SUBST = "\\\\$1";

	/**
	 * Returns the response data String from the specified
	 * <code>HttpsURLConnection</code> object.
	 * 
	 * @param data
	 *            The <code>HttpsURLConnection</code> object containing the
	 *            response data String
	 * @return The response data String
	 */
	public static String getResponseString(HttpsURLConnection data) {
		String result = "";
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					data.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				if (line.trim().length() > 1) {
					sb.append(line);
				}
			}
			result = sb.toString();
		} catch (IOException e) {
			logger.equals(e);
		}
		return result;
	}

	
	/**
	 * Creates a URI String given the specified base and parameters. The
	 * parameters will be added to the URI's queryparameter string portion and
	 * URL encoded using <code>UTF-8</code>.
	 * 
	 * @param uri
	 *            The base URI
	 * @param params
	 *            The parameters
	 * @return The formatted URI.
	 */
	public static String createURIWithSimpleParameters(String uri,
			HashMap<String, Object> params) {
		// return the new uri with the formatted parameters
		return uri + "?" + createQueryparameter(params);
	}

	/**
	 * Creates a queryparameter String using the specified params. The
	 * queryparameter string will be encoded using <code>UTF-8</code>.
	 * 
	 * @param params
	 *            The parameters
	 * @return The formatted queryParameter String.
	 */
	public static String createQueryparameter(HashMap<String, Object> params) {
		String paramString = "";

		// check for parameters
		if ((params == null) || params.isEmpty()) {
			return paramString;
		}

		try {
			Set<String> keys = params.keySet();
			Iterator<String> ite = keys.iterator();
			if (ite.hasNext()) {
				String key = (String) ite.next();
				paramString += key
						+ "="
						+ URLEncoder
								.encode(params.get(key).toString(), "UTF-8");
			}
			while (ite.hasNext()) {
				String key = (String) ite.next();
				paramString += "&"
						+ key
						+ "="
						+ URLEncoder
								.encode(params.get(key).toString(), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		// return the formatted queryparameter
		return paramString;
	}

	/**
	 * Returns a JSON String from a Map.
	 * 
	 * @param map
	 *            the Map of String (key, values) pairs.
	 * @return A valid JSON String representing the contents of the Map.
	 */
	public static String mapToJSONString(Map<String, Object> map) {
		StringBuilder builder = new StringBuilder("{");
		Iterator<Entry<String, Object>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Object> entry = iter.next();
			builder.append("\"" + entry.getKey() + "\":");
			Object value = entry.getValue();
			builder.append(objectToJSONString(value));
			if (iter.hasNext()) {
				builder.append(",");
			}
		}
		builder.append("}");
		return builder.toString();
	}

	/**
	 * Returns a JSON string that represents the specified list.
	 * 
	 * @param list
	 *            The list of items to include in the JSON String
	 * @return A valid JSON String representing the list
	 */
	public static String listToJSONString(Iterable<?> list) {
		StringBuilder builder = new StringBuilder("[");
		Iterator<?> iter = list.iterator();
		while (iter.hasNext()) {
			builder.append(objectToJSONString(iter.next()));
			if (iter.hasNext()) {
				builder.append(", ");
			}
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Utility method for 'escaping' special characters.
	 * 
	 * @param orgString
	 *            the String to replace special characters
	 * @return The 'escaped' String
	 */
	public static String escapeString(String orgString) {
		return ((orgString != null) ? orgString.replaceAll(ESCAPE_REG_EXP,
				ESCAPE_REG_EXP_SUBST) : null);
	}

	/**
	 * Returns a JSON String from the specified Object.
	 * 
	 * @param value
	 *            The Object to marshall
	 * @return a valid JSON String representing the Object
	 */
	@SuppressWarnings("unchecked")
	public static String objectToJSONString(Object value) {
		if (value instanceof String) {
			// Escape back slash
			return "\"" + escapeString(((String) value)) + "\"";
		} else if (value instanceof Map) {
			return mapToJSONString((Map<String, Object>) value);
		} else if (value instanceof Iterable<?>) {
			return listToJSONString((Iterable<?>) value);
		} else if (value instanceof byte[]) {
			return Arrays.toString((byte[]) value);
		} else if (value instanceof short[]) {
			return Arrays.toString((short[]) value);
		} else if (value instanceof int[]) {
			return Arrays.toString((int[]) value);
		} else if (value instanceof long[]) {
			return Arrays.toString((long[]) value);
		} else if (value instanceof float[]) {
			return Arrays.toString((float[]) value);
		} else if (value instanceof double[]) {
			return Arrays.toString((double[]) value);
		} else if (value instanceof boolean[]) {
			return Arrays.toString((boolean[]) value);
		} else if (value instanceof Object[]) {
			return listToJSONString(Arrays.asList((Object[]) value));
		} else if (value instanceof Date) {
			return "{\"Date\":" + Long.toString(((Date) value).getTime()) + "}";
		} else if (value instanceof Number || value instanceof Boolean) {
			return value.toString();
		} else if (value == null || value.toString().equals("null")) {
			return "null";
		} else {
			return "\"" + value.toString() + "\"";
		}
	}

	public static <T> T fromJSON(String json, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJSON(InputStream json, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}