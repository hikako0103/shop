package chapter1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DAO{
    
    public List<Product> search(String keyword) throws Exception{
        List<Product> list = new ArrayList<>();
        
        Connection con = getConnection();
        
        PreparedStatement st = con.prepareStatement("SELECT * FROM Product where name like ?");
        st.setString(1, "%" + keyword + "%");
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            list.add(p);
        }
        st.close();
        con.close();
        
        return list;
    }
    public int insert(Product product)throws Exception{
        Connection con = getConnection();
        //オートコミットfalse
        con.setAutoCommit(false);
        ResultSet rs;
        
        PreparedStatement st = con.prepareStatement("INSERT INTO Product (name, price) VALUES (?, ?)");
        st.setString(1, product.getName());
        st.setInt(2, product.getPrice());
        st.executeUpdate();
        
        st = con.prepareStatement("SELECT * FROM Product WHERE name = ?");
        st.setString(1, product.getName());
        rs = st.executeQuery();
        int line = 0;
        while(rs.next()) {
            line++;
        }
        if(line == 1) {
            con.commit();
            //out.println("商品を登録しました。" + line2);
        } else {
            con.rollback();
            //out.println("商品はすでに登録されています。" + line2);
        }
        con.setAutoCommit(true);
        
        st.close();
        con.close();
        return line;
    }
    
}
