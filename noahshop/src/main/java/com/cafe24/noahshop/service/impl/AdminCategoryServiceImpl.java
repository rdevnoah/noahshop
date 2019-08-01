package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.AdminCategoryDao;
import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.service.AdminCategoryService;
import com.cafe24.noahshop.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private AdminCategoryDao adminCategoryDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public CategoryVo addParentCategory(CategoryVo vo) {
        return adminCategoryDao.addParentCategory(vo);
    }

    @Override
    public CategoryVo addChildCategory(CategoryVo vo) {
        return adminCategoryDao.addChildCategory(vo);
    }

    @Override
    public List<CategoryVo> getList() {

        return adminCategoryDao.getList();
    }

    @Transactional
    @Override
    public boolean deleteChild(Long no) {
        // 1. 그 카테고리 번호의 상품들이 있다면, 미지정 상품으로 옮겨놓은 뒤, 삭제한다.

        // 1.1 삭제하려는 카테고리에 포함된 상품이 있는지 확인
        int count = productDao.getCountByCategoryNo(no);
        if (count > 0){
            //1.2 있다면 미지정으로 옮긴다.
            productDao.updateCategoryNoForDeleteCategory(no);
        }
        // 그 후 삭제처리한다.

        adminCategoryDao.deleteChild(no);


        return false;
    }

    @Transactional
    @Override
    public boolean deleteParent(Long no) {
        // 1. child category가 있으면, child Category에 포함된 상품들 모두 미지정상품으로 이동
        List<Long> childNo = adminCategoryDao.getChildCategoryByParentNo(no);
        if (childNo.size() != 0){
            productDao.updateCategoryNoForDeleteParentCategory(childNo);
        }

        // 2. 그 후 child category 삭제.
        adminCategoryDao.deleteChildList(no);

        // 3. 그 후 parent 삭제
        adminCategoryDao.deleteParent(no);

        return false;
    }
}
