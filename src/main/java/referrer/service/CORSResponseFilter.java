/***********************************************************************************
 * Copyright (c) 2016  CUBIC Transportation Systems. All rights reserved.
 * CUBIC PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 ***********************************************************************************/
package referrer.service;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/**
 * CORS filter to enable the web UI.
 * @author michaelkent
 *
 */
public class CORSResponseFilter implements ContainerResponseFilter {

	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers");
	}

}
