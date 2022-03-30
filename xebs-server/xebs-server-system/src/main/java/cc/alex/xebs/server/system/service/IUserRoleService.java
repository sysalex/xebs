package cc.alex.xebs.server.system.service;

import cc.alex.xebs.common.entity.system.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String[] roleIds);

	void deleteUserRolesByUserId(String[] userIds);
}
