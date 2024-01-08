

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cun=request.getParameter("cun");
		String cpwd=request.getParameter("cpwd");
		
		Model m=new Model();
		m.setCun(cun);
		m.setCpwd(cpwd);
		
		int p=m.customerLogin10();
		if(p==1)
		{
			String cname=m.getCname();
			HttpSession session=request.getSession();
			session.setAttribute("cname", cname);
			session.setAttribute("cun", cun);
			response.sendRedirect("/CarService/customerHome.jsp");
		}
		else
		{
			response.sendRedirect("/CarService/failureCustomerLogin.html");

			
		}
		
	}

}
