package cn.jmzzz.easycoupon.config;

import cn.jmzzz.easycoupon.intercepter.RefererFilter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    final Properties properties;

    public WebConfig(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RefererFilter(properties.getWhitelist()));
    }

}

@Component
@ConfigurationProperties(prefix = "referer")
class Properties {
    private String[] whitelist;

    public String[] getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String[] whitelist) {
        this.whitelist = whitelist;
    }
}
