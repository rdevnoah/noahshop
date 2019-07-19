package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.CategoryVo;

public interface AdminCategoryDao {

    CategoryVo addParentCategory(CategoryVo vo);

    CategoryVo addChildCategory(CategoryVo vo);
}
