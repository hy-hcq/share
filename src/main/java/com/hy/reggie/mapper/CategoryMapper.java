package com.hy.reggie.mapper;

import com.hy.reggie.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 23828
* @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
* @createDate 2022-09-16 14:27:28
* @Entity com.hy.reggie.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




