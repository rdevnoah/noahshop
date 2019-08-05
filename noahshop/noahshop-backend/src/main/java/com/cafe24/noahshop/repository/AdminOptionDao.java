package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.OptionVo;

public interface AdminOptionDao {
    OptionVo addParentOption(OptionVo vo);

    OptionVo addChildOption(OptionVo vo);
}
