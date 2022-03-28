package cc.alex.xebs.server.test;

import cc.alex.xebs.common.annotation.XebsCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients
@XebsCloudApplication
public class XebsServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(XebsServerTestApplication.class, args);
    }
}
