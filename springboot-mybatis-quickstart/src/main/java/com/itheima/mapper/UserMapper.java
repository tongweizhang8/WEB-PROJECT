package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //在运行时，框架会自动生成该接口的实现类对象，并且将对象交给spring的IOC容器管理
public interface UserMapper {
    //查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
