package fr.soat.hibernate.sample;

import fr.soat.hibernate.sample.fr.soat.hibernate.sample.internal.HibernateUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class TestApplication
        extends TestCase {
    public TestApplication(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestApplication.class);
    }

    public void testDePersistence() {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = session.beginTransaction();

            Application ta = new Application();
            ta.setName("toto");
            ta.setApplicationId(10);
            session.save(ta);
            tx.commit();

        } catch (Exception e) {
            fail("Error occurs : "+e.getMessage());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }
}
