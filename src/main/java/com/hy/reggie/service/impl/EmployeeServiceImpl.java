package com.hy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hy.reggie.entity.Employee;
import com.hy.reggie.service.EmployeeService;
import com.hy.reggie.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author 23828
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2022-09-15 10:56:09
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
implements EmployeeService{

}
