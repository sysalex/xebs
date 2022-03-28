package cc.alex.xebs.common.annotation;

import cc.alex.xebs.common.selector.XebsCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(XebsCloudApplicationSelector.class)
public @interface XebsCloudApplication {

}
