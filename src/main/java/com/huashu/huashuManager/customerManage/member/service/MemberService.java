package com.huashu.huashuManager.customerManage.member.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.Member;

import java.util.List;

/**
 * 会员管理服务类
 */
public interface MemberService {

    /**
     * 删除会员
     * @param memberId
     * @return
     */
    int deleteMember(String memberId);

    /**
     * 新增会员
     * @param member
     * @return
     */
    int addMember(Member member);

    /**
     * 列表会员
     * @param member
     * @return
     */
    PageEntity<Member> pageListMembers(Member member);

    /**
     * 获取会员
     * @param member
     * @return
     */
    List<Member> getAllMember(Member member);

    /**
     * openId是否已经注册过了
     *
     * @param openId
     * @return
     */
    boolean isRegister(String openId);

    /**
     * 根据会员id获取会员
     * @param id
     * @return
     */
    Member getMemberById(String id);

    /**
     * 更新会员
     * @param member
     * @return
     */
    int updateMember(Member member);
}
