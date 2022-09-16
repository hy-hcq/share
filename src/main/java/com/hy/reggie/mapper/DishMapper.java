package com.hy.reggie.mapper;

import com.hy.reggie.entity.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 23828
* @description 针对表【dish(菜品管理)】的数据库操作Mapper
* @createDate 2022-09-16 15:24:56
* @Entity com.hy.reggie.entity.Dish
*/
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}




