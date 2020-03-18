
public class ValutazioneSenior implements Valutazione{
	
	private String commento,giudizio;
	private Revisore revisoreS;
	
	//COSTRUTTORE
	public ValutazioneSenior(Revisore revisoreS, String commento, String giudizio) {
		this.revisoreS=revisoreS;
		this.commento=commento;
		this.giudizio=giudizio;
	}
	
	// METODI
	
	@Override
	public String toString() {
		return "commento: "+commento+"\n"+"giudizio: "+giudizio;
	}

	//METODI SET E GET
	public void setCommento(String commento) {
		this.commento=commento;
	}
	
	public String getCommento() {
		return commento;
	}
	
	public void setGiudizio(String giudizio) {
		this.giudizio=giudizio;
	}
	
	public String getGiudizio() {
		return giudizio;
	}
	
	public void setRevisoreSenior(Revisore revisoreS) {
		this.revisoreS=revisoreS;
	}
	
	public Revisore getRevisore() {
		return revisoreS;
	}
	
}
