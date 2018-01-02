package cn.easybuy.dao.user;

import cn.easybuy.pojo.User;

public interface UserDao {
    // 根据用户账号，获取用户记录
    public User getUserByLoginName(String loginName) throws Exception;

    //用户注册
    public int save(User user);
}
