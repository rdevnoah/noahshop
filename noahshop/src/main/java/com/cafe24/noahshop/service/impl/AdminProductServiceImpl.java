package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.dto.ProductAddDto;
import com.cafe24.noahshop.repository.AdminProductDao;
import com.cafe24.noahshop.service.AdminProductService;
import com.cafe24.noahshop.vo.OptionStockVo;
import com.cafe24.noahshop.vo.ProductDetailVo;
import com.cafe24.noahshop.vo.ProductImageVo;
import com.cafe24.noahshop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AdminProductServiceImpl implements AdminProductService {

    @Autowired
    private AdminProductDao adminProductDao;

    /**
     * 판매 하지 않지만 상품 등록하는 서비스
     * @param dto
     * @return
     */
    @Override
    public boolean addProductNoOption(ProductAddDto dto) {

        // 기본 상품정보 add data set
        ProductVo vo = new ProductVo();
        vo.setName(dto.getName());
        vo.setPrice(dto.getPrice());
        vo.setDescription(dto.getDescription());
        vo.setCategoryNo(dto.getCategoryNo());
        vo.setIsSell(dto.getIsSell());
        vo.setDpMain(dto.getDpMain());
        vo.setCode(codeGenerator(dto));

        Long productNo = adminProductDao.addProduct(vo);

        List<ProductImageVo> images = dto.getImage();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("no", productNo);
        map.put("images", images);
        // 기본 상품 이미지 등록
        boolean result = adminProductDao.addImage(map);
        return result;
    }


    /**
     * option까지 포함한 product add service
     * @param dto
     * @return
     */
    @Override
    public boolean addProduct(ProductAddDto dto) {
        // 기본 상품정보 add data set
        ProductVo vo = new ProductVo();
        vo.setName(dto.getName());
        vo.setPrice(dto.getPrice());
        vo.setDescription(dto.getDescription());
        vo.setCategoryNo(dto.getCategoryNo());
        vo.setIsSell(dto.getIsSell());
        vo.setDpMain(dto.getDpMain());
        vo.setCode(codeGenerator(dto));

        // add product
        Long productNo = adminProductDao.addProduct(vo);

        List<ProductImageVo> images = dto.getImage();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("no", productNo);
        map.put("images", images);

        // 기본 상품 이미지 등록
        boolean result = adminProductDao.addImage(map);

        List<ProductDetailVo> details = new ArrayList<ProductDetailVo>();
        for (OptionStockVo option : dto.getOptionStockVoList()){
            details.add(new ProductDetailVo(null, option.getStock(), option.getOptionChild1No(), option.getOptionChild2No(), productNo));
        }

        adminProductDao.addProductDetail(details);




        return result;
    }

    @Override
    public List<ProductVo> getList() {
        return adminProductDao.getList();
    }

    @Override
    public Map<String, Object> getDetailByNo(Long no) {
        Map<String, Object> map = new HashMap<>();

        // 상품정보
        ProductVo productVo = adminProductDao.getProductByNo(no);
        map.put("productVo", productVo);
        // 상품상세정보
        List<ProductDetailVo> list = adminProductDao.getProductDetailByNo(no);
        map.put("productDetailList", list);

        // 상품의 옵션정보
        //todo: 옵션의 이름 가져오기

        return map;
    }


    /**
     * 상품 코드 generator (고유한 값으로 generate)
     * @param dto
     * @return
     */
    private String codeGenerator(ProductAddDto dto) {
        return "code1";
    }

}
