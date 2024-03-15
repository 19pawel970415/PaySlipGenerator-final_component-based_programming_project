package service;

import employees.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Data
@AllArgsConstructor
public class PaySlipGeneratorService {

    public SessionFactory sessionFactory;

    public void setDataInDb() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            JavaDeveloper javaJunior1 = new JavaDeveloper(null, "John", "Doe", "login", "password", "IntelliJ", Experience.JUNIOR);
            session.save(javaJunior1);

            JavaDeveloper javaJunior2 = new JavaDeveloper(null, "Alice", "Johnson", "login1", "password1", "NetBeans", Experience.JUNIOR);
            session.save(javaJunior2);

            JavaDeveloper javaMid1 = new JavaDeveloper(null, "Jane", "Smith", "login2", "password2", "Eclipse", Experience.MID);
            session.save(javaMid1);

            JavaDeveloper javaMid2 = new JavaDeveloper(null, "Bob", "Brown", "login3", "password3", "VS Code", Experience.MID);
            session.save(javaMid2);

            CSharpDeveloper cSharpJunior1 = new CSharpDeveloper(null, "Mark", "Davis", "login4", "password4", "Visual Studio", Experience.JUNIOR);
            session.save(cSharpJunior1);

            CSharpDeveloper cSharpMid1 = new CSharpDeveloper(null, "Emma", "Taylor", "login5", "password5", "Visual Studio Code", Experience.MID);
            session.save(cSharpMid1);

            CppDeveloper cppMid1 = new CppDeveloper(null, "David", "Lee", "login6", "password6", "CLion", Experience.MID);
            session.save(cppMid1);

            FrontEndDeveloper frontEndMid1 = new FrontEndDeveloper(null, "Olivia", "White", "login7", "password7", "Sublime Text", Experience.MID);
            session.save(frontEndMid1);

            DatabaseAnalyst dbAnalystMid1 = new DatabaseAnalyst(null, "Liam", "Harris", "login8", "password8", "MySQL Workbench", Experience.MID);
            session.save(dbAnalystMid1);

            PythonDeveloper pythonDeveloper1 = new PythonDeveloper(null, "James", "Bond", "login9", "password9", "PyCharm", Experience.SENIOR);
            session.save(pythonDeveloper1);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generatePaySlipForEmployee(String login) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Employee employee = session.createQuery("FROM Employee WHERE login = :login", Employee.class)
                    .setParameter("login", login)
                    .getSingleResult();

            transaction.commit();
            session.close();

            if (employee != null) {
                employee.generatePaySlip();
            } else {
                System.out.println("Pracownik o podanym loginie nie został znaleziony.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
