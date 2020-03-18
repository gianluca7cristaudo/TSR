
public class ValutazioneJunior implements Valutazione {
	
	private int voto_technical, voto_originality, voto_presentation,voto_overall;
	private double voto_medio;
	private Revisore revisoreJ;

	// COSTRUTTORE
	public ValutazioneJunior(Revisore revisoreJ,int voto_t, int voto_o, int voto_p, int voto_ov) {
		this.revisoreJ=revisoreJ;
		this.voto_technical=voto_t;
		this.voto_originality=voto_o;
		this.voto_presentation=voto_p;
		this.voto_overall=voto_ov;
		voto_medio=(voto_t+voto_o+voto_p+voto_ov)/4;
	}
	
	//METODI
	@Override
	public String toString() {
		return "voto technical: "+voto_technical+"\n"+"voto originality: "+voto_originality+"\n"+"voto presentation: "+voto_presentation+"\n"+"voto overall: "+voto_overall+"\n"+"voto medio: "+voto_medio;
	}
	
	// METODI SET E GET
	public void setVoto_technical(int voto) {
		voto_technical=voto;
	}
	
	public int getVoto_technical() {
		return voto_technical;
	}
	
	public void setVoto_originality(int voto) {
		voto_originality=voto;
	}
	
	public int getVoto_originality() {
		return voto_originality;
	}
	
	public void setVoto_presentation(int voto) {
		voto_presentation=voto;
	}
	
	public int getVoto_presentation() {
		return voto_presentation;
	}
	
	public void setVoto_overall(int voto) {
		voto_overall=voto;
	}
	
	public int getVoto_overall() {
		return voto_overall;
	}
	
	public void setVoto_medio(double voto) {
		voto_medio=voto;
	}
	
	public double getVoto_medio() {
		return voto_medio;
	}
	
	public void setRevisoreJunior(Revisore revisoreJ) {
		this.revisoreJ=revisoreJ;
	}
	
	public Revisore getRevisoreJunior() {
		return revisoreJ;
	}
	
}
