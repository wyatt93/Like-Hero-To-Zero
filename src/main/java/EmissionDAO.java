import jakarta.persistence.*;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmissionDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeZeroToHeroPersistenceUnit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction t = em.getTransaction();
	
	//alle Datensätze auslesen
	public List<Emission> getAll() {
        return em.createQuery("SELECT e FROM Emission e", Emission.class).getResultList();
    }
	
	//nur freigegebene Datensätze auslesen
	public List<Emission> getAllFreigegeben() {
	    return em.createQuery("SELECT e FROM Emission e WHERE e.istFreigegeben = true", Emission.class).getResultList();
	}

	
	public void saveAll(List<Emission> emissionen) {
        
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        for (Emission e : emissionen)
        	em.merge(e);
        
        t.commit();
    }
	
	public void add(Emission neuerEintrag) {
		EntityTransaction t = em.getTransaction();
        
        t.begin();
        
        em.persist(neuerEintrag);
        
        t.commit();
	}
}