package cc.alex.xebs.gateway.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author alex
 */
@Configuration
public class XebsGateWayCorsConfigure {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);  //表示允许cookie跨域；
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL); //表示请求头部允许携带任何内容
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL); //表示允许任何来源
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL); //表示允许任何HTTP方法
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }


}
