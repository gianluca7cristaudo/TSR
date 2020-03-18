import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArticoloTest {

	@Test
	void Costruttore() {
		Articolo a= new Articolo();
		int valore=0;
		assertEquals(valore,a.getListaValutazioni().size());
	}
	
	@Test
	void testAssociaAutore() {
		Articolo a= new Articolo();
		int valore=1;
		Autore au= new Autore("gianluca","cristuado","cristaudo.gianluca6@gmail.com","prova","ciao1provaC");
		a.associaAutore(au);
		assertEquals(valore,a.getListaAutoriAssociati().size());
	}

	@Test
	void testAddRevisore() {
		Articolo a= new Articolo();
		int valore=2;
		RevisoreJunior Rj= new RevisoreJunior("sebastiano","rossi","rossi.sebastiano@gmail.com","italiana",2,"ciaoCiao2");
		a.addRevisore(Rj);
		RevisoreSenior Rs= new RevisoreSenior("sarah","basile","sarahb98@gmail.com","italiana",1,"Ciaociaoca");
		a.addRevisore(Rs);
		assertEquals(valore,a.getListaRevisoriAssociati().size());
	}

	@Test
	void testAddValutazione() {
		Articolo a= new Articolo();
		int valore=1;
		RevisoreJunior Rj= new RevisoreJunior("gianluca","cristaudo","cristaudo.gianluca6@gmail.com","italiana",2,"ciaoCiao2");
		a.addRevisore(Rj);
		ValutazioneJunior Vj= new ValutazioneJunior(Rj,5,5,5,5);
		a.addValutazione(Vj);
		assertEquals(valore,a.getListaValutazioni().size());
	}

	@Test
	void testAggiornaStato() {
		Articolo a= new Articolo();
		String valore="candidato_accettazione";
		RevisoreJunior Rj= new RevisoreJunior("gianluca","cristaudo","cristaudo.gianluca6@gmail.com","italiana",2,"ciaoCiao2");
		a.addRevisore(Rj);
		RevisoreSenior Rs= new RevisoreSenior("sarah","basile","sarahb98@gmail.com","italiana",1,"Ciaociaoca");
		a.addRevisore(Rs);
		ValutazioneJunior Vj= new ValutazioneJunior(Rj,5,5,5,5);
		a.addValutazione(Vj);
		ValutazioneSenior Vs= new ValutazioneSenior(Rs,"ok","accept");
		a.addValutazione(Vs);
		assertEquals(valore,a.getStato());
	}

	@Test
	void testDecisioneFinale() {
		Articolo a= new Articolo();
		Autore au= new Autore("gianluca","cristuado","cristaudo.gianluca6@gmail.com","prova","ciao1provaC");
		a.associaAutore(au);
		//int valore=1;
		String valore="candidato_accettazione";
		RevisoreJunior Rj= new RevisoreJunior("gianluca","cristaudo","cristaudo.gianluca6@gmail.com","italiana",2,"ciaoCiao2");
		a.addRevisore(Rj);
		RevisoreSenior Rs= new RevisoreSenior("sarah","basile","sarahb98@gmail.com","italiana",1,"Ciaociaoca");
		a.addRevisore(Rs);
		ValutazioneJunior Vj= new ValutazioneJunior(Rj,5,5,5,5);
		a.addValutazione(Vj);
		ValutazioneSenior Vs= new ValutazioneSenior(Rs,"ok","accept");
		a.addValutazione(Vs);
		a.decisioneFinale("da_valutare");
		Vj= new ValutazioneJunior(Rj,5,5,5,5);
		a.addValutazione(Vj);
		Vs= new ValutazioneSenior(Rs,"ok","accept");
		a.addValutazione(Vs);
		assertEquals(valore,a.getStato());
		//a.decisioneFinale("accettato");
		//assertEquals(valore,au.getListaArticoliAR().size());	
	}

}
