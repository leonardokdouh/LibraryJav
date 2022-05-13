package com.solvd.library.bin;

public class LendsDetail {

    private Long id=null;

    private Long lendsId;

    private Long workersId;

    public LendsDetail(Long id, Long lendsId, Long workersId) {
        this.id = id;
        this.lendsId = lendsId;
        this.workersId = workersId;
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
}
