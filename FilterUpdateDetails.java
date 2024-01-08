

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
 * Servlet Filter implementation class FilterUpdateDetails
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/FilterUpdateDetails" }, servletNames = { "UpdateDetails" })
public class FilterUpdateDetails implements Filter {

    /**
     * Default constructor. 
     */
    public FilterUpdateDetails() {
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
		String mname=request.getParameter("mname");
		String mtype=request.getParameter("mtype");
		String carnum=request.getParameter("carnum");
		
		if(mname.length()!=0||mtype.length()!=0||carnum.length()!=0)
		{
			chain.doFilter(request, response);

		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/CarService/errorUpdateDetails.html");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
