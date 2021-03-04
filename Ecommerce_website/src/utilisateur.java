
import java.io.Serializable;

public class utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public int user_id;
	public String nom;
	public String prenom;
	public String email;
	public String date_naissance;
	public String pays;
	public String ville;
	public String code_postal;
	public String password;
	
	
	
	public utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public utilisateur(int user_id, String nom, String prenom, String email, String date_naissance, String pays,
			String ville, String code_postal, String password) {
		super();
		this.user_id = user_id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.date_naissance = date_naissance;
		this.pays = pays;
		this.ville = ville;
		this.code_postal = code_postal;
		this.password = password;
		
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}

	
	
	


}
