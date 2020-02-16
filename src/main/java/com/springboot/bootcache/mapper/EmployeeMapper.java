package com.springboot.bootcache.mapper;

import com.springboot.bootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getByid(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void  updateByid(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void  deleteByid(Integer id);

    @Insert("insert into emplyee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insert(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    public Employee getByName(String lastName);
}
