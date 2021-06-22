package com.lft.springmvc.init;

import com.lft.springmvc.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        // Servlet 3.0 SPI
        
        
        
        
        // 初始化 Spring 环境
        // 初始化 SpringMVC 环境（把 DispatcherServlet 加载到我们 web.xml）
        // Load Spring Web Application Configuration
        
        // 初始化 Spring
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();
        
        // Spring Boot 底层  内存 Tomcat Code
        // start()  Tomcat tomcat = new Tomcat(8080)
        // ...... tomcat.setwebAppLocal
        // static public resource
        // tomcat.start()
        
        // 初始化 SpringMVC
        // 创建和注册 DispatcherServlet （Servlet 3.0 SPI）
        DispatcherServlet servlet = new DispatcherServlet(ac);
        
        ServletRegistration.Dynamic registration = servletContext.addServlet("servlet", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
