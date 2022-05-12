package com.solvd.library.classes;

import java.util.Date;

public class OrdersDetails {

    private Long id;

    private  Date date;

    private Long ordersId;

    private Long booksForSaleId;

    private Long workersId;

    private String address;

    private int shippingTypeId;

    private int payMethodId;

    private int totalOrder;

    public OrdersDetails(Long id, Long ordersId, Long booksForSaleId,
                         Long workersId, int shippingTypeId, int payMethodId, String address, Date date,  int totalOrder) {
        this.id = id;
        this.date=date;
        this.ordersId = ordersId;
        this.booksForSaleId = booksForSaleId;
        this.workersId = workersId;
        this.shippingTypeId = shippingTypeId;
        this.payMethodId = payMethodId;
        this.address=address;
        this.totalOrder = totalOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public Long getBooksForSaleId() {
        return booksForSaleId;
    }

    public void setBooksForSaleId(Long booksForSaleId) {
        this.booksForSaleId = booksForSaleId;
    }

    public Long getWorkersId() {
        return workersId;
    }

    public void setWorkersId(Long workersId) {
        this.workersId = workersId;
    }

    public int getShippingTypeId() {
        return shippingTypeId;
    }

    public void setShippingTypeId(int shippingTypeId) {
        this.shippingTypeId = shippingTypeId;
    }

    public int getPayMethodId() {
        return payMethodId;
    }

    public void setPayMethodId(int payMethodId) {
        this.payMethodId = payMethodId;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }
}
