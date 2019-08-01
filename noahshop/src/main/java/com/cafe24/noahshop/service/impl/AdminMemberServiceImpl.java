package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.AdminMemberDao;
import com.cafe24.noahshop.service.AdminMemberService;
import com.cafe24.noahshop.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

    @Autowired
    private AdminMemberDao adminMemberDao;

    @Override
    public List<MemberVo> getMemberList() {

        return adminMemberDao.getMemberList();
    }

    @Override
    public  List<MemberVo> searchMemberById(String id) {

        return adminMemberDao.searchMemberById(id);
    }
}
