package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.AdminOptionDao;
import com.cafe24.noahshop.service.AdminOptionService;
import com.cafe24.noahshop.vo.OptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.service.impl
 * @author : noah
 * @since : 2019-07-17
 * @version : 1.0
 * @see <pre>
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-17         noah             Initialize
 * </pre>
 *
 */
@Service
public class AdminOptionServiceImpl implements AdminOptionService {

    @Autowired
    private AdminOptionDao adminOptionDao;

    @Override
    public OptionVo addChildOption(OptionVo vo) {
        return  adminOptionDao.addChildOption(vo);
    }

    @Override
    public OptionVo addParentOption(OptionVo vo) {
        return adminOptionDao.addParentOption(vo);
    }

}
