package com.cafe24.noahshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cafe24.noahshop.vo.ProductVo;

@Service
public interface ProductService {
	ProductVo getDetail(Long no);

	Map<String, Object> searchByKeyword(String keyword);

	List<ProductVo> searchByKeywordInCategory(String keyword, Long categoryNo);

	Map<String, Object> getMain();
}
