package com.hy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hy.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 23828
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @createDate 2022-09-15 10:56:09
* @Entity com.hy.reggie.domain.Employee
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {


}
