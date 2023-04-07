package com.kth.iv1201.recruitmentApp.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;


/**
 * This class is responsible for configuring the Spring MVC application by adding resource handlers for
 * static files and enabling web MVC. This class implements the WebMvcConfigurer interface and ApplicationContextAware
 * interface to configure the application context and resources used in the application.
 */
@EnableWebMvc
@Configuration
public class ApplicationConfig implements WebMvcConfigurer, ApplicationContextAware{

    private ApplicationContext applicationContext;

    /**
     * Sets the ApplicationContext to be used by the application.
     *
     * @param applicationContext The ApplicationContext to be used by the application.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
    /**
     * Adds the resource handlers for static files to the ResourceHandlerRegistry.
     *
     * @param registry The ResourceHandlerRegistry containing the resource handlers for the static files.
     */    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        int cachePeriodForStaticFilesInSecs = 1;
        String rootDirForStaticFiles = "classpath:/static/";

        registry.addResourceHandler("/**").addResourceLocations(rootDirForStaticFiles)
                .setCachePeriod(cachePeriodForStaticFilesInSecs).resourceChain(true)
                .addResolver(new PathResourceResolver());
    }


}
