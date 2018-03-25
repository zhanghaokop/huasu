package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.MemberWeixin;
import java.util.List;

public interface MemberWeixinMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberWeixin record);

    MemberWeixin selectByPrimaryKey(String id);

    List<MemberWeixin> selectAll();

    List<MemberWeixin> pageSelect(MemberWeixin record);

    Integer getNotReadAllCountByOpenId(String openId);

    int updateByPrimaryKey(MemberWeixin record);
}