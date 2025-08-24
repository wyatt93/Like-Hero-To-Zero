import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class EmissionslisteController implements Serializable{
	
	@Inject
	private Emissionsliste emissionsliste;
	
    private Emission neuerEintrag = new Emission();


    public Emission getNeuerEintrag() {
        return neuerEintrag;
    }

    public void setNeuerEintrag(Emission neuerEintrag) {
        this.neuerEintrag = neuerEintrag;
    }

    public String addEintrag() {
        emissionsliste.add(neuerEintrag);

        neuerEintrag = new Emission();
        
        return "memberView";
    }
    
    public String abbruch() {
    	return "memberView";
    }
	
	
}