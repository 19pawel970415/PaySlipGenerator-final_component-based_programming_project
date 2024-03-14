package employees;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "frontend_developers")
public class FrontEndDeveloper extends Employee {
    private String toolName;

    @Enumerated(EnumType.STRING)
    private Experience experience;
    private double baseSalary = 3500;

    public FrontEndDeveloper(Long id, String name, String surName, String toolName, Experience experience) {
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
        System.out.println("Position: Front End Developer");
        System.out.println("Experience: " + getExperience());
        System.out.println("Salary: " + getBaseSalary());
    }
}

