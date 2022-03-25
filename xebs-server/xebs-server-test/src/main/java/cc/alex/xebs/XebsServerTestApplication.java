package cc.alex.xebs;

import cc.alex.xebs.annotation.EnableXebsAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableXebsAuthExceptionHandler
public class XebsServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(XebsServerTestApplication.class, args);
    }
}
