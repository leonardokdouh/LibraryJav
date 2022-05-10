package com.solvd.library.classes;

import java.util.Date;

public class Orders {

    private Long id;

    private Date date;

    private Long customersId;

    public Orders(Long id, Date date, Long customersId) {
        this.id = id;
        this.date = date;
        this.customersId = customersId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCustomersId() {
        return customersId;
    }

    public void setCustomersId(Long customersId) {
        this.customersId = customersId;
    }
}
