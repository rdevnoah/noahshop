package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.CategoryVo;

import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.service
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-18       rdevnoah         Initialize
 * 2019-07-18       rdevnoah         add category implements
 * 2019-07-31       rdevnoah         deleteChild, deleteParent 구현완료
 *
 * </pre>
 * @since : 2019-07-18
 */
public interface AdminCategoryService {
    CategoryVo addParentCategory(CategoryVo vo);

    CategoryVo addChildCategory(CategoryVo vo);

    List<CategoryVo> getList();

    boolean deleteChild(Long no);

    boolean deleteParent(Long no);
}
