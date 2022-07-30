package mandacaru_ativ1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "estates")
public class Estate {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String address;
	private double area;
	private double areaBuilt; 
	private int rooms;
	private int bathrooms;
	private int parking_spaces;
	private double price;
	
	public Estate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estate(int id, String title, String address, double area, double areaBuilt, int rooms, int bathrooms,
			int parking_spaces, double price) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.area = area;
		this.areaBuilt = areaBuilt;
		this.rooms = rooms;
		this.bathrooms = bathrooms;
		this.parking_spaces = parking_spaces;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getAreaBuilt() {
		return areaBuilt;
	}
	public void setAreaBuilt(double areaBuilt) {
		this.areaBuilt = areaBuilt;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getParking_spaces() {
		return parking_spaces;
	}
	public void setParking_spaces(int parking_spaces) {
		this.parking_spaces = parking_spaces;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Estate [id=" + id + ", title=" + title + ", address=" + address + ", area=" + area + ", areaBuilt="
				+ areaBuilt + ", rooms=" + rooms + ", bathrooms=" + bathrooms + ", parking_spaces=" + parking_spaces
				+ ", price=" + price + "]";
	}
	
}
