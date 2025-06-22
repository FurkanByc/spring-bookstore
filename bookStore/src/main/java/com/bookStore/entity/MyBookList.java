package com.bookStore.entity;

import javax.persistence.*;

@Entity
@Table(name="MyBooks")
public class MyBookList extends Book {
    
    // Book sınıfından id, name, author, price alanları miras alınır
    
    
    private String addedDate;  
    private String status;     
    
    // Parametresiz constructor
    public MyBookList() {
        super();
    }
    
    // Temel alanlar için constructor
    public MyBookList(int id, String name, String author, double price) {
        super(id, name, author, price);
    }
    
    // Tüm alanlar için constructor
    public MyBookList(int id, String name, String author, double price, String addedDate, String status) {
        super(id, name, author, price);
        this.addedDate = addedDate;
        this.status = status;
    }
    
    // Ek alanlar için getter-setter metodları
    public String getAddedDate() {
        return addedDate;
    }
    
    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "MyBookList{" +
               "id=" + getId() +
               ", name='" + getName() + '\'' +
               ", author='" + getAuthor() + '\'' +
               ", price=" + getPrice() +
               ", addedDate='" + addedDate + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}