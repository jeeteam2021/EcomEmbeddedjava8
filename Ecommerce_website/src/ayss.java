


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/login")
public class ayss extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ayss() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/page1.jsp";
		PrintWriter out = response.getWriter();  
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(TestValidate(email, password)){  
    		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
 
        }  
        else{  
            out.print("Sorry username or password error");  
            getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
            
        }  
        }
        
	

public static boolean TestValidate(String email,String password){
	boolean status=false;
	Connection con;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost/EcomProject";
		String user = "JEE";
		String pwd ="0000";
		con = DriverManager.getConnection(url,user,pwd);
		Statement S = con.createStatement();
		String query = "select * from produit where email like '%"+email+"%' and password like '%"+password+"%';";
		ResultSet rs=S.executeQuery(query);  
		status=rs.next();
	}
	catch(Exception e){System.out.println(e);}  
	return status;  
	}  
	}
	

