package cc.alex.xebs.auth;

import cc.alex.xebs.common.annotation.EnableXebsLettuceRedis;
import cc.alex.xebs.common.annotation.XebsCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@XebsCloudApplication
@EnableXebsLettuceRedis
public class XebsAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(XebsAuthApplication.class, args);
    }
}
