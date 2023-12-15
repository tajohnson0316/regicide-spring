package com.tajprod.regicide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RegicideApplication implements WebMvcConfigurer {

  private static Logger logger = LoggerFactory.getLogger(RegicideApplication.class.getName());

  public static void main(String[] args) {
    SpringApplication.run(RegicideApplication.class, args);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    // Register resource handler for images
    registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
      .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
  }

}