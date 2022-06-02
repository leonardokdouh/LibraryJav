package com.solvd.library.bin;

import com.solvd.library.services.jaxBParser.DateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "ordersDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersDetails {
    @XmlAttribute(name = "id")
    private Long id;

    @XmlElement(name = "ordersid")
    private Long ordersId;

    @XmlElement(name = "booksForSaleId")
    private Long booksForSaleId;

    @XmlElement(name = "workersId")
    private Long workersId;

    @XmlElement(name = "shippingTypeId")
    private int shippingTypeId;

    @XmlElement(name = "payMethodId")
    private int payMethodId;

    @XmlElement(name = "address")
    private String address;

    @XmlElement(name = "dateOfOrder")
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private Date date;

    @XmlElement(name = "totalOrder")
    private int totalOrder;

    public OrdersDetails(Long id, Long ordersId, Long booksForSaleId,
                         Long workersId, int shippingTypeId, int payMethodId, String address, Date date, int totalOrder) {
        this.id = id;
        this.date = date;
        this.ordersId = ordersId;
        this.booksForSaleId = booksForSaleId;
        this.workersId = workersId;
        this.shippingTypeId = shippingTypeId;
        this.payMethodId = payMethodId;
        this.address = address;
        this.totalOrder = totalOrder;
    }

    public OrdersDetails() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdersDetails)) return false;
        OrdersDetails that = (OrdersDetails) o;
        return shippingTypeId == that.shippingTypeId && payMethodId == that.payMethodId && totalOrder == that.totalOrder && Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(ordersId, that.ordersId) && Objects.equals(booksForSaleId, that.booksForSaleId) && Objects.equals(workersId, that.workersId) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, ordersId, booksForSaleId, workersId, address, shippingTypeId, payMethodId, totalOrder);
    }

    @Override
    public String toString() {
        return "OrdersDetails{" +
                "id=" + id +
                ", date=" + date +
                ", ordersId=" + ordersId +
                ", booksForSaleId=" + booksForSaleId +
                ", workersId=" + workersId +
                ", address='" + address + '\'' +
                ", shippingTypeId=" + shippingTypeId +
                ", payMethodId=" + payMethodId +
                ", totalOrder=" + totalOrder +
                '}';
    }
}
