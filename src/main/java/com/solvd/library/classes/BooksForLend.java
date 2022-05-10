package com.solvd.library.classes;

public class BooksForLend {

    private Long id=null;

    private String name;

    private String editorial;

    private int esn;

    private Long booksId;

    private Long booksCargoesId;

    public BooksForLend(Long id, String name, String editorial, int esn, Long booksId, Long booksCargoesId) {
        this.id = id;
        this.name = name;
        this.editorial = editorial;
        this.esn = esn;
        this.booksId = booksId;
        this.booksCargoesId = booksCargoesId;
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

    public Long getBooksCargoesId() {
        return booksCargoesId;
    }

    public void setBooksCargoesId(Long booksCargoesId) {
        this.booksCargoesId = booksCargoesId;
    }
}
