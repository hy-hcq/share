package com.hy.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.reggie.commen.CustomException;
import com.hy.reggie.entity.Category;
import com.hy.reggie.entity.Dish;
import com.hy.reggie.entity.Setmeal;
import com.hy.reggie.service.CategoryService;
import com.hy.reggie.mapper.CategoryMapper;
import com.hy.reggie.service.DishService;
import com.hy.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 23828
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
 * @createDate 2022-09-16 14:27:28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除前检查是否关联
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        //查询当前分类是否关联了菜品，如果己经关联，抛出一个业务异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        if (count1 > 0){//已关联，抛异常
            throw new CustomException("当前分类下已关联了菜品，请删除菜品后重试！");
        }
        //查询当前分类是否关联了套餐，如果己经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0){//已关联，抛异常
            throw new CustomException("当前分类下已关联了套餐，请删除菜品后重试！");
        }

        //无关联
        super.removeById(id);
    }
}




