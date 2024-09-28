package com.laolang.jx.framework.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laolang.jx.framework.web.web.CustomHandlerExceptionResolver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 参考: 整合Knife4j生成文档后端接口文档出现404无法找到doc.html: https://blog.csdn.net/jianxia801/article/details/114288604
 */
@Configuration
public class JxWebConfig implements WebMvcConfigurer {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new CustomHandlerExceptionResolver(objectMapper));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                // 允许跨域的路径
                .addMapping("/**")
                // 允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许 cookie
                .allowCredentials(true)
                // 允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 允许设置的 Header 属性
                .allowedHeaders("*")
                // 跨域时间
                .maxAge(3600);
    }
}
