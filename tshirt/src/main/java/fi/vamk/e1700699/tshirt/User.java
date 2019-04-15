package fi.vamk.e1700699.tshirt;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String city;

	private String country;

	private String email;

	private int phone;

	@Column(name="user_name")
	private String user_name;

	//bi-directional many-to-one association to Myorder
	@OneToMany(mappedBy="user")
	private List<Myorder> myorders;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return this.user_name;
	}

	public void setUserName(String userName) {
		this.user_name = userName;
	}

	public List<Myorder> getMyorders() {
		return this.myorders;
	}

	public void setMyorders(List<Myorder> myorders) {
		this.myorders = myorders;
	}

	public Myorder addMyorder(Myorder myorder) {
		getMyorders().add(myorder);
		myorder.setUser(this);

		return myorder;
	}

	public Myorder removeMyorder(Myorder myorder) {
		getMyorders().remove(myorder);
		myorder.setUser(null);

		return myorder;
	}

}