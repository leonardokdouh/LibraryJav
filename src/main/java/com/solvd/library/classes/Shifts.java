package com.solvd.library.classes;

public class Shifts {

    private Long id= null;

    private String turns;

    private int hours;

    private Long workersId;

    public Shifts(Long id, String turns, int hours, Long workersId) {
        this.id = id;
        this.turns = turns;
        this.hours = hours;
        this.workersId = workersId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurns() {
        return turns;
    }

    public void setTurns(String turns) {
        this.turns = turns;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Long getWorkersId() {
        return workersId;
    }

    public void setWorkersId(Long workersId) {
        this.workersId = workersId;
    }
}
