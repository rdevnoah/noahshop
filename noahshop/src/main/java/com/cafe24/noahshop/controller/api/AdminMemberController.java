package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.AdminMemberService;
import com.cafe24.noahshop.vo.MemberVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
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
@RestController
@RequestMapping("/api/admin/user")
public class AdminMemberController {

    @Autowired
    private AdminMemberService adminMemberService;


    @ApiOperation(value = "get member list by admin", notes = "관리자 회원 리스트")
    @GetMapping("/list")
    public JSONResult getMemberList(){

        List<MemberVo> list = adminMemberService.getMemberList();

        return JSONResult.success(list);
    }

    @ApiOperation(value = "search member by id", notes = "관리자 회원 아이디 검색")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="회원 아이디", required=true, dataType="String", defaultValue="")
    })
    @GetMapping("/search/{id}")
    public JSONResult searchMemberById(@PathVariable(value = "id") String id){
        List<MemberVo> list = adminMemberService.searchMemberById(id);

        return JSONResult.success(list);

    }
}
