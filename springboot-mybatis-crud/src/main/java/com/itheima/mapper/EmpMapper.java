package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
    "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

//    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, " +
//            "entryDate = #{entryDate}, dept_id = #{deptId}, create_time = #{createTime}, update_time = #{up dateTime} where id = #{id}")
//    public void update(Emp emp);

    //方案三：开启驼峰命名规则
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);
    //方案一：给字段起别名，让别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entryDate, " +
//            "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getById(Integer id);
    //方案二：通过@Results注解，将数据库字段与实体类属性进行映射
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);

//    //条件查询
//    @Select("select * from emp where name like concat('%' + #{name} + '%') and gender = #{gender} " +
//            "and entryDate between #{begin} and #{end} order by id desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    public void update(Emp emp);

    //批量删除
    public void deleteByIds(List<Integer> ids);

}
