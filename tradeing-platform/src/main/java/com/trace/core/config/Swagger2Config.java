package com.trace.core.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

   //@Bean
    /**
     * description
     * @author monkey
     * @datetime  2023/6/14 09:43
     * @param
     * @return {@link springfox.documentation.spring.web.plugins.Docket}
     **/
    public Docket apiConfig(){
       return new Docket(DocumentationType.SWAGGER_2);
   }
}
