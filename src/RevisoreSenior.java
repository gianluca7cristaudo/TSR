
public class RevisoreSenior extends Revisore {

	public RevisoreSenior(String nome, String cognome, String email, String nazionalita, int anni_esperienza, String password) {
		super(nome, cognome, email, nazionalita, anni_esperienza, password);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Valutazione getValutazione(Revisore revisoreS,int voto_t, int voto_o, int voto_p, int voto_ov,String commento,String giudizio) {
		return new ValutazioneSenior(revisoreS,commento,giudizio);
	}

}
