package io.chris.training.config;

import io.chris.training.config.viewResolver.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("io.chris.training.api")
public class MvcConfig implements WebMvcConfigurer {

    @Override // override the original method inherited from WebMvcConfig
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(jsonViewResolver());
//        resolvers.add(xmlViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        MappingJackson2HttpMessageConverter jsonViewHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ResourceHttpMessageConverter resourceHttpMessageConverter = new ResourceHttpMessageConverter();
        converters.add(jsonViewHttpMessageConverter);
        converters.add(resourceHttpMessageConverter);
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver(){
        return new DeviceHandlerMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(deviceHandlerMethodArgumentResolver());
    }
}
