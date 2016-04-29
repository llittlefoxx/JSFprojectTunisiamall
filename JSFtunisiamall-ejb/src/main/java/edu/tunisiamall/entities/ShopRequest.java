package edu.tunisiamall.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

import edu.tunisiamall.entities.Category;

@Entity
public class ShopRequest implements Serializable {

	private Integer idRequest;
	private String description;

	private Date rcptDate;
	private boolean status;

	private Date plannedOpeningDate;
	private Integer rentPeriod;
	private boolean storeInMall;

	private Category category;

	private String firstName;
	private String lastName;
	private Date birthdate;
	private String email;
	private String address;
	private String phone;
	private String job;

	private static final long serialVersionUID = 1L;

	public ShopRequest() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	public Date getRcptDate() {
		return this.rcptDate;
	}

	public void setRcptDate(Date rcptDate) {
		this.rcptDate = rcptDate;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((idRequest == null) ? 0 : idRequest.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((plannedOpeningDate == null) ? 0 : plannedOpeningDate.hashCode());
		result = prime * result + ((rcptDate == null) ? 0 : rcptDate.hashCode());
		result = prime * result + ((rentPeriod == null) ? 0 : rentPeriod.hashCode());

		result = prime * result + (storeInMall ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopRequest other = (ShopRequest) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idRequest == null) {
			if (other.idRequest != null)
				return false;
		} else if (!idRequest.equals(other.idRequest))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (plannedOpeningDate == null) {
			if (other.plannedOpeningDate != null)
				return false;
		} else if (!plannedOpeningDate.equals(other.plannedOpeningDate))
			return false;
		if (rcptDate == null) {
			if (other.rcptDate != null)
				return false;
		} else if (!rcptDate.equals(other.rcptDate))
			return false;
		if (rentPeriod == null) {
			if (other.rentPeriod != null)
				return false;
		} else if (!rentPeriod.equals(other.rentPeriod))
			return false;

		if (storeInMall != other.storeInMall)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopRequest [idRequest=" + idRequest + ", description=" + description + ", rcptDate=" + rcptDate
				+ ", status=" + status + ", plannedOpeningDate=" + plannedOpeningDate + ", rentPeriod=" + rentPeriod
				+ ", storeInMall=" + storeInMall + ", category=" + category + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthdate=" + birthdate + ", email=" + email + ", address=" + address + ", phone="
				+ phone + ", job=" + job + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@ManyToOne
	@JoinColumn(name = "category_fk")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Temporal(TemporalType.DATE)
	public Date getPlannedOpeningDate() {
		return plannedOpeningDate;
	}

	public void setPlannedOpeningDate(Date plannedOpeningDate) {
		this.plannedOpeningDate = plannedOpeningDate;
	}

	public Integer getRentPeriod() {
		return rentPeriod;
	}

	public void setRentPeriod(Integer rentPeriod) {
		this.rentPeriod = rentPeriod;
	}

	public boolean isStoreInMall() {
		return storeInMall;
	}

	public void setStoreInMall(boolean storeInMall) {
		this.storeInMall = storeInMall;
	}

}
