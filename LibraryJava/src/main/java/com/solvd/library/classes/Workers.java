package com.solvd.library.classes;

public class Workers {

    private Long id = null;

    private String name;

    private String gender;

    private int shifts;

    public Workers(Long id, String name, String gender, int shifts) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.shifts = shifts;
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
}
