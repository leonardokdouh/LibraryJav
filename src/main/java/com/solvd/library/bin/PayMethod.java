package com.solvd.library.bin;

import java.util.Objects;

public class PayMethod {

    private Long id;
    private String method;

    public PayMethod(Long id, String method) {
        this.id = id;
        this.method = method;
    }
    public PayMethod(String method) {
        this.method = method;
    }

    public PayMethod() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayMethod)) return false;
        PayMethod payMethod = (PayMethod) o;
        return Objects.equals(id, payMethod.id) && Objects.equals(method, payMethod.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method);
    }

    @Override
    public String toString() {
        return "PayMethod{" +
                "id=" + id +
                ", method='" + method + '\'' +
                '}';
    }
}
