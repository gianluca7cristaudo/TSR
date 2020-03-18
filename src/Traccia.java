
public class Traccia {
	private String titoloArticolo;
    private String data;
    private String tipoOperazione;
    private String effettuataDa;
    
    //COSTRUTTORE
    
    public Traccia(String titolo, String data, String tipoOperazione, String effettuataDa){
        this.titoloArticolo=titolo;
        this.data=data;
        this.tipoOperazione=tipoOperazione;
        this.effettuataDa=effettuataDa;
    }
  
    // METODI
	
	@Override
	public String toString(){
	    return "Titolo articolo: "+titoloArticolo+" data: "+data+" tipo operazione: "+tipoOperazione+" effettuata da: "+effettuataDa;
	}
	
	//METODI GET E SET

	public void setTitoloArticolo (String titolo){
        this.titoloArticolo=titolo;
    }
    
    public String getTitoloArticolo (){
        return titoloArticolo;
    }
    
    public void setData(String data){
        this.data=data;
    }
    
    public String getData(){
        return data;
    }
    
    public void setTipoOperazione(String tipoOperazione){
        this.tipoOperazione=tipoOperazione;
    }
    
    public String getTipoOperazione(){
        return tipoOperazione;
    }
    
    public void setEffettuataDa(String effettuataDa){
        this.effettuataDa=effettuataDa;
    }
    
    public String getEffettuataDa(){
        return effettuataDa;
    }
    
}
