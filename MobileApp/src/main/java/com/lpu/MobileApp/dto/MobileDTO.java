package com.lpu.MobileApp.dto;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 import jakarta.validation.constraints.NotBlank;


 

public class MobileDTO  implements Serializable{
    private static final long serialVersionUID = 1L;

	
	
 
	private int id;
	
	@NotBlank(message="brandName is not  empity")
	private String brandName;
	private String modelName;
	private double price;
	private String ram;
	private int storage;
	private String color;
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MobileDTO() {
		super();
 	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", brandName=" + brandName + ", modelName=" + modelName + ", price=" + price
				+ ", ram=" + ram + ", storage=" + storage + ", color=" + color + "]";
	}
	
	
	
	

}
