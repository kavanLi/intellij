package com.gcbi.damo.service;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gcbi.cloud.common.core.utils.BeanCopyUtils;
import com.gcbi.damo.domain.UserDto;
import com.gcbi.damo.rpt.UserMapper;
import com.gcbi.damo.rpt.eo.UserEo;

@Service
@Transactional
public class UserServicve {

    @Autowired
    UserMapper userMapper;


    /**
     * 判断用户是否存在(通过userId)
     */
    public boolean IsExist(String userId) {
        Assert.hasText(userId, "user must not be null ！");
        UserEo eo = userMapper.findOneByMemberId(userId);
        if (eo != null) {
            //用户名已存在
            return true;
        }
        return false;
    }


    /**
     * 修改或保存用户信息
     */
    @Transactional
    public UserDto updateOrSaveUser(UserDto dto) {
        Assert.notNull(dto, "user must not be null ！");
        UserEo eo = userMapper.findOneByMemberId(dto.getMemberId());
        if (eo != null) {
            if (StringUtils.isNotBlank(dto.getUserName())) {
                eo.setUserName(dto.getUserName());
            }
            if (StringUtils.isNotBlank(dto.getRemark())) {
                eo.setRemark(dto.getRemark());
            }
        } else {
            UserEo eo1 = BeanCopyUtils.copyBean2EO(dto, UserEo.class);
            userMapper.addUserInfo(eo1);
        }
        return dto;
    }

}
