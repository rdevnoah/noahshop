package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.OptionVo;

public interface AdminOptionService {
    OptionVo addParentOption(OptionVo vo);

    OptionVo addChildOption(OptionVo vo);
}
