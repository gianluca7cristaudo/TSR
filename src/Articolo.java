import java.util.LinkedList;
import java.util.Observable;

public class Articolo extends Observable {
	private String titolo;
    private String absgtract;
    private int dimensione;
    private String nome_file;
    private String stato;
    private LinkedList <Autore> listaAutoriAssociati;
    private LinkedList <Revisore> listaRevisoriAssociati;
    private LinkedList <Valutazione> listaValutazioni;
    
    // COSTRUTTORE
    
    public Articolo(){
        titolo="";
        absgtract="";
        dimensione=0;
        nome_file="";
        stato="da_valutare";
        listaAutoriAssociati= new LinkedList<Autore>();
        listaRevisoriAssociati= new LinkedList<Revisore>();
        listaValutazioni= new LinkedList<Valutazione>();
    }
    
    public Articolo(String titolo, String abgstract, int dimensione, String nome_file, String stato) {
    	 this.titolo=titolo;
         this.absgtract=abgstract;
         this.dimensione=dimensione;
         this.nome_file=nome_file;
         this.stato=stato;
         listaAutoriAssociati= new LinkedList<Autore>();
         listaRevisoriAssociati= new LinkedList<Revisore>();
         listaValutazioni= new LinkedList<Valutazione>();
    }
    
    // MEOTODI
	
	public void associaAutore(Autore dc){
		if(dc!=null)
	    listaAutoriAssociati.add(dc);
	}
	
	public void addRevisore(Revisore Rv) {
		if(Rv!=null)
		listaRevisoriAssociati.add(Rv);
	}

	@Override
	public String toString(){
	    return "Titolo: "+titolo+" abstract: "+absgtract+" dimensione: "+dimensione+" nome_file: "+nome_file+" stato: "+stato;
	}
	
	public String addValutazione(Valutazione valutazioneC) {
		if (valutazioneC!=null) {
			listaValutazioni.add(valutazioneC);
	    	if(aggiornaStato())
	    	return "valutazione inserita correttamente e articolo candidato.";
	    	else return "valutazione inserita correttamente.";
		}
		return "valutazione non inserita";
	}
	
	private boolean aggiornaStato() {
		int quoziente=(listaValutazioni.size())/(listaRevisoriAssociati.size());
		int resto= (listaValutazioni.size())%(listaRevisoriAssociati.size());
		if (resto==0){
			if ((calcoloVotoMedio(quoziente))>=4.5) {
				stato="candidato_accettazione";
			}
			else stato="candidato_rifiuto";
			return true;
		}
		return false;
	}

	// REFACTORING
	private double calcoloVotoMedio(int quoziente) {
		int c=0;
		int i;
		double votoJ=0,votoS=0;
		if(quoziente==1) i=0;
		else i=((quoziente*listaRevisoriAssociati.size())-(listaRevisoriAssociati.size()))-1;
		while(i<listaValutazioni.size()) {
			if(listaValutazioni.get(i) instanceof ValutazioneJunior) {
				c++;
				ValutazioneJunior valu=(ValutazioneJunior)listaValutazioni.get(i);
				votoJ=votoJ+valu.getVoto_medio();
			}
			else {
				ValutazioneSenior valuta= (ValutazioneSenior)listaValutazioni.get(i);
				String giudi=valuta.getGiudizio();
				switch (giudi) {
					case "accept": {
						votoS=9;
						break;
					}
					case "weak accept": {
						votoS=6;
						break;
					}
					case "weak reject": {
						votoS=4;
						break;
					}
					default: votoS=0;
				}
			}
			i++;
		}
		votoJ=votoJ/c;
		double voto_finale=votoJ+(2*votoS);
		return (voto_finale/3);
	}

	public boolean decisioneFinale(String decisione) {
		setStato(decisione);
		if ((decisione.equals("accettato")) || (decisione.equals("rifiutato"))){
			int i=0;
			while(i<listaAutoriAssociati.size()) {
				listaAutoriAssociati.get(i).addArticoloAR(this);
				i++;
			}
		}
		else {
			for(int i=0;i<this.getListaRevisoriAssociati().size();i++) {
				this.getListaRevisoriAssociati().get(i).associaArticolo(this);
			}
		}
		return true;
	}

	public void setStato(String stato){
	    this.stato=stato;
	    if ((stato.equals("accettato")) || (stato.contentEquals("rifiutato"))) {
	    	setChanged();
	    	notifyObservers();
	    }
	}

	public String getStato(){
	    return stato;
	}
	
	// METODI GET E SET

	public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    
    public String getTitolo(){
        return titolo;
    }
    
    public void setAbstract(String absgtract){
        this.absgtract=absgtract;
    }
    
    public String getAbastract(){
        return absgtract;
    }
    
    public void setDimensione(int dimensione){
        this.dimensione=dimensione;
    }
    
    public int getDimensione(){
        return dimensione;
    }
    
    public void setNomeFile(String nome){
        nome_file=nome;
    }
    
    public String getNomeFile(){
        return nome_file;
    }
    
    public void setListaAutoriAssociati(LinkedList<Autore> lista){
        listaAutoriAssociati=lista;
    }
    
    public LinkedList<Autore> getListaAutoriAssociati(){
        return listaAutoriAssociati;
    }
    
    public void setListaRevisoriAssociati(LinkedList<Revisore> lista){
        listaRevisoriAssociati=lista;
    }
    
    public LinkedList<Revisore> getListaRevisoriAssociati(){
        return listaRevisoriAssociati;
    }
    
    public void setListaValutazioni(LinkedList <Valutazione> lista) {
    	listaValutazioni=lista;
    }
    
    public LinkedList<Valutazione> getListaValutazioni(){
    	return listaValutazioni;
    }
    
}
