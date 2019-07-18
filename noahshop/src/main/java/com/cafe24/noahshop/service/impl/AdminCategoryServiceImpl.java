package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.AdminCategoryDao;
import com.cafe24.noahshop.service.AdminCategoryService;
import com.cafe24.noahshop.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.service.impl
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-18       rdevnoah         Initialize
 * 2019-07-18       rdevnoah         add category implements
 *
 * </pre>
 * @since : 2019-07-18
 */
@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private AdminCategoryDao adminCategoryDao;

    @Override
    public CategoryVo addParentCategory(CategoryVo vo) {
        return adminCategoryDao.addParentCategory(vo);
    }
}
