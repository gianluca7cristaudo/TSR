
public class RevisoreJunior extends Revisore {

	public RevisoreJunior(String nome, String cognome, String email, String nazionalita, int anni_esperienza, String password) {
		super(nome, cognome, email, nazionalita, anni_esperienza,password);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Valutazione getValutazione(Revisore revisoreJ,int voto_t, int voto_o, int voto_p, int voto_ov,String commento,String giudizio) {
		return new ValutazioneJunior(revisoreJ,voto_t,voto_o,voto_p,voto_ov);
	}
	
}
