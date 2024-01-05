

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
 * Servlet Filter implementation class FilterForCustomerCreateAccount
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/FilterForCustomerCreateAccount" }, servletNames = { "CustomerCreateAccount" })
public class FilterForCustomerCreateAccount implements Filter {

    /**
     * Default constructor. 
     */
    public FilterForCustomerCreateAccount() {
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
		
		String cname=request.getParameter("cname");
		String cun=request.getParameter("cun");
		String cemail=request.getParameter("cemail");
		String cpwd=request.getParameter("cpwd");
		String ccpwd=request.getParameter("ccpwd");
		if(cname.length()!=0||cun.length()!=0||cemail.length()!=0||cpwd.length()!=0||ccpwd.length()!=0)
		{
			if(cpwd.equals(ccpwd))
			{
				chain.doFilter(request, response);

			}
			else
			{
				((HttpServletResponse) response).sendRedirect("/CarService/mismatchCustomerCreateAccount.html");
			}
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/CarService/emptyCustomerCreateAccount.html");

		}


	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
