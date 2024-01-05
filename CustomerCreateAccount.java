

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerCreateAccount
 */
@WebServlet("/CustomerCreateAccount")
public class CustomerCreateAccount extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest re, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname=re.getParameter("cname");
		String cun=re.getParameter("cun");
		String cemail=re.getParameter("cemail");
		String cpwd=re.getParameter("cpwd");
		
		Model m =new Model();
		m.setCemail(cemail);
		m.setCname(cname);
		m.setCpwd(cpwd);
		m.setCun(cun);
		
		int x=m.customerCreateAccount();
		if(x==1)
		{
			res.sendRedirect("/CarService/customerLogin2.html");
		}
		else
		{
			res.sendRedirect("/CarService/failurecustomerLogin.html");

		}
		
	}

	

}
