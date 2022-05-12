package com.solvd.library.classes;

public class BooksForSale {

    private Long id = null;

    private String name;

    private String editorial;

    private int price;

    private Long booksId;


    public BooksForSale(Long id, String name, String editorial, int type, Long booksId) {
        this.id = id;
        this.name = name;
        this.editorial = editorial;
        this.price = type;
        this.booksId = booksId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getBooksId() {
        return booksId;
    }

    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }
}

