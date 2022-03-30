package cc.alex.xebs.common.validator;

import cc.alex.xebs.common.annotation.IsMobile;
import cc.alex.xebs.common.entity.RegexpConstant;
import cc.alex.xebs.common.utils.XebsUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return XebsUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
