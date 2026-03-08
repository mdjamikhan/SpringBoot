package com.lpu.MobileApp.entity;

 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Mobile {
	
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brandName;
	private String modelName;
	private double price;
	private String ram;
	private int storage;
	private String color;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private FileData fileData;
	
	
	
	
	
	
	
	
	
	
	
	
	public FileData getFileData() {
		return fileData;
	}

	public void setFileData(FileData fileData) {
		this.fileData = fileData;
	}

	public int getId() {
		return id;
	}
 
	public Mobile() {
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
				+ ", ram=" + ram + ", storage=" + storage + ", color=" + color + ", fileData=" + fileData + "]";
	}
	
	
	
	
	
	
	
	

}
