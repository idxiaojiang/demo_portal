package com.portal.login.dao;

import com.portal.login.entity.UserAccountDetailVO;
import com.portal.login.entity.UserInfoDetailVO;

public interface ILoginDao {
	UserAccountDetailVO getUserLoginAccount(UserInfoDetailVO infoDetailVO);
}
