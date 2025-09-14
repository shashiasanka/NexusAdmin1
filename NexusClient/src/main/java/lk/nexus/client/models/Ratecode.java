package lk.nexus.client.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratecode")
public class Ratecode {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String pickup_barnchcode;	
	private String tobarnch;	
	private Long distance;	
	private Long chargeprice;
	private String ratetype;
	private String tobarnchcode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getPickup_barnchcode() {
		return pickup_barnchcode;
	}
	public void setPickup_barnchcode(String pickup_barnchcode) {
		this.pickup_barnchcode = pickup_barnchcode;
	}
	public String getTobarnch() {
		return tobarnch;
	}
	public void setTobarnch(String tobarnch) {
		this.tobarnch = tobarnch;
	}
	public Long getDistance() {
		return distance;
	}
	public void setDistance(Long distance) {
		this.distance = distance;
	}
	public Long getChargeprice() {
		return chargeprice;
	}
	public void setChargeprice(Long chargeprice) {
		this.chargeprice = chargeprice;
	}
	public String getRatetype() {
		return ratetype;
	}
	public void setRatetype(String ratetype) {
		this.ratetype = ratetype;
	}
	public String getTobarnchcode() {
		return tobarnchcode;
	}
	public void setTobarnchcode(String tobarnchcode) {
		this.tobarnchcode = tobarnchcode;
	}
	
	@Override
	public String toString() {
		return "Ratecode [id=" + id + ", pickup_barnchcode=" + pickup_barnchcode + ", tobarnch=" + tobarnch
				+ ", distance=" + distance + ", chargeprice=" + chargeprice + ", ratetype=" + ratetype
				+ ", tobarnchcode=" + tobarnchcode + "]";
	}
	
	
	
	
	
	
}
