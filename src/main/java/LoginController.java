import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;


@Named
@SessionScoped
public class LoginController implements Serializable{
	
	String name;
	Benutzer benutzer;
	
	List<Benutzer> benutzerListe;
	
	public LoginController() {
		this.benutzerListe = new ArrayList<Benutzer>();
		this.benutzerListe.add(new Benutzer("Admin", "123"));
		this.benutzerListe.add(new Benutzer("User", "456"));
		this.benutzer = new Benutzer();
	}
	
	public void postValidateName(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput)ev.getComponent();
		this.name = (String)temp.getValue();
	}
	
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		for(Benutzer b:benutzerListe) {
			Benutzer temp = new Benutzer(this.name, (String)value);
			if (b.equals(temp))
				return;
		}
		throw new ValidatorException(new FacesMessage("Login falsch!"));
	}
	
	public String login() {
		if (this.name.equals("Admin"))
			return "adminView";
		else
			return "memberView";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public List<Benutzer> getBenutzerListe() {
		return benutzerListe;
	}

	public void setBenutzerListe(List<Benutzer> benutzerListe) {
		this.benutzerListe = benutzerListe;
	}
	
}