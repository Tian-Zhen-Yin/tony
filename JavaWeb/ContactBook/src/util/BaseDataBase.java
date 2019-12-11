package util;

import java.sql.*;

public class BaseDataBase {
    Connection connection=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

    //获取数据库连接，使用properties
    public boolean getCon()
    {
        try{
            Class.forName(ConfigManager.getInstance().getString("jdbc.driver"));
            //获取连接Connection
            String url=ConfigManager.getInstance().getString("jdbc.connection.url");
            //
            String user_name=ConfigManager.getInstance().getString("jdbc.connection.username");

            String password=ConfigManager.getInstance().getString("jdbc.connection.password");

            connection= DriverManager.getConnection(url,user_name,password);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int executeUpdate(String sql, Object[] params) {
        int updateRows = 0;
        if (this.getCon()) {
            try {
                pstmt = connection.prepareStatement(sql);
                //填充占位符
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
                updateRows = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updateRows;
    }

    //查询文件
    public ResultSet executeQuery(String sql, Object[] params) {
        if (this.getCon()) {
            try {
                pstmt = connection.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
                rs = pstmt.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public boolean closeResource() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
