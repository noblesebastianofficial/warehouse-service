package com.mycompany.warehouse.config;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration class which contains the configuration for swagger.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfiguration {

    /**
     * Determine the API methods to show in swagger UI.
     *
     * @return Docket
     */
    @Bean
    public Docket redditCloneApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.mycompany.warehouse.contoller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo());
    }

    /**
     * Populates the API basic information swagger UI.
     *
     * @return ApiInfo
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
            .title("Warehouse Api")
            .version("1.0.1.0")
            .description("API for Warehouse Application")
            .contact(new Contact("Noble Sebastian", "//", "noblesebastiank@gmail.com"))
            .license("Apache License Version 2.0")
            .build();
    }

    /**
     * springfoxHandlerProviderBeanPostProcessor spring fox issue fix with the latest spring fox and spring boot
     * version.
     */
    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(
                List<T> mappings) {
                List<T> copy = mappings.stream()
                    .filter(mapping -> mapping.getPatternParser() == null)
                    .collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }

            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    if (field != null) {
                        field.setAccessible(true);
                    }
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }
}