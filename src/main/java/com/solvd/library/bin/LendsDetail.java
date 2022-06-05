package com.solvd.library.bin;

import java.util.Objects;

public class LendsDetail {

    private Long id = null;
    private Long lendsId;
    private Long workersId;

    public LendsDetail(Long id, Long lendsId, Long workersId) {
        this.id = id;
        this.lendsId = lendsId;
        this.workersId = workersId;
    }

    public LendsDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLendsId() {
        return lendsId;
    }

    public void setLendsId(Long lendsId) {
        this.lendsId = lendsId;
    }

    public Long getWorkersId() {
        return workersId;
    }

    public void setWorkersId(Long workersId) {
        this.workersId = workersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LendsDetail)) return false;
        LendsDetail that = (LendsDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(lendsId, that.lendsId) && Objects.equals(workersId, that.workersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lendsId, workersId);
    }

    @Override
    public String toString() {
        return "LendsDetail{" +
                "id=" + id +
                ", lendsId=" + lendsId +
                ", workersId=" + workersId +
                '}';
    }
}
