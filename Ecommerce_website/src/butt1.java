import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/butt1")
public class butt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public butt1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter( "action" );
		if("jk".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
			

		}
		if("2".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);

		}
		if("1".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product2.jsp").forward(request, response);

		}
		if("3".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product3.jsp").forward(request, response);

		}
		if("4".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product4.jsp").forward(request, response);

		}
		if("5".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product5.jsp").forward(request, response);

		}
		if("6".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product6.jsp").forward(request, response);

		}
		if("7".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product7.jsp").forward(request, response);

		}
		if("8".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product8.jsp").forward(request, response);

		}
		if("9".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product9.jsp").forward(request, response);

		}
		if("44".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/product9.jsp").forward(request, response);

		}
		if("10".equals(action))
		{
			this.getServletContext().getRequestDispatcher("/https://news.nike.com/news").forward(request, response);

		}
	}

}
