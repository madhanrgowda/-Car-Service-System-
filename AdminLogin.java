

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
   
	@Override
		protected void service(HttpServletRequest re, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			
			String aun=re.getParameter("aun");
			String apwd=re.getParameter("apwd");
			
			Model a=new Model();
			a.setApwd(apwd);
			a.setAun(aun);
			
			int p=a.adminLogin();
			if(p==1)
			{
				res.sendRedirect("/CarService/adminHome1.jsp");
			}
			else
			{
				res.sendRedirect("/CarService/failureadmin.html");
			}
			
		}

}
