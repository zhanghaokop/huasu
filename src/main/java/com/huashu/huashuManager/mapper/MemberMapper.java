package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Member;
import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(Member record);

    Member selectByPrimaryKey(String id);

    List<Member> selectAll();
    //模糊分页条件查询
    List<Member> pageSelect(Member record);

    int updateByPrimaryKey(Member record);
}