/***********************************************************************************
 * Copyright (c) 2016  CUBIC Transportation Systems. All rights reserved.
 * CUBIC PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 ***********************************************************************************/
package referrer.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuration for the CORS mapping.
 * @author michaelkent
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
