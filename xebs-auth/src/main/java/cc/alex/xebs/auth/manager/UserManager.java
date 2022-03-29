package cc.alex.xebs.auth.manager;

import cc.alex.xebs.auth.mapper.MenuMapper;
import cc.alex.xebs.auth.mapper.UserMapper;
import cc.alex.xebs.common.entity.system.Menu;
import cc.alex.xebs.common.entity.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

     public String findUserPermissions(String username) {
         List<Menu> userPermissions = menuMapper.findUserPermissions(username);
         return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
