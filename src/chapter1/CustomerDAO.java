package chapter1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO extends DAO {
    public Customer search(String login, String password) throws Exception {
        Customer cust = null;
        
        Connection con = getConnection();
        
        PreparedStatement st;
        st = con.prepareStatement("SELECT * FROM Customer WHERE login = ? and password = ?");
        st.setString(1, login);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            cust = new Customer();
            cust.setId(rs.getInt("id"));
            cust.setLogin(rs.getString("login"));
            cust.setPassword(rs.getString("password"));
        }
        
        st.close();
        con.close();
        return cust;
    }
    
}
