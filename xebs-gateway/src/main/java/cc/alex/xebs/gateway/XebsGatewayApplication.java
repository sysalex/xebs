package cc.alex.xebs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy   //开启Zuul服务网关功能
@EnableDiscoveryClient
@SpringBootApplication
public class XebsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(XebsGatewayApplication.class, args);
    }
}
