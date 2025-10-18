import jakarta.persistence.*;

@Entity
@Table(name = "Emission") //Zuordnung zur richtigen Tabelle in der Datenbank
public class Emission {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String iso;
	private String land;
	private double emission2019;
	private double emission2020;
	private double emission2021;
	private double emission2022;
	private boolean istFreigegeben;
	
	public Emission() {
		
	}
	
	public Emission(String iso, String land, double e19, double e20, double e21, double e22, boolean istFreigegeben) {
		this.iso = iso;
		this.land = land;
		this.emission2019 = e19;
		this.emission2020 = e20;
		this.emission2021 = e21;
		this.emission2022 = e22;
		this.istFreigegeben = istFreigegeben;
	}
	

	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public double getEmission2019() {
		return emission2019;
	}
	public void setEmission2019(double emission2019) {
		this.emission2019 = emission2019;
	}
	public double getEmission2020() {
		return emission2020;
	}
	public void setEmission2020(double emission2020) {
		this.emission2020 = emission2020;
	}
	public double getEmission2021() {
		return emission2021;
	}
	public void setEmission2021(double emission2021) {
		this.emission2021 = emission2021;
	}
	public double getEmission2022() {
		return emission2022;
	}
	public void setEmission2022(double emission2022) {
		this.emission2022 = emission2022;
	}
	public boolean isIstFreigegeben() {
		return istFreigegeben;
	}
	public void setIstFreigegeben(boolean istFreigegeben) {
		this.istFreigegeben = istFreigegeben;
	}
	
	
}