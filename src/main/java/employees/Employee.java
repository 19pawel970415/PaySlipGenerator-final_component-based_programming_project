package employees;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    public Employee(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public abstract void generatePaySlip();
}

