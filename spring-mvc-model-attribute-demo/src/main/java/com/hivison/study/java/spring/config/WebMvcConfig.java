package com.hivison.study.java.spring.config;

import javax.sql.DataSource;

import com.hivison.study.java.spring.interceptors.VisitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.hivison.study.java.spring.interceptors.ExecutionTimerInterceptor;
import com.hivison.study.java.spring.interceptors.HeaderInterceptor;

@Configuration
@ComponentScan("com.hivison.study.java.spring")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private HeaderInterceptor headerInterceptor;

    @Autowired
    private ExecutionTimerInterceptor executionTimerInterceptor;

    @Autowired
    private VisitorInterceptor visitorInterceptor;

    @Bean
    public DataSource dataSource() {
        final JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        DataSource dataSource = jndiDataSourceLookup.getDataSource("jdbc/springdb");
        return dataSource;
    }


    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/testMvcHome");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor);
        registry.addInterceptor(visitorInterceptor);
        registry.addInterceptor(executionTimerInterceptor).addPathPatterns("/location");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/css/test/");
    }
}
