package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Admin")
public class Administrator extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

}
