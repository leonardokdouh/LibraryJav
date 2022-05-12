package com.solvd.library.classes;

import java.util.Date;

public class Orders {

    private Long id;


    private Long customersId;

    public Orders(Long id, Long customersId) {
        this.id = id;
        this.customersId = customersId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomersId() {
        return customersId;
    }

    public void setCustomersId(Long customersId) {
        this.customersId = customersId;
    }
}
