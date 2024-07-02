package com.resumebuilder.models;

public class Skill {
    private String name;
    private boolean isHardSkill;

    public Skill(String name, boolean isHardSkill) {
        this.name = name;
        this.isHardSkill = isHardSkill;
    }

    // Getters and setters...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHardSkill() {
        return isHardSkill;
    }

    public void setHardSkill(boolean hardSkill) {
        isHardSkill = hardSkill;
    }

    @Override
    public String toString() {
        return name + (isHardSkill ? " (Hard Skill)" : " (Soft Skill)");
    }
}
