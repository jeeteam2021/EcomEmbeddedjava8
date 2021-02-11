

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/Search.jsp";
		String ProductSearch = request.getParameter("productsearch");
		Search(ProductSearch);
		
	
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	protected void Search(String Product_Name){
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/EcomProject";
			String user = "JEE";
			String pwd ="0000";
			con = DriverManager.getConnection(url,user,pwd);
			Statement S = con.createStatement();
			String query = "select * from employee where employee_name='"+emp_name+"' or department='"+emp_dept+"' or email='"+email+"' order by employee_name";;
			S.executeQuery(query);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException f){
			f.printStackTrace();
		}
		finally {}
	}
}
