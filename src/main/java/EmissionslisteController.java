import java.io.Serializable;
import java.util.List;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class EmissionslisteController implements Serializable{
	
	@Inject
	private Emissionsliste emissionsliste;
	
	@Inject
	private LoginController loginController;
	
	@Inject
	private EmissionDAO emissionDAO;
	
    private Emission neuerEintrag = new Emission();
    
    
    //Daten aus der Datenbank in emissionsliste überschreiben. Zuerst bestehende Liste leeren, dann mit neuen Daten befüllen
    public void loadData() {
        emissionsliste.getListe().clear();
        emissionsliste.getListe().addAll(emissionDAO.getAll());
    }
    
    public void getAllFreigegeben() {
    	emissionsliste.getListe().clear();
    	emissionsliste.getListe().addAll(emissionDAO.getAllFreigegeben());
    }
    
    //abspeichern von Änderungen in die Datenbank
    public void saveAll() {
    	emissionDAO.saveAll(emissionsliste.getListe());
    }
    
    //getter für die Liste
    public List<Emission> getEmissionen() {
    	return emissionsliste.getListe();
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
       // emissionsliste.add(neuerEintrag);
    	String benutzer = loginController.getName();
    	
        //neuen Eintrag in die Datenbank schreiben
        emissionDAO.add(neuerEintrag);
        
        //Formular leeren
        neuerEintrag = new Emission();
    	
    	if ("Admin".equals(benutzer))
    		return "adminView";
    	else
    		return "memberView";
    }
    
    //abbruch und zurück zur adminView / memberView
    public String abbruch() {
    	
    	String benutzer = loginController.getName();
    	
    	if ("Admin".equals(benutzer))
    		return "adminView";
    	else
    		return "memberView";
    }
	
	
}