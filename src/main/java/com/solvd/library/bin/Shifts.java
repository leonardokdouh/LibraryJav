package com.solvd.library.bin;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shifts)) return false;
        Shifts shifts = (Shifts) o;
        return hours == shifts.hours && Objects.equals(id, shifts.id) && Objects.equals(turns, shifts.turns) && Objects.equals(workersId, shifts.workersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, turns, hours, workersId);
    }

    @Override
    public String toString() {
        return "Shifts{" +
                "id=" + id +
                ", turns='" + turns + '\'' +
                ", hours=" + hours +
                ", workersId=" + workersId +
                '}';
    }
}
