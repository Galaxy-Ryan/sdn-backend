package com.glimmer.mapper;

import com.glimmer.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * Model层，进行数据库访问操作
 * 整合了MyBatis持久层框架
 */
@Mapper
public interface UserMapper {
    /**
     * 通过用户名查询用户
     * @param name
     * @return
     */
    @Select("select * from user where name = #{name}")
    User getByName(String name);
}
