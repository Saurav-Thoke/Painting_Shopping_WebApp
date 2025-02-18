package com.login;

public class Product {
	private int id;
	private String name;
	private String category;
	private String psize;
	private int price;
	private String image;
	
	public Product() {
		
	}

	public Product(int id, String name, String category, String psize, int price, String image) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.psize = psize;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return psize;
	}

	public void setSize(String size) {
		this.psize = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", size=" + psize + ", price=" + price
				+ ", image=" + image + "]";
	}
	

}
