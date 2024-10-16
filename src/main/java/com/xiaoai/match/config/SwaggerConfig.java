package com.xiaoai.match.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/9/11 13:31
 */

/**
 * 自定义 Swagger 接口文档的配置
 */
@Configuration
@EnableSwagger2WebMvc
@Profile({"dev", "test"})
public class SwaggerConfig {
    @Bean(value="defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //这里一定要标注你控制器的位置
                /*Swagger原理:
                    1.自定义Swagger配置类
                    2.定义需要生成接口文档的代码位置(Controller),
                    千万注意:线上环境不要把接口暴露出去！！！
                 */
                .apis(RequestHandlerSelectors.basePackage("com.xiaoai.match.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api消息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("小艾匹配系统")
                .description("小艾匹配系统接口文档")
                .termsOfServiceUrl("https://github.com/AZJ12345566")
                .contact(new Contact("xiaoai", "https://github.com/AZJ12345566", "xxx@qq.com"))
                .version("1.0")
                .build();
    }
}
