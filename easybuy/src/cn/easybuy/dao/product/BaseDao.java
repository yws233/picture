package cn.easybuy.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rs;

    public BaseDao(Connection connection) {
        this.connection = connection;
    }

    //查询
    public ResultSet executeQuery(String sql,Object[] params){
        ResultSet rs = null;
        try {
            pstm = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++){
                pstm.setObject(i+1,params[i]);
            }
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    //关闭资源
    public boolean closeResource(){
        try {
            if (null != null){
                rs.close();
            }
            if (null != pstm){
                pstm.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

}
