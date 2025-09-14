package lk.nexus.client.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "districts")
public class Districts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 private String province_id;
	 private String name_en;
	 private String name_si;
	 private String name_ta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvince_id() {
		return province_id;
	}
	public void setProvince_id(String province_id) {
		this.province_id = province_id;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getName_si() {
		return name_si;
	}
	public void setName_si(String name_si) {
		this.name_si = name_si;
	}
	public String getName_ta() {
		return name_ta;
	}
	public void setName_ta(String name_ta) {
		this.name_ta = name_ta;
	}
	 
	 
	 
}
