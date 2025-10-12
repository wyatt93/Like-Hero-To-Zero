import jakarta.persistence.*;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmissionDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeZeroToHeroPersistenceUnit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction t = em.getTransaction();
	
	public List<Emission> getAll() {
        return em.createQuery("SELECT e FROM Emission e", Emission.class).getResultList();
    }
	
	public void saveAll(List<Emission> emissionen) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            for (Emission e : emissionen) {
                em.merge(e);
            }
            t.commit();
        } catch (Exception ex) {
            if (t.isActive()) {
                t.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }
}