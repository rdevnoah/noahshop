package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.OptionVo;

import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.repository
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-25       rdevnoah         Initialize
 * 2019-07-25       rdevnoah         상품 상세보기를 위한 get optionList 구현완료
 *
 * </pre>
 * @since : 2019-07-25
 */
public interface OptionDao {
    List<OptionVo> getOptionListByProductNo(Long no);
}
