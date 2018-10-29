package com.gcbi.damo.rpt;

import org.apache.ibatis.annotations.Mapper;

import com.gcbi.damo.rpt.eo.UserEo;

@Mapper
public interface UserMapper {

    UserEo findOneByMemberId(String memberId);

    void addUserInfo(UserEo user);

    void updateUserInfo(UserEo user);
}
