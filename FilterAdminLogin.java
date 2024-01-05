

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FilterAdminLogin
 */
@WebServlet("/FilterAdminLogin")
public class FilterAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void dofilter(ServletRequest request , ServletResponse responce,FilterChain chain) throws IOException,SecurityException, ServletException
	{
		String aun=request.getParameter("aun");
		String apwd=request.getParameter("apwd");
		
		if(aun.length()!=0 && apwd.length()!=0)
		{
		chain.doFilter(request, responce);
		}
		else
		{
			((HttpServletResponse) responce).sendRedirect("/CarService/errorAdminLogin.html");
		}
	}

}
