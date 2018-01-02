package cn.easybuy.dao;

import java.sql.*;

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
    // 新增返回主键值
    public int executeInsert(String sql,Object[] params){
        Long id = 0L;
        try {
            pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0;i < params.length; i++){
                pstm.setObject(i + 1,params[i]);
            }
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()){
                id = rs.getLong(1); //获取主键id值
            }
        } catch (SQLException e) {
            e.printStackTrace();
            id = null;
        }

        return id.intValue();
    }

    //增加、删除、修改
    public int executeUpdate(String sql, Object[] params){
        int updateRows = 0;
        try {
            pstm = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++){
                pstm.setObject(i + 1,params[i]);
            }
            updateRows = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            updateRows = -1;
        }

        return updateRows;

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
