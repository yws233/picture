package cn.easybuy.dao.user;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.pojo.User;
import cn.easybuy.utils.EmptyUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    public User tableToClass(ResultSet rs) throws Exception{
        User user = new User();
        user.setLoginName(rs.getString("loginName"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setIdentityCode(rs.getString("identityCode"));
        user.setEmail(rs.getString("email"));
        user.setMobile(rs.getString("mobile"));
        user.setType(rs.getInt("type"));
        user.setId(rs.getInt("id"));
        return user;
    }

    @Override
    public User getUserByLoginName(String loginName) throws Exception{
        StringBuffer sql = new StringBuffer("SELECT * FROM easybuy_user WHERE 1 = 1");
        List<Object> params = new ArrayList<>();

        if (!EmptyUtils.isEmpty(loginName)){
            sql.append("and loginName = ?");
            params.add(loginName);
        }
        ResultSet rs = executeQuery(sql.toString(),params.toArray());
        User user = null;
        while (rs.next()){
            user = tableToClass(rs);
        }
        return user;
    }

    @Override
    public int save(User user) {
        Integer id = 0;
        StringBuffer sql = new StringBuffer("INSERT into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile) values(?,?,?,?,?,?,?)");
        Object[] params = new Object[]{user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile()};
        id = this.executeInsert(sql.toString(),params);
        return id;
    }
}
