package cc.alex.xebs.configure;

import cc.alex.xebs.service.XebsUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 认证服务器
 * 定义一个WebSecurity类型的安全配置类
 * 用于处理/，oauth开头的请求Spring Cloud OAuth内部定义的获取令牌，刷新令牌的请求地址都是以/oauth/开头的，也就是说FebsSecurityConfigure用于处理和令牌相关的请求
 */
@Order(2)
@EnableWebSecurity  //开启和Web相关的安全配置
public class XebsSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    private XebsUserDetailService userDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        /*密码组件**/
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        /*密码模式需要使用到这个Bean**/
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/oauth/**")  // 只对/oauth/开头的请求有效
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
}
