package cc.alex.xebs.server.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
public class TestController {

    @GetMapping("hello")
    public String hello(String name) {
        log.info("/hello服务被调用");
        return "hello" + name;
    }

    @GetMapping("info")
    public String test(){
        return "febs-server-system";
    }

    @GetMapping("currentUser")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
