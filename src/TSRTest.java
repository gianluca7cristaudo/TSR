import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TSRTest {
	
	@Test
	void testRegistrazioneAutore() {
		TSR prova= TSR.getIstanza();
		int valore=1;
		prova.registrazioneAutore("gianluca", "cristaudo", "cristaudo.gianluca6@gmail.com", "prova", "ciao");
		prova.registrazioneAutore("gianluca", "cristaudo", "cristaudo.gianluca6", "prova", "ciaoCiao1");
		prova.registrazioneAutore("gianluca", "cristaudo", "cristaudo.gianluca6@gmail.com", "prova", "ciaoCiao1");
		prova.registrazioneAutore("gianluca", "cristaudo", "cristaudo.gianluca6@gmail.com", "prova", "ciaoCiao1");
		assertEquals(valore,prova.getListaAutori().size());
	}

	@Test
	void testRegistrazioneRevisoreSenior() {
		TSR prova= TSR.getIstanza();
		int valore=1;
		prova.registrazioneRevisore("sarah", "basile", "sarahb98@gmail.com", "italiana", 1, "ciao", "senior");
		prova.registrazioneRevisore("sarah", "basile", "sarahb98gmail.com", "italiana", 1, "ciaoCiao2", "senior");
		prova.registrazioneRevisore("sarah", "basile", "sarahb98@gmail.com", "italiana", 1, "ciaoCiao2", "senior");
		prova.registrazioneRevisore("sarah", "basile", "sarahb98@gmail.com", "italiana", 1, "ciaoCiao2", "senior");
		assertEquals(valore,prova.getListaRevisoriSenior().size());
	}
	
	@Test
	void testRegistrazioneRevisoreJunior() {
		TSR prova= TSR.getIstanza();
		int valore=1;
		prova.registrazioneRevisore("paolo", "rossi", "paolor@gmail.com", "italiana", 1, "ciao", "Junior");
		prova.registrazioneRevisore("paolo", "rossi", "paolorgmail.com", "italiana", 1, "ciaoCiao2", "Junior");
		prova.registrazioneRevisore("paolo", "rossi", "paolor@gmail.com", "italiana", 1, "ciaoCiao2", "Junior");
		prova.registrazioneRevisore("paolo", "rossi", "paolor@gmail.com", "italiana", 1, "ciaoCiao2", "Junior");
		assertEquals(valore,prova.getListaRevisoriJunior().size());
	}

	@Test
	void testInValutazione() {
		/*TSR nuovo = TSR.getIstanza();
		int valore=1;
		nuovo.registrazioneAutore("gianluca", "cristaudo", "prova@gmail.com", "ciao", "Ciao1ciao");
        nuovo.autenticazioneAutore("prova@gmail.com", "Ciao1ciao");
        nuovo.registrazioneRevisore("gianlu", "cio", "gianlu@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Senior");
        nuovo.registrazioneRevisore("sarahdd", "basiled", "sb1@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Senior");
        nuovo.registrazioneRevisore("sarahd", "basiledd", "sb2@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");
        nuovo.registrazioneRevisore("vedi", "ba", "vba@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");       
        nuovo.registrazioneRevisore("sarah", "basile", "sb@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");     
        nuovo.nuovoArticolo();
        nuovo.setDatiArticolo("prova", "ciao", 6, "okok");
        nuovo.autenticazioneRevisore("sb@hotmail.it", "ciaoCiaoCiao3");
        nuovo.confermaSottomissioneArticolo();
        nuovo.inValutazione("", "", 5, 5, 5, 5);
		assertEquals(valore,nuovo.getListaArticoli().get(0).getListaValutazioni().size());*/
	}

	@Test
	void testNuovoArticolo() {
		TSR prova = TSR.getIstanza();
		int valore=1;
		prova.registrazioneAutore("gianluca", "cristaudo", "cristaudo.gianluca6@gmail.com", "prova", "ciaoCiao1");
		prova.autenticazioneAutore("cristaudo.gianluca6@gmail.com","ciaoCiao1");
		prova.nuovoArticolo();
		assertEquals(valore,prova.getListaAutoriDaAggiungereAllArticolo().size());
	}

	@Test
	void testInserisciAutore() {
		TSR prova = TSR.getIstanza();
		int valore=2;
		prova.registrazioneAutore("gianluca", "cristaudo", "cristaudo.gianluca6@gmail.com", "prova", "ciaoCiao1");
		prova.registrazioneAutore("sarah", "basile", "prova@gmail.com", "ciao", "Ciao1ciao");
		prova.autenticazioneAutore("cristaudo.gianluca6@gmail.com","ciaoCiao1");
		prova.nuovoArticolo();
		prova.inserisciAutore("prova@gmail.com");
		assertEquals(valore,prova.getListaAutoriDaAggiungereAllArticolo().size());
	}

	@Test
	void testSetDatiArticolo() {
		TSR prova = TSR.getIstanza();
		String valore="ricerca op";
		prova.registrazioneAutore("gianluca", "cristaudo", "cristaudo.gianluca6@gmail.com", "prova", "ciaoCiao1");
		prova.autenticazioneAutore("cristaudo.gianluca6@gmail.com","ciaoCiao1");
		prova.nuovoArticolo();
		prova.setDatiArticolo("ricerca op", "sperimentale", 20, "primo.txt");
		assertEquals(valore,prova.getArticoloCorrente().getTitolo());
	}

	@Test
	void testAddArticoloCandidato() {
		/*TSR nuovo = TSR.getIstanza();
		int valore=1;
		nuovo.registrazioneAutore("gianluca", "cristaudo", "prova@gmail.com", "ciao", "Ciao1ciao");
        nuovo.autenticazioneAutore("prova@gmail.com", "Ciao1ciao");
        nuovo.registrazioneRevisore("gianlu", "cio", "gianlu@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Senior");
        nuovo.registrazioneRevisore("sarahd", "basiledd", "sb2@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");
        nuovo.registrazioneRevisore("vedi", "ba", "vba@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");     
        nuovo.nuovoArticolo();
        nuovo.setDatiArticolo("prova", "ciao", 6, "okok");
        nuovo.confermaSottomissioneArticolo();
        nuovo.autenticazioneRevisore("sb2@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("vba@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("gianlu@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("ok", "accept", 0, 0, 0, 0);
        assertEquals(valore,nuovo.getListaArticoliCandidati().size());*/
	}

	@Test
	void testDecisioneFinale() {
		
		//ACCETTATO SUBITO
		
		/*TSR nuovo = TSR.getIstanza();
		int valore=1;
		nuovo.registrazioneAutore("gianluca", "cristaudo", "prova@gmail.com", "ciao", "Ciao1ciao");
        nuovo.autenticazioneAutore("prova@gmail.com", "Ciao1ciao");
        nuovo.registrazioneRevisore("gianlu", "cio", "gianlu@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Senior");
        nuovo.registrazioneRevisore("sarahd", "basiledd", "sb2@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");
        nuovo.registrazioneRevisore("vedi", "ba", "vba@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");     
        nuovo.nuovoArticolo();
        nuovo.setDatiArticolo("prova", "ciao", 6, "okok");
        nuovo.confermaSottomissioneArticolo();
        nuovo.autenticazioneRevisore("sb2@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("vba@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("gianlu@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("ok", "accept", 0, 0, 0, 0);
        nuovo.autenticazioneEditore("prova@gmail.com", "prova");
        nuovo.decisioneFinale("accettato");
        assertEquals(valore,nuovo.getAutoreCorrente().getListaArticoliAR().size());*/
		
		//RICANDIDATO E POI ACCETTATO
		/*TSR nuovo = TSR.getIstanza();
		int valore=1;
		nuovo.registrazioneAutore("gianluca", "cristaudo", "prova@gmail.com", "ciao", "Ciao1ciao");
        nuovo.autenticazioneAutore("prova@gmail.com", "Ciao1ciao");
        nuovo.registrazioneRevisore("gianlu", "cio", "gianlu@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Senior");
        nuovo.registrazioneRevisore("sarahd", "basiledd", "sb2@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");
        nuovo.registrazioneRevisore("vedi", "ba", "vba@hotmail.it", "italiana", 2, "ciaoCiaoCiao3", "Junior");     
        nuovo.nuovoArticolo();
        nuovo.setDatiArticolo("prova", "ciao", 6, "okok");
        nuovo.confermaSottomissioneArticolo();
        nuovo.autenticazioneRevisore("sb2@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("vba@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("gianlu@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("ok", "accept", 0, 0, 0, 0);
        nuovo.autenticazioneEditore("prova@gmail.com", "prova");
        nuovo.decisioneFinale("da_valutare");
        nuovo.autenticazioneRevisore("sb2@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("vba@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("", "", 5, 5, 5, 5);
        nuovo.autenticazioneRevisore("gianlu@hotmail.it", "ciaoCiaoCiao3");
        nuovo.inValutazione("ok", "accept", 0, 0, 0, 0);
        nuovo.autenticazioneEditore("prova@gmail.com", "prova");
        nuovo.decisioneFinale("accettato");
        assertEquals(valore,nuovo.getAutoreCorrente().getListaArticoliAR().size());*/
	}

}
