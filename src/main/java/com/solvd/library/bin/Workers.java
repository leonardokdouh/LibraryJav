package com.solvd.library.bin;

import java.util.Objects;

public class Workers {

    private Long id;

    private String name;

    private String gender;

    private int shifts;

    public Workers(String name, String gender, int shifts) {
        this.name = name;
        this.gender = gender;
        this.shifts = shifts;
    }

    public Workers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getShifts() {
        return shifts;
    }

    public void setShifts(int shifts) {
        this.shifts = shifts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workers)) return false;
        Workers workers = (Workers) o;
        return shifts == workers.shifts && Objects.equals(id, workers.id) && Objects.equals(name, workers.name) && Objects.equals(gender, workers.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, shifts);
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", shifts=" + shifts +
                '}';
    }
}

