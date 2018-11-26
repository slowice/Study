package xb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xb.user.dataObject.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);
}
