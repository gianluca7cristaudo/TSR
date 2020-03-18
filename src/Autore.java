import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Autore implements Observer {
	private String nome;
    private String cognome;
    private String email;
    private String affiliazione;
    private String password;
    private LinkedList<Articolo> listaArticoliAssociati;
    private LinkedList<Articolo> listaArticoliAR;
    
    //COSTRUTTORE
    
    public Autore(String nome, String cognome, String email, String affiliazione,String password){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.affiliazione=affiliazione;
        this.password=password;
        listaArticoliAssociati= new LinkedList<Articolo>();
        listaArticoliAR= new LinkedList<Articolo>();
    }
    
    //METODI
    
    public void associaArticolo(Articolo articoloCorrente){
		if(articoloCorrente!=null)
		{
			listaArticoliAssociati.add(articoloCorrente);
			articoloCorrente.addObserver(this);
		}
	    
	}

	@Override
	public String toString(){
	    return "Nome: "+nome+" Cognome: "+cognome+" email: "+email+" affiliazione: "+affiliazione;
	}

	public Articolo getArticolo (String titoloArticoloScelto) {
		int i=0;
		while(i<listaArticoliAR.size()) {
			if(listaArticoliAR.get(i).getTitolo().equals(titoloArticoloScelto))return listaArticoliAR.get(i);
			i++;
		}
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		// EMAIL
		//PROVA
		//Articolo prova= (Articolo)o;
		//System.out.println("l'articolo "+prova.getTitolo()+" è stato accettato/rifiutato");
	}

	public void addArticoloAR(Articolo articolo) {
		if (articolo!=null)
		{
			listaArticoliAR.add(articolo);
			articolo.deleteObserver(this);
		}
	}

	//METODI GET E SET
	
	public void setNome(String nome){
        this.nome=nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    
    public String getCognome(){
        return cognome;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setAffiliazione(String affiliazione){
        this.affiliazione=affiliazione;
    }
    
    public String getAffiliazione(){
        return affiliazione;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setListaArticoliAssociati(LinkedList <Articolo> lista){
        listaArticoliAssociati=lista;
    }
    
    public LinkedList<Articolo> getListaArticoliAssociati(){
	    return listaArticoliAssociati;
	}

	public void setListaArticoliAR(LinkedList <Articolo>lista) {
    	listaArticoliAR=lista;
    }
    
    public LinkedList <Articolo> getListaArticoliAR(){
    	return listaArticoliAR;
    }
    
}