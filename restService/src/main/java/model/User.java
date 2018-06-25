package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsers;

	@Column(name="`e-mail`")
	private String e_mail;

	private String name;

	//bi-directional many-to-one association to Layer
	@OneToMany(mappedBy="user")
	private List<Layer> layers;

	public User() {
	}

	public int getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Layer> getLayers() {
		return this.layers;
	}

	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}

	public Layer addLayer(Layer layer) {
		getLayers().add(layer);
		layer.setUser(this);

		return layer;
	}

	public Layer removeLayer(Layer layer) {
		getLayers().remove(layer);
		layer.setUser(null);

		return layer;
	}

}