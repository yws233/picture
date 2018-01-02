package cn.easybuy.service.user;

import cn.easybuy.pojo.User;

public interface UserService {
    public User getUserByLoginName(String loginName);

    public boolean save(User user);
}
