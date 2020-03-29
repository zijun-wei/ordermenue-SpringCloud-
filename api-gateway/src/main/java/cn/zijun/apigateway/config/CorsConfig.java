package cn.zijun.apigateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @Title CorsConfig
 * @Description 跨域配置
 * @Author Zijun Wei
 * @Date 2020/3/6
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config=new CorsConfiguration();
        /**
         * 支持cookie跨域
         */
        config.setAllowCredentials(true);

        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setMaxAge(300L);
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
