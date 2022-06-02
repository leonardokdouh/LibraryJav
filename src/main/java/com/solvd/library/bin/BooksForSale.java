package com.solvd.library.bin;

import java.util.Objects;

public class BooksForSale {

    private Long id = null;

    private String name;

    private String editorial;

    private int price;

    private Long booksId;


    public BooksForSale(String name, String editorial, int type, Long booksId) {
        this.name = name;
        this.editorial = editorial;
        this.price = type;
        this.booksId = booksId;
    }

    public BooksForSale() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BooksForSale)) return false;
        BooksForSale that = (BooksForSale) o;
        return price == that.price && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(editorial, that.editorial) && Objects.equals(booksId, that.booksId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, editorial, price, booksId);
    }

    @Override
    public String toString() {
        return "BooksForSale{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", editorial='" + editorial + '\'' +
                ", price=" + price +
                ", booksId=" + booksId +
                '}';
    }
}

