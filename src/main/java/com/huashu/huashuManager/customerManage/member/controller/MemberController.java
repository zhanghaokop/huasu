package com.huashu.huashuManager.customerManage.member.controller;

import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.customerManage.member.service.MemberService;
import com.huashu.huashuManager.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员管理控制器
 */
@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("list")
    public ResponseEntity<List<Member>> pageList(Member member){
        return new ResponseEntity.Builder<List<Member>>().setData(memberService.pageListMembers(member)).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable String memberId){
        return new ResponseEntity.Builder<Member>().setData(memberService.getMemberById(memberId)).build();
    }

    @GetMapping("/delete/{memberId}")
    public ResponseEntity<Boolean> deleteMemberById(@PathVariable String memberId){
        return new ResponseEntity.Builder<Boolean>().setData(memberService.deleteMember(memberId) > 0).build();
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateMember(@RequestBody Member member){
        return new ResponseEntity.Builder<Boolean>().setData(memberService.updateMember(member) > 0).build();
    }

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody Member member){

        String id = UUIDUtils.getUUID();
        member.setId(id);
        memberService.addMember(member);

        return new ResponseEntity.Builder<String>().setData(id).build();
    }

}
