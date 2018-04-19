package com.exist.ecc.core.model;

import javax.persistence.*;

@Entity
@Table (name = "CONTACT")
public class Contact {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "contact_id_generator")
	@SequenceGenerator (name = "contact_id_generator", sequenceName = "contact_seq", allocationSize = 50)
	@Column (name = "id")
	private int id;

	@Column (name = "type")
	private String type;

	@Column (name = "detail")
	private String detail;

	public Contact() {}
	public Contact(String type, String detail) {
		this.type = type;
		this.detail = detail;
	}

	public int getId() {
    	return id;
    }

	public String getType() {
		return type;
	}

	public String getDetail() {
		return detail;
	}

 	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String toString() {
		return String.format("Contact_%s : %s", type, detail);
	}
}
