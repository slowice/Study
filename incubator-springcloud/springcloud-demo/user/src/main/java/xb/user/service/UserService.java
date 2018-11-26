package xb.user.service;

import org.springframework.stereotype.Service;
import xb.user.dataObject.UserInfo;

public interface UserService {
    UserInfo findByOpenid(String openid);
}
