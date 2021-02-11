import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String Product_Id;
	private String Product_Name;
	private String Product_Image;
	private String Product_Description;
	private int Product_Price;
	public Product(String product_Id, String product_Name, String product_Image, String product_Description,
			int product_Price) {
		super();
		Product_Id = product_Id;
		Product_Name = product_Name;
		Product_Image = product_Image;
		Product_Description = product_Description;
		Product_Price = product_Price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(String product_Id) {
		Product_Id = product_Id;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public String getProduct_Image() {
		return Product_Image;
	}
	public void setProduct_Image(String product_Image) {
		Product_Image = product_Image;
	}
	public String getProduct_Description() {
		return Product_Description;
	}
	public void setProduct_Description(String product_Description) {
		Product_Description = product_Description;
	}
	public int getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(int product_Price) {
		Product_Price = product_Price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
