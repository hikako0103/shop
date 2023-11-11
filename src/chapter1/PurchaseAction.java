package chapter1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PurchaseAction extends Action{
    public String execute(HttpServletRequest request, HttpServletResponse response
            )throws Exception{
        
                HttpSession session = request.getSession();
                
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                if(name.isEmpty() || address.isEmpty()) {
                    return "purchase-error-empty.jsp";
                }
                
                PurchaseDAO dao = new PurchaseDAO();
                List<Item> cart = (List<Item> )session.getAttribute("cart");
                if(cart == null || !dao.insert(cart, name, address)) {
                    return "purchase-error-insert";
                }
                
                session.removeAttribute("cart");
                return "purchase-out.jsp";
    }
    
}
