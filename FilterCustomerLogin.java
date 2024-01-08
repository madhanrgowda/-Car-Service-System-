

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterCustomerLogin
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/FilterCustomerLogin" }, servletNames = { "CustomerLogin" })
public class FilterCustomerLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterCustomerLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		String cun=request.getParameter("cun");
		String cpwd=request.getParameter("cpwd");
		if(cun.length()!=0&&cpwd.length()!=0)
		{
			chain.doFilter(request, response);

		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/CarService/errorCustomerLogin.html");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
