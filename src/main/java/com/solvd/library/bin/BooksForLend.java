package com.solvd.library.bin;

import java.util.Objects;

public class BooksForLend {

    private Long id = null;
    private String name;
    private String editorial;
    private int esn;
    private int days;
    private Long booksId;

    public BooksForLend(String name, String editorial, int esn, int days, Long booksId) {
        this.name = name;
        this.editorial = editorial;
        this.esn = esn;
        this.booksId = booksId;
        this.days = days;
    }

    public BooksForLend() {
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

    public int getEsn() {
        return esn;
    }

    public void setEsn(int esn) {
        this.esn = esn;
    }

    public Long getBooksId() {
        return booksId;
    }

    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BooksForLend)) return false;
        BooksForLend that = (BooksForLend) o;
        return esn == that.esn && days == that.days && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(editorial, that.editorial) && Objects.equals(booksId, that.booksId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, editorial, esn, days, booksId);
    }

    @Override
    public String toString() {
        return "BooksForLend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", editorial='" + editorial + '\'' +
                ", esn=" + esn +
                ", days=" + days +
                ", booksId=" + booksId +
                '}';
    }
}
