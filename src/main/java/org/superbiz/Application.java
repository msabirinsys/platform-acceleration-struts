package org.superbiz;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msabir on 1/30/17.
 */
@SpringBootApplication
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Order(1)
    @Bean
    public FilterRegistrationBean struts2() {
        StrutsPrepareAndExecuteFilter dispatcher=new StrutsPrepareAndExecuteFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(dispatcher);
        registrationBean.addInitParameter("actionPackages", "com.superbiz.struts");
        List<String> match = new ArrayList<>();
        match.add("/*");
        registrationBean.setUrlPatterns(match);
        return registrationBean;
    }
/*
    @Order(2)
    @Bean
    public FilterRegistrationBean strutsCleanup() {
        ActionContextCleanUp cleanup=new ActionContextCleanUp();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(cleanup);
        List<String> match = new ArrayList<>();
        match.add("/*");
        registrationBean.setUrlPatterns(match);
        return registrationBean;
    }
*/
    @Order(3)
    @Bean
    public FilterRegistrationBean sitemesh() {
        SiteMeshFilter sitemesh=new SiteMeshFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(sitemesh);
        List<String> match = new ArrayList<>();
        match.add("/*");
        registrationBean.setUrlPatterns(match);
        return registrationBean;
    }




}
