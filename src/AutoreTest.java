import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutoreTest {
	
	@Test
	void testCostruttore() {
		Autore a= new Autore("gianluca","cristuado","cristaudo.gianluca6@gmail.com","prova","ciao1provaC");
		int valore=0;
		assertEquals(valore,a.getListaArticoliAR().size());
	}

	@Test
	void testAssociaArticolo() {
		Autore a= new Autore("gianluca","cristuado","cristaudo.gianluca6@gmail.com","prova","ciao1provaC");
		int valore=1;
		Articolo ar1= new Articolo();
		a.getListaArticoliAssociati().add(ar1);
		assertEquals(valore,a.getListaArticoliAssociati().size());
	}

	void addArticoloAR() {
		Autore a= new Autore("gianluca","cristuado","cristaudo.gianluca6@gmail.com","prova","ciao1provaC");
		int valore=2;
		Articolo ar1=new Articolo();
		Articolo ar2=new Articolo();
		a.addArticoloAR(ar1);
		a.addArticoloAR(ar2);
		assertEquals(valore,a.getListaArticoliAR().size());
	}
}
