package com.solvd.library.classes;

public class BooksForSale {

    private Long id=null;

    private String name;

    private String editorial;

    private int type;

    private Long booksId;

    private Long booksCargoId;

    public BooksForSale(Long id, String name, String editorial, int type, Long booksId, Long booksCargoId) {
        this.id = id;
        this.name = name;
        this.editorial = editorial;
        this.type = type;
        this.booksId = booksId;
        this.booksCargoId = booksCargoId;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getBooksId() {
        return booksId;
    }

    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    public Long getBooksCargoId() {
        return booksCargoId;
    }

    public void setBooksCargoId(Long booksCargoId) {
        this.booksCargoId = booksCargoId;
    }
}
