package cc.alex.xebs.auth.service;

import cc.alex.xebs.common.entity.XebsAuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class XebsUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        XebsAuthUser user = new XebsAuthUser();
        user.setUsername(username);
        user.setPassword(this.passwordEncoder.encode("123456"));

        return new User(username, user.getPassword(),
                user.isEnabled(), //方法用于判断用户是否可用
                user.isAccountNonExpired(),//方法返回boolean类型，用于判断账户是否未过期，未过期返回true反之返回false
                user.isCredentialsNonExpired(),//用于判断用户凭证是否没过期，即密码是否未过期
                user.isAccountNonLocked(),//方法用于判断账户是否未锁定
                AuthorityUtils.commaSeparatedStringToAuthorityList("user:add"));//获取用户包含的权限，返回权限集合，权限是一个继承了GrantedAuthority的对象
    }
}
