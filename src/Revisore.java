import java.util.LinkedList;
public abstract class Revisore {
	private String nome;
    private String cognome;
    private String email;
    private String nazionalita;
    private int anni_esperienza;
    private String password;
    private LinkedList<Articolo> listaArticoliAssociati;
    
    // COSTRUTTORE
    public Revisore(String nome,String cognome,String email,String nazionalita,int anni_esperienza, String password){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.nazionalita=nazionalita;
        this.anni_esperienza=anni_esperienza;
        this.password=password;
        listaArticoliAssociati= new LinkedList<Articolo>();
    }
    
    // METODI 
    
    public void associaArticolo(Articolo articolo_corrente){
	    listaArticoliAssociati.add(articolo_corrente);
	}
    
    public void rimuoviArticolo(Articolo articolo_corrente) {
    	listaArticoliAssociati.remove(articolo_corrente);
    }
	
	@Override
	public String toString(){
	    return "Nome: "+nome+" Cognome: "+cognome+" email: "+email+" nazionalita': "+nazionalita+" anni di esperienza: "+anni_esperienza;
	}
	
	public abstract Valutazione getValutazione(Revisore revisore,int voto_t, int voto_o, int voto_p, int voto_ov,String commento, String giudizio);

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
    
    public void setNazionalita(String nazionalita){
        this.nazionalita=nazionalita;
    }
    
    public String getNazionalita(){
        return nazionalita;
    }
    
    public void setAnni_Esperienza(int anni_esperienza){
        this.anni_esperienza=anni_esperienza;
    }
    
    public int getAnni_Esperienza(){
        return anni_esperienza;
    }
    
    public void setListaArticoliAssociati(LinkedList<Articolo> lista){
        listaArticoliAssociati=lista;
    }
    
    public LinkedList<Articolo> getListaArticoliAssociati(){
        return listaArticoliAssociati;
    }
    
    public void setPassword(String password) {
    	this.password=password;
    }
    
    public String getPassword() {
    	return password;
    }
    
}
