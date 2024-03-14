package employees;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "java_developers")
public class JavaDeveloper extends Employee {
    private String toolName;

    @Enumerated(EnumType.STRING)
    private Experience experience;
    private double baseSalary = 6000;

    public JavaDeveloper(Long id, String name, String surName, String toolName, Experience experience) {
        super(id, name, surName);
        this.toolName = toolName;
        this.experience = experience;
        switch (experience) {
            case JUNIOR:
                this.baseSalary = baseSalary;
            case MID:
                this.baseSalary = baseSalary * 1.5;
            case SENIOR:
                this.baseSalary = baseSalary * 2;
            default:
                this.baseSalary = baseSalary;
        }
    }

    @Override
    public void generatePaySlip() {
        System.out.println("Name: " + getName() + " " + getSurname());
        System.out.println("Position: Java Developer");
        System.out.println("Experience: " + getExperience());
        System.out.println("Salary: " + getBaseSalary());
    }
}

