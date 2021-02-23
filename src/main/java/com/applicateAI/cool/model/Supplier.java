package com.applicateAI.cool.model;

import javax.persistence.*;


@Entity
public class Supplier {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="supplier_id")
private int id;

private String supplier_name;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSupplier_name() {
	return supplier_name;
}
public void setSupplier_name(String supplier_name) {
	this.supplier_name = supplier_name;
}
}
