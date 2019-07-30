package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.MemberVo;

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
 * 2019-07-30       rdevnoah         Initialize
 * 2019-07-30       rdevnoah         getMemberList 구현완료
 * 2019-07-30       rdevnoah         searchMemberById 구현완료
 *
 * </pre>
 * @since : 2019-07-30
 */
public interface AdminMemberService {
    List<MemberVo> getMemberList();

    List<MemberVo> searchMemberById(String id);
}
