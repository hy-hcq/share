package com.hy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.reggie.entity.Dish;
import com.hy.reggie.service.DishService;
import com.hy.reggie.mapper.DishMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author 23828
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-09-16 15:24:56
*/
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

}




