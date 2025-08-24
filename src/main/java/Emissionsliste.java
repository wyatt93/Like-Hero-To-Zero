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
			liste.add(new Emission("CHN", "China", 10077.44, 10190.85, 10734.63, 10688.8, false));
			liste.add(new Emission("USA", "United States", 4595.91, 4098.51, 4385.2, 4442.62, false));
			liste.add(new Emission("ABC", "ABC Land", 3323.99, 4000.02, 3800.22, 3442.80, true));
			
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