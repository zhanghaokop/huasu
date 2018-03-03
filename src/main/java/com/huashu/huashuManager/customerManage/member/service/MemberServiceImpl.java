package com.huashu.huashuManager.customerManage.member.service;

import com.huashu.huashuManager.mapper.MemberMapper;
import com.huashu.huashuManager.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int deleteMember(String memberId) {
        return memberMapper.deleteByPrimaryKey(memberId);
    }

    @Override
    public int addMember(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public List<Member> pageListMembers(Member member) {
        return memberMapper.pageSelect(member);
    }

    @Override
    public List<Member> getAllMember(Member member) {
        return memberMapper.selectAll();
    }

    @Override
    public Member getMemberById(String id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateByPrimaryKey(member);
    }
}
