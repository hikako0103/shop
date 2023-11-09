package chapter1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductAction extends Action{
    public String execute(HttpServletRequest request, HttpServletResponse response
            )throws Exception{
        
        HttpSession session = request.getSession();
        
        String keyword = request.getParameter("keyword");
        if(keyword == null) {
            keyword = "";
        }
        
        
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.search(keyword);
        
        session.setAttribute("list", list);
        
        return "product.jsp";
    }
}
