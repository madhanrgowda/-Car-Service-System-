

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarCheck
 */
@WebServlet("/CarCheck")
public class CarCheck extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession();
		String cun=(String) hs.getAttribute("cun");
		
		Model m=new Model();
		m.setCun(cun);
		
		int x=m.carcheck1();
		if(x==1)
		{
			String mname=m.getMname();
			String mtype=m.getMtype();
			String carnum=m.getCarnum();
			hs.setAttribute("mname", mname);
			hs.setAttribute("mtype", mtype);
			hs.setAttribute("carnum", carnum);


			response.sendRedirect("/CarService/showCarDetails.jsp");
		}
		else
		{
			response.sendRedirect("/CarService/failureshowCarDetails.html");

		}
		
	}

}
