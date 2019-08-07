package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.MemberVo;
import com.cafe24.noahshop.vo.OrderVo;

import java.util.List;
import java.util.Map;

/**
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.repository
 * @filename : MemberDao.java
 * @author : rdevnoah
 * @since : Jul 16, 2019
 * @version : 1.0
 * @see
 *
 * <pre>
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 16, 2019     rdevnoah         Initialize
 * Jul 16, 2019     rdevnoah         insert test
 * Jul 16, 2019     rdevnoah         test data ENCRYPT, DECRYPT
 * Jul 30, 2019     rdevnoah         getOrderListById 구현완료
 * Jul 30, 2019     rdevnoah         getOrderListById 구현완료
 * Jul 31, 2019     rdevnoah         getOrderByNoUser 구현완료
 * Jul 31, 2019     rdevnoah         getMemberByIdAndPassword 구현완료
 *
 * </pre>
 */
public interface MemberDao {
	public MemberVo insert(MemberVo vo);
	
	public MemberVo getMemberByNo(Map<String, Object> map);

	public void deleteAll();

	public boolean insertKey(Map<String, Object> map);

	public boolean deleteAllKey();

	public String getKeyByNo(Long no);

	public String checkId(String id);

    List<OrderVo> getOrderListById(Long no);

	void updateMember(Map<String, Object> map);

    OrderVo getOrderByNoMember(Map<String, Object> map);

    MemberVo getMemberByIdAndPassword(MemberVo vo);

    MemberVo getById(String id);
}
