import entity.Department;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Author: Johnathan McAllister (McAdmin)
 * Date: 2026-06-28
 * Course:
 * Professor:
 * <p>
 * Purpose:
 * -
 * <p>
 * Constraints:
 * -
 */

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = emf.createEntityManager();
    private static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {


        try {
            tx.begin();

            Department dept = em.find(Department.class, 2);
            Employee dalia = new Employee();

            dalia.setId(6);
            dalia.setFirstName("Dalia");
            dalia.setLastName("Abo Sheasha");
            dalia.setDept(dept);
            em.persist(dalia);


            tx.commit();
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            em.close();
            emf.close();
        }

    }

}
