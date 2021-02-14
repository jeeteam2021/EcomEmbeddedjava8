

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Product> Produits = new ArrayList<Product>();

	String htmlproducts = "<section class=\"section latest__products\" id=\"latest\">\r\n"
			+ "        <div class=\"title__container\">\r\n"
			+ "          <div class=\"section__title active\" data-id=\"Latest Products\">\r\n"
			+ "            <span class=\"dot\"></span>\r\n"
			+ "            <h1 class=\"primary__title\">Resultat de recherche</h1>\r\n"
			+ "          </div>\r\n"
			+ "        </div>\r\n"
			+ "        <div class=\"container\" data-aos=\"fade-up\" data-aos-duration=\"1200\">\r\n"
			+ "          <div class=\"glide\" id=\"glide_2\">\r\n"
			+ "            <div class=\"glide__track\" data-glide-el=\"track\">\r\n"
			+ "              <ul class=\"glide__slides latest-center\">\r\n";
    public SearchServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/searchresult.jsp";
		
		String ProductSearch = request.getParameter("productsearch");
		
		Search(ProductSearch);
		htmlproducts = htmlproducts+"<div class=\"glide__arrows\" data-glide-el=\"controls\">\r\n"
				+ "          <button class=\"glide__arrow glide__arrow--left\" data-glide-dir=\"<\">\r\n"
				+ "            <svg>\r\n"
				+ "              <use xlink:href=\"./images/sprite.svg#icon-arrow-left2\"></use>\r\n"
				+ "            </svg>\r\n"
				+ "          </button>\r\n"
				+ "          <button class=\"glide__arrow glide__arrow--right\" data-glide-dir=\">\">\r\n"
				+ "            <svg>\r\n"
				+ "              <use xlink:href=\"./images/sprite.svg#icon-arrow-right2\"></use>\r\n"
				+ "            </svg>\r\n"
				+ "          </button>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </section>\r\n";
		
		request.setAttribute("htmlproducts", htmlproducts);
		getServletContext().getRequestDispatcher(url).forward(request, response);
		htmlproducts = "<section class=\"section latest__products\" id=\"latest\">\r\n"
				+ "        <div class=\"title__container\">\r\n"
				+ "          <div class=\"section__title active\" data-id=\"Latest Products\">\r\n"
				+ "            <span class=\"dot\"></span>\r\n"
				+ "            <h1 class=\"primary__title\">Resultat de recherche</h1>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"container\" data-aos=\"fade-up\" data-aos-duration=\"1200\">\r\n"
				+ "          <div class=\"glide\" id=\"glide_2\">\r\n"
				+ "            <div class=\"glide__track\" data-glide-el=\"track\">\r\n"
				+ "              <ul class=\"glide__slides latest-center\">\r\n";
	}

	protected void Search(String Product){
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/EcomProject";
			String user = "JEE";
			String pwd ="0000";
			con = DriverManager.getConnection(url,user,pwd);
			Statement S = con.createStatement();
			String query = "select * from produit where product_name like '%"+Product+"%';";
			ResultSet rs = S.executeQuery(query);
			if(!rs.next()) {
				htmlproducts = htmlproducts + "<h3>n'ya pas plus de produits</h3>";
			}
			else {
			while(rs.next())
	        {
				Product produit = new Product();
	            produit.setProduct_Id(rs.getString(1));
	            produit.setProduct_Name(rs.getString(2));
	            produit.setProduct_Image(rs.getString(3));
	            produit.setProduct_Description(rs.getString(4));
	            produit.setProduct_Price(rs.getInt(5));
	            Produits.add(produit);
	           
	            	 
	            htmlproducts = htmlproducts+"<li class=\"glide__slide\">\r\n"
	            		+ "                  <div class=\"product\">\r\n"
	            		+ "                    <div class=\"product__header\">\r\n"
	            		+ "                      <img src=\"images/adidas4.jpeg\" alt=\"product\">\r\n"
	            		+ "                    </div>\r\n"
	            		+ "                    <div class=\"product__footer\">\r\n"
	            		+ "                      <h3>"+produit.getProduct_Name()+"</h3>\r\n"
	            		+ "                      <div class=\"rating\">\r\n"
	            		+ "                        <svg>\r\n"
	            		+ "                          <use xlink:href=\"./images/sprite.svg#icon-star-full\"></use>\r\n"
	            		+ "                        </svg>\r\n"
	            		+ "                        <svg>\r\n"
	            		+ "                          <use xlink:href=\"./images/sprite.svg#icon-star-full\"></use>\r\n"
	            		+ "                        </svg>\r\n"
	            		+ "                        <svg>\r\n"
	            		+ "                          <use xlink:href=\"./images/sprite.svg#icon-star-full\"></use>\r\n"
	            		+ "                        </svg>\r\n"
	            		+ "                        <svg>\r\n"
	            		+ "                          <use xlink:href=\"./images/sprite.svg#icon-star-empty\"></use>\r\n"
	            		+ "                        </svg>\r\n"
	            		+ "                        <svg>\r\n"
	            		+ "                          <use xlink:href=\"./images/sprite.svg#icon-star-empty\"></use>\r\n"
	            		+ "                        </svg>\r\n"
	            		+ "                      </div>\r\n"
	            		+ "                      <div class=\"product__price\">\r\n"
	            		+ "                        <h4>"+produit.getProduct_Price()+"</h4>\r\n"
	            		+ "                      </div>\r\n"
	            		+ "                      <form action=\"butt1\" method=\"Post\">            \r\n"
	            		+ "                      <a href=\"#\"><button type=\"submit\" class=\"product__btn\" value=\"8\" name=\"action\">Add To Cart</button></a>\r\n"
	            		+ "                      </form>\r\n"
	            		+ "                    </div>\r\n"
	            		+ "                    <ul>\r\n"
	            		+ "                      <li>\r\n"
	            		+ "                        <a data-tip=\"Quick View\" data-place=\"left\" href=\"#\">\r\n"
	            		+ "                          <svg>\r\n"
	            		+ "                            <use xlink:href=\"./images/sprite.svg#icon-eye\"></use>\r\n"
	            		+ "                          </svg>\r\n"
	            		+ "                        </a>\r\n"
	            		+ "                      </li>\r\n"
	            		+ "                      <li>\r\n"
	            		+ "                        <a data-tip=\"Add To Wishlist\" data-place=\"left\" href=\"#\">\r\n"
	            		+ "                          <svg>\r\n"
	            		+ "                            <use xlink:href=\"./images/sprite.svg#icon-heart-o\"></use>\r\n"
	            		+ "                          </svg>\r\n"
	            		+ "                        </a>\r\n"
	            		+ "                      </li>\r\n"
	            		+ "                      <li>\r\n"
	            		+ "                        <a data-tip=\"Add To Compare\" data-place=\"left\" href=\"#\">\r\n"
	            		+ "                          <svg>\r\n"
	            		+ "                            <use xlink:href=\"./images/sprite.svg#icon-loop2\"></use>\r\n"
	            		+ "                          </svg>\r\n"
	            		+ "                        </a>\r\n"
	            		+ "                      </li>\r\n"
	            		+ "                    </ul>\r\n"
	            		+ "                  </div>\r\n"
	            		+ "                </li>";
	            

	        	}
			}
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
