package chapter1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartRemoveAction extends Action{
    public String execute(HttpServletRequest request, HttpServletResponse response
            )throws Exception{
        
                HttpSession session = request.getSession();
                List<Item> cart = (List<Item>)session.getAttribute("cart");
                int id = Integer.parseInt(request.getParameter("id"));
                for(Item i : cart) {
                    if(i.getProduct().getId()== id) {
                        cart.remove(i);
                        break;
                    }
                }
                return "cart.jsp";
    }
    
}
