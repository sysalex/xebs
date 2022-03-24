package cc.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author alex-dx
 */
@EnableEurekaServer
@SpringBootApplication
public class XebsRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(XebsRegisterApplication.class, args);
    }

}
