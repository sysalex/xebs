package cc.alex.xebs.common.annotation;

import cc.alex.xebs.common.configure.XebsOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(XebsOAuth2FeignConfigure.class)
public @interface EnableXebsOauth2FeignClient {

}
