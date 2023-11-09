package chapter1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action{
    public String execute(HttpServletRequest request, HttpServletResponse response
            )throws Exception{
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("cust") != null) {
            session.removeAttribute("cust");
            return "logout-out.jsp";
        }
        
        return "logout-error.jsp";
    }
    
}
