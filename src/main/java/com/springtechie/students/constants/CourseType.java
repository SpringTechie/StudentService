package com.springtechie.students.constants;

public enum CourseType {

    TECHNICAL("Technical"),
    MANAGEMENT("Management"),
    SOFT_SKILLS("Soft Skills");
    private final String skill;

    CourseType(String skill) {
        this.skill = skill;
    }

    public String getLabel() {
        return skill;
    }
}
