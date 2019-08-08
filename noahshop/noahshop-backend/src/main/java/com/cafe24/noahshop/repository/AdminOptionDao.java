package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.OptionDto;
import com.cafe24.noahshop.vo.OptionVo;

import java.util.List;

public interface AdminOptionDao {
    OptionVo addParentOption(OptionVo vo);

    OptionVo addChildOption(OptionVo vo);

    List<OptionDto> getOptionListForAddProduct();
}
