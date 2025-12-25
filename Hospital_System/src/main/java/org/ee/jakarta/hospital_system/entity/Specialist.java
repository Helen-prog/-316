package org.ee.jakarta.hospital_system.entity;

public class Specialist {
    private int id;
    private String specialistName;

    public Specialist() {
    }

    public Specialist(int id, String specialistName) {
        this.id = id;
        this.specialistName = specialistName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }
}
