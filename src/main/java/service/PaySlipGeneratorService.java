package service;

import employees.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Data
@AllArgsConstructor
public class PaySlipGeneratorService {

    public SessionFactory sessionFactory;

    public void setDataInDb() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            JavaDeveloper javaJunior1 = new JavaDeveloper(null, "John", "Doe", "IntelliJ", Experience.JUNIOR);
            session.save(javaJunior1);

            JavaDeveloper javaJunior2 = new JavaDeveloper(null, "Alice", "Johnson", "NetBeans", Experience.JUNIOR);
            session.save(javaJunior2);

            JavaDeveloper javaMid1 = new JavaDeveloper(null, "Jane", "Smith", "Eclipse", Experience.MID);
            session.save(javaMid1);

            JavaDeveloper javaMid2 = new JavaDeveloper(null, "Bob", "Brown", "VS Code", Experience.MID);
            session.save(javaMid2);

            CSharpDeveloper cSharpJunior1 = new CSharpDeveloper(null, "Mark", "Davis", "Visual Studio", Experience.JUNIOR);
            session.save(cSharpJunior1);

            CSharpDeveloper cSharpMid1 = new CSharpDeveloper(null, "Emma", "Taylor", "Visual Studio Code", Experience.MID);
            session.save(cSharpMid1);

            CppDeveloper cppMid1 = new CppDeveloper(null, "David", "Lee", "CLion", Experience.MID);
            session.save(cppMid1);

            FrontEndDeveloper frontEndMid1 = new FrontEndDeveloper(null, "Olivia", "White", "Sublime Text", Experience.MID);
            session.save(frontEndMid1);

            DatabaseAnalyst dbAnalystMid1 = new DatabaseAnalyst(null, "Liam", "Harris", "MySQL Workbench", Experience.MID);
            session.save(dbAnalystMid1);

            PythonDeveloper pythonDeveloper1 = new PythonDeveloper(null, "James", "Bond", "PyCharm", Experience.SENIOR);
            session.save(pythonDeveloper1);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
