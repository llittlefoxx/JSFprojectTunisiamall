package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idImage;

	private String imagePath;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idProduct")
	//@JsonBackReference
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