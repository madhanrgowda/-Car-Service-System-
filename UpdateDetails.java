

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mname=request.getParameter("mname");
		String mtype=request.getParameter("mtype");
		String carnum=request.getParameter("carnum");
		HttpSession session=request.getSession();
		String cname=(String) session.getAttribute("cname");
		String cun=(String) session.getAttribute("cun");
		Model m =new Model();
		m.setCname(cname);
		m.setCun(cun);
		m.setMname(mname);
		m.setMtype(mtype);
		m.setCarnum(carnum);
		
		int x=m.updateDetails9();
		if(x==1)
		{
			response.sendRedirect("/CarService/successUpdateDetails.html");
		}
		else
		{
			response.sendRedirect("/CarService/failureUpdateDetails.html");

		}
		
	}

}
