package com.applicateAI.cool.model;

import javax.persistence.*;

@Entity
public class Catalog {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int sku_code;

private String sku_name;
private String sku_description;
private String brand_name;
private String brand_description;

@OneToOne
@JoinColumn(name="supplier_id")
private Supplier supplier;

public void setSupplier(Supplier supplier)
{
this.supplier=supplier;
}
public Supplier getSupplier()
{
return this.supplier;
}

public int getSku_code() {
	return sku_code;
}
public void setSku_code(int sku_code) {
	this.sku_code = sku_code;
}
public String getSku_name() {
	return sku_name;
}
public void setSku_name(String sku_name) {
	this.sku_name = sku_name;
}
public String getSku_description() {
	return sku_description;
}
public void setSku_description(String sku_description) {
	this.sku_description = sku_description;
}
public String getBrand_name() {
	return brand_name;
}
public void setBrand_name(String brand_name) {
	this.brand_name = brand_name;
}
public String getBrand_description() {
	return brand_description;
}
public void setBrand_description(String brand_description) {
	this.brand_description = brand_description;
}

}
