package cc.alex.xebs.annotation;

import cc.alex.xebs.handler.XebsAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(XebsAuthExceptionConfigure.class)
public @interface EnableXebsAuthExceptionHandler {

}
