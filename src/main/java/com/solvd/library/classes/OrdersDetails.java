package com.solvd.library.classes;

public class OrdersDetails {

    private Long id;

    private Long ordersId;

    private Long booksForSaleId;

    private Long workersId;

    private int shippingTypeId;

    private int payMethodId;

    private int totalOrder;

    public OrdersDetails(Long id, Long ordersId, Long booksForSaleId,
                         Long workersId, int shippingTypeId, int payMethodId, int totalOrder) {
        this.id = id;
        this.ordersId = ordersId;
        this.booksForSaleId = booksForSaleId;
        this.workersId = workersId;
        this.shippingTypeId = shippingTypeId;
        this.payMethodId = payMethodId;
        this.totalOrder = totalOrder;
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
