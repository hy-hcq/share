package com.hy.reggie.service;

import com.hy.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 23828
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2022-09-16 14:27:28
*/
public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
