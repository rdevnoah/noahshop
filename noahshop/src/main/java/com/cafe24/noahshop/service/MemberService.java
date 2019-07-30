package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.MemberVo;
import com.cafe24.noahshop.vo.OrderVo;

import java.util.List;

/**
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.service
 * @filename : MemberService.java
 * @author : rdevnoah
 * @since : Jul 16, 2019
 * @version : 1.0
 * @see <pre>
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 16, 2019     rdevnoah         Initialize
 * Jul 16, 2019     rdevnoah         insert test
 * Jul 16, 2019     rdevnoah         insert test (encrypt, decrypt)
 * Jul 30, 2019     rdevnoah         getOrderListById 구현완료
 * </pre>
 */
public interface MemberService {
	boolean checkId(String id);
	MemberVo joinMember(MemberVo vo);
	MemberVo getMemberByNo(Long no);

    List<OrderVo> getOrderListById(Long no);
}
