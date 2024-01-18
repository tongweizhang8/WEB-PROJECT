package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        int delete = empMapper.delete(17);
        System.out.println(delete);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("张三");
        emp.setName("张三");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2020,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("张三");
        emp.setName("张三");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2020,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(18);
        System.out.println(emp);
    }

    @Test
    public void testList() {
        List<Emp> emps = empMapper.list("张", (short)1, LocalDate.of(2020,1,1), LocalDate.now());
        System.out.println(emps);
    }

    @Test
    public void testDeleteByIds() {
        empMapper.deleteByIds(List.of(13,14,15));
    }
}
