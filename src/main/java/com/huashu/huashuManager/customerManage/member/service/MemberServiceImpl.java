package com.huashu.huashuManager.customerManage.member.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.mapper.MemberMapper;
import com.huashu.huashuManager.mapper.MemberWeixinMapper;
import com.huashu.huashuManager.model.Member;
import com.huashu.huashuManager.model.MemberWeixin;
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

    @Autowired
    private MemberWeixinMapper messageMapper;

    @Override
    public int deleteMember(String memberId) {
        return memberMapper.deleteByPrimaryKey(memberId);
    }

    @Override
    public int addMember(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public PageEntity<Member> pageListMembers(Member member) {
        PageEntity<Member> page =new PageEntity<Member>();
        page.setPageData(memberMapper.pageSelect(member));
        return page;
    }

    @Override
    public List<Member> getAllMember(Member member) {
        return memberMapper.selectAll();
    }

    @Override
    public boolean isRegister(String openId) {
        Member query = new Member();
        query.setOpenId(openId);
        return true;
    }

    @Override
    public Member getMemberById(String id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Member getMemberByOpenId(String openId) {
        return memberMapper.selectByOpenId(openId);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateByPrimaryKey(member);
    }

    @Override
    public Integer getMessageCount(String openId) {
        return messageMapper.getNotReadAllCountByOpenId(openId);
    }

    @Override
    public PageEntity<MemberWeixin> pageSelectMessage(MemberWeixin memberWeixin) {
        PageEntity<MemberWeixin> entity = new PageEntity<>();
        entity.setPageData(messageMapper.pageSelect(memberWeixin));
        return entity;
    }
}
