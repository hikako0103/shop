package chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String url = "jdbc:postgresql://localhost:5432/shop";
    private static final String user = "postgres";
    private static final String password = "postgres";
    
    //JDBCドライバの定義
    //エラーになるtry~catchの中じゃないとだめ
    //Class.forName("org.postgresql.Driver");
    
    /**
     * データベースの接続を取得する。
     * @return データベースの接続
     * @throws SQLException データベースアクセスエラー
     */
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return con;
    }
}
