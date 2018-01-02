package cn.easybuy.service.user;

import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.pojo.User;
import cn.easybuy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private Connection connection;
    private UserDao userDao;

    @Override
    public User getUserByLoginName(String loginName) {
        User user = null;
        try {
            connection = DataSourceUtil.openConnection();
            userDao = new UserDaoImpl(connection);
            user = userDao.getUserByLoginName(loginName);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DataSourceUtil.closeConnection(connection);
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        boolean flag = true;
        try {
            connection = DataSourceUtil.openConnection();
            userDao = new UserDaoImpl(connection);
            int count = userDao.save(user);
            flag = count > 0;  //如果count>0,则返回true
            return flag;
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }finally {
            DataSourceUtil.closeConnection(connection);
        }
        return flag;
    }
}
