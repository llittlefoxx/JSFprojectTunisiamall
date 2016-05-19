package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "image")
@NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idImage;

	private String imagePath;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	public Image() {
	}

	public int getIdImage() {
		return this.idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}