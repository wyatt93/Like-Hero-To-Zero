import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class EmissionslisteController implements Serializable{
	
	@Inject
	private Emissionsliste emissionsliste;
	
	@Inject
	private EmissionDAO emissionDAO;
	
    private Emission neuerEintrag = new Emission();
    
    
    //Daten aus der Datenbank in emissionsliste überschreiben. Zuerst bestehende Liste leeren, dann mit neuen Daten befüllen
    public void loadData() {
        emissionsliste.getListe().clear();
        emissionsliste.getListe().addAll(emissionDAO.getAll());
    }
    
    //neuen Eintrag abrufen
    public Emission getNeuerEintrag() {
        return neuerEintrag;
    }

    //neuen Eintrag mit Daten füllen
    public void setNeuerEintrag(Emission neuerEintrag) {
        this.neuerEintrag = neuerEintrag;
    }
    
    //Neuen Eintrag der Liste hinzufügen und zurück zur memberView
    public String addEintrag() {
        emissionsliste.add(neuerEintrag);

        neuerEintrag = new Emission();
        
        return "memberView";
    }
    
    //abbruch und zurück zur memberView
    public String abbruch() {
    	return "memberView";
    }
	
	
}