package referrer.service;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import referrer.service.endpoints.v1.ReferrerResource;

/**
 * Configuration for Jersey REST.
 * @author michaelkent
 *
 */
public class JerseyConfig extends ResourceConfig {
	
	@Inject
	public JerseyConfig(ServletContext servletContext) {
        WebApplicationContext springFactory = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        register(springFactory.getBean(ReferrerResource.class));
        register(CORSResponseFilter.class);
        register(LoggingFilter.class);
        property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
	}

}
