package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.AdminOptionDao;
import com.cafe24.noahshop.service.AdminOptionService;
import com.cafe24.noahshop.vo.OptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminOptionServiceImpl implements AdminOptionService {

    @Autowired
    private AdminOptionDao adminOptionDao;

    @Override
    public OptionVo addChildOption(OptionVo vo) {
        OptionVo result = adminOptionDao.addChildOption(vo);
        return result;
    }

    @Override
    public OptionVo addParentOption(OptionVo vo) {
        OptionVo result = adminOptionDao.addParentOption(vo);
        return result;
    }

}
