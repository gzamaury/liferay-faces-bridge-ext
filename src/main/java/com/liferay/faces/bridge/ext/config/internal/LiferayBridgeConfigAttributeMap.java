/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.bridge.ext.config.internal;

import java.util.HashMap;

import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;


/**
 * @author  Neil Griffin
 */
public class LiferayBridgeConfigAttributeMap extends HashMap<String, Object> {

	// Public Constants
	public static final String CONFIGURED_FACES_SERVLET_MAPPINGS = "configuredFacesServletMappings";
	public static final String CONFIGURED_SYSTEM_EVENT_LISTENERS = "configuredSystemEventListeners";
	public static final String CONFIGURED_SUFFIXES = "configuredSuffixes";

	// serialVersionUID
	private static final long serialVersionUID = 7385067508147506114L;

	@Override
	public Object get(Object key) {
		Object value = super.get(key);

		if (value == null) {

			try {
				Product.Name productName = Product.Name.valueOf((String) key);
				value = ProductFactory.getProduct(productName);
			}
			catch (IllegalArgumentException e) {
				// do nothing.
			}
		}

		return value;
	}
}
