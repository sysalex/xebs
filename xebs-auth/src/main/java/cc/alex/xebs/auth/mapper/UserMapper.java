package cc.alex.xebs.auth.mapper;

import cc.alex.xebs.common.entity.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(@Param("username") String username);
}
