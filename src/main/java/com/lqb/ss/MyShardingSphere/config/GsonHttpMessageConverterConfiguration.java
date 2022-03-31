package com.lqb.ss.MyShardingSphere.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lqb.ss.MyShardingSphere.common.converter.LocalDateJsonConverter;
import com.lqb.ss.MyShardingSphere.common.converter.LocalDateTimeJsonConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author lqb
 * @date 2019/4/8 23:11
 * @since 1.0
 *
 */
@Configuration
public class GsonHttpMessageConverterConfiguration {

    @Bean
    public Gson gson() {
        Gson g = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
//                .registerTypeAdapterFactory()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
                .registerTypeAdapter(LocalDate.class, new LocalDateJsonConverter())
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        return g;
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        Gson g = gson();
        converter.setGson(g);
        return converter;
    }

}
