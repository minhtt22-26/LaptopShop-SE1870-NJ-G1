/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Product {

    private int id;
    public Brand brand;
    private Category category;
    public String name;
    private String status;

    public Product() {
    }

    public Product(int id, Brand brand, Category category, String name, String status) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.name = name;
        this.status = status;
    }

    public Product(int id, String name) {
        this.id = id;

        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", brand=" + brand + ", category=" + category + ", name=" + name + ", status=" + status + '}';
    }
    
    
    
}
