package com.kth.iv1201.recruitmentApp.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;



@EnableWebMvc
@Configuration
public class AppConfig implements WebMvcConfigurer, ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        int cachePeriodForStaticFilesInSecs = 1;
        String rootDirForStaticFiles = "classpath:/static/";

        registry.addResourceHandler("/**").addResourceLocations(rootDirForStaticFiles)
                .setCachePeriod(cachePeriodForStaticFilesInSecs).resourceChain(true)
                .addResolver(new PathResourceResolver());
    }


}
