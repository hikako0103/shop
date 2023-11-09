package chapter1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        CustomerDAO dao = new CustomerDAO();
        Customer cust = dao.search(login, password);
        
        if (cust != null) {
            session.setAttribute("cust", cust);
            return "login-out.jsp";
        }
        
        return "login-error.jsp";
    }
    
}
