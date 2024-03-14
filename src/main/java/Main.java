import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.PaySlipGeneratorService;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        PaySlipGeneratorService paySlipGeneratorService = new PaySlipGeneratorService(sessionFactory);

        paySlipGeneratorService.setDataInDb();

        sessionFactory.close();
    }

}
