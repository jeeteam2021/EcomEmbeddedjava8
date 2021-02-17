import java.io.Serializable;
import java.sql.Date;  


public class cart {
	private static final long serialVersionUID = 1L;
	public int cart_id;
    private int product_id;
	private int product_quantity;
	Date CREATE_Date;
	public cart(int cart_id, int product_id, int product_quantity, Date cREATE_Date) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.product_quantity = product_quantity;
		CREATE_Date = cREATE_Date;
	}
	public cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public Date getCREATE_Date() {
		return CREATE_Date;
	}
	public void setCREATE_Date(Date cREATE_Date) {
		CREATE_Date = cREATE_Date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
