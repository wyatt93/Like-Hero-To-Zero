import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;


@Named
@ApplicationScoped
public class Emissionsliste implements Serializable {
	private static Emissionsliste instance = new Emissionsliste();
	private List<Emission> liste = new ArrayList<Emission>();
	

	public Emissionsliste() {
			
	}

	public static Emissionsliste getInstance() {
		return instance;
	}

	public List<Emission> getListe() {
		return liste;
	}
	
	public void add(Emission neueEmission) {
        liste.add(neueEmission);
    }
}