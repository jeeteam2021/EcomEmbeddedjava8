
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
        String date_naissance = request.getParameter("date_naissance");
        String pays = request.getParameter("pays");
        String ville = request.getParameter("ville"); 
        String  code_postal = request.getParameter("code_postal"); 
        String  password = request.getParameter("password");
       
        try {
        	Connection con;
        	Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/ecomproject";
			String user = "JEE";
			String pwd ="0000";
			con = DriverManager.getConnection(url,user,pwd);
            PreparedStatement ps = con.prepareStatement("insert into utilisateur values(?,?,?,?,?,?,?,?)");
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setString(3,email);
            ps.setString(4,date_naissance);
            ps.setString(5,pays);
            ps.setString(6,ville);
            ps.setString(7,code_postal);
            ps.setString(8,password);   
            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("You are sucessfully registered");
                RequestDispatcher rs = request.getRequestDispatcher("page1.jsp");
                rs.include(request, response);
            }
		utilisateur cust = new utilisateur();
        cust.nom=nom;
        cust.prenom=prenom;
        cust.email=email;
        cust.date_naissance=date_naissance;
        cust.pays=pays;
        cust.ville=ville;
        cust.code_postal=code_postal;
        cust.password=password;
        request.setAttribute("cust", cust);
    
		
	}
        
        catch(Exception se) {
            se.printStackTrace();
        }
	
        
		
	}
}
