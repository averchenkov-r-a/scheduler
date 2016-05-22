package ru.devjava.averchenkov.springrest.scheduler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Настройки веб-сервиса.
 *
 * @author Averchenkov R.A.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /*
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converters.add(converter);
        //super.configureMessageConverters(converters);
    }
    */
}
