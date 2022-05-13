package com.solvd.library.bin;

public class Lends {

    private Long id= null;

    private Long usersId;

    public Lends(Long id, Long usersId) {
        this.id = id;
        this.usersId = usersId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }
}
