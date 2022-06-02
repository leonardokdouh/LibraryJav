package com.solvd.library.bin;

import java.util.Objects;

public class Lends {

    private Long id = null;

    private Long usersId;

    public Lends(Long id, Long usersId) {
        this.id = id;
        this.usersId = usersId;
    }

    public Lends() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lends)) return false;
        Lends lends = (Lends) o;
        return Objects.equals(id, lends.id) && Objects.equals(usersId, lends.usersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersId);
    }

    @Override
    public String toString() {
        return "Lends{" +
                "id=" + id +
                ", usersId=" + usersId +
                '}';
    }


}
