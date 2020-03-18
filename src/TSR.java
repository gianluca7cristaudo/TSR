import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class TSR {
	 private static TSR singleton;
	    private LinkedList <Articolo> listaArticoli;
	    private Articolo articoloCorrente;
	    private LinkedList <Autore> listaAutori;
	    private LinkedList <RevisoreSenior> listaRevisoriSenior; 
	    private LinkedList <RevisoreJunior> listaRevisoriJunior;
	    private LinkedList <Traccia> listaTracce;
	    private Autore autoreCorrente;
	    private Revisore revisoreCorrente;
	    private LinkedList <Articolo> listaArticoliCandidati;
	    private Editore editoreCorrente;
	    private LinkedList <Autore> listaAutoriDaAggiungereAllArticolo;
	    
	    public static TSR getIstanza(){
	        if(singleton==null){
	            singleton= new TSR();
	        }
	        return singleton;
	    }
	    
	    // COSTRUTTORE
	    
	    private TSR (){
	        listaArticoli= new LinkedList<Articolo>();
	        listaAutori= new LinkedList<Autore>();
	        listaRevisoriSenior= new LinkedList<RevisoreSenior>();
	        listaRevisoriJunior= new LinkedList<RevisoreJunior>();
	        listaTracce= new LinkedList<Traccia>();
	        listaArticoliCandidati=new LinkedList<Articolo>();
	    }
	    
	    //METODI
	    
	    public String setDatiArticolo(String titolo, String abgstract, int dimensione, String nome_file){
		    // Controlla dati
		    if( (!(titolo.isEmpty())) && (!(abgstract.isEmpty())) && (dimensione>0) && (!(nome_file.isEmpty())) )
		    {
		        articoloCorrente.setTitolo(titolo);
		        articoloCorrente.setAbstract(abgstract);
		        articoloCorrente.setDimensione(dimensione);
		        articoloCorrente.setNomeFile(nome_file);
		        return "I dati inseriti sono corretti";
		    }
		    return "Dati inseriti non corretti";
		}

		public void nuovoArticolo(){
				listaAutoriDaAggiungereAllArticolo=new LinkedList<Autore>();
				articoloCorrente= new Articolo();
				listaAutoriDaAggiungereAllArticolo.add(autoreCorrente);
		}

		private void associazioneRevisori() {//sottomissioneArticolo(){
		    // Associazione Revisori (1 Senior e almeno 2 Junior) 
		    //SENIOR
		    int dimensioneListaRevisoriSenior=listaRevisoriSenior.size();
		    Random random= new Random();
		    int numero_casuale= random.nextInt(dimensioneListaRevisoriSenior);
		    RevisoreSenior revisoreSeniorScelto=listaRevisoriSenior.get(numero_casuale); 
		    articoloCorrente.addRevisore(revisoreSeniorScelto);
		    revisoreSeniorScelto.associaArticolo(articoloCorrente);
		    addTraccia(articoloCorrente.getTitolo(),"Sistema","associazione revisore Senior");
		    
		    //JUNIOR
		    LinkedList <RevisoreJunior> listaCopiaRevisoriJunior= new LinkedList<RevisoreJunior>();
		    listaCopiaRevisoriJunior.addAll(listaRevisoriJunior);
		    int i=0,n_revisori=0,min,max,dif;
		    	if (listaRevisoriJunior.size()>=5) {
		        	min=2;
		        	max=5;
		        	dif=(max-min)+1;
			        n_revisori=random.nextInt(dif)+min;
		        }
		        else {
		        	min=2;
		        	max=listaRevisoriJunior.size();
		        	dif=(max-min)+1;
			        n_revisori=random.nextInt(dif)+min;
		        }
		        while(i<n_revisori){
		            numero_casuale=random.nextInt(listaCopiaRevisoriJunior.size());
		            RevisoreJunior revisoreJuniorScelto=listaCopiaRevisoriJunior.get(numero_casuale);
		            listaCopiaRevisoriJunior.remove(numero_casuale);
		            articoloCorrente.addRevisore(revisoreJuniorScelto);
		            revisoreJuniorScelto.associaArticolo(articoloCorrente);
		            addTraccia(articoloCorrente.getTitolo(),"Sistema","associazione revisore Junior");
		            i++;
		        }
		}

		public String inserisciAutore(String email){
		    // prima controlla che l'email e' presente nella lista degli autori, e poi fa le relative operazioni
		    int dimensione= listaAutori.size();
		    int i=0;
		    boolean trovato=false;
		    while(i<dimensione){
		        if(listaAutori.get(i).getEmail().equals(email)){
		            trovato=true;
		            break;
		        }
		        i++;
		    }
		    if(trovato==true){
		    	listaAutoriDaAggiungereAllArticolo.add(listaAutori.get(i));
		        return "L'autore e' stato inserito correttamente";
		    }
		    return "L'autore inserito non e' stato aggiunto perche' non e' stato trovato";
		}

		public boolean autenticazioneAutore(String email, String password){
		    int dimensione= listaAutori.size();
		    int i=0;
		    Autore prova;
		    boolean trovato=false;
		    while(i<dimensione){
		        prova=listaAutori.get(i);
		        if((prova.getEmail().equals(email)) &&(prova.getPassword().equals(password))){
		            autoreCorrente=prova;
		            trovato=true;
		            break;
		        }
		        i++;
		    }
		    return trovato;
		}

		// REFACTORING
		private boolean controlloPassword(String password){ 
		    // min 8 caratteri, almeno una maiuscola, una minuscola e un numero
		    boolean valido=false;
		    int lunghezzaPassword=password.length();
		    if (lunghezzaPassword<8) return false;
		    else {
		        int i=0;
		        while (i<lunghezzaPassword){
		            if(Character.isUpperCase(password.charAt(i))) {
		                valido=true;
		                break;
		            }
		            i++;
		        }
		        if (valido==true){
		            valido=false;
		            i=0;
		            while (i<lunghezzaPassword){
		                if(Character.isLowerCase(password.charAt(i))) {
		                    valido=true;
		                    break;
		                }
		                i++;
		            }
		        }
		        if (valido==true){
		            i=0;
		            while (i<lunghezzaPassword){
		                if(Character.isDigit(password.charAt(i))) {
		                    return true;
		                }
		                i++;
		            }
		        }
		    }
		    return false;
		}

		public String registrazioneAutore(String nome, String cognome, String email, String affiliazione,String password){
		    if ((!(nome.isEmpty())) && (!(cognome.isEmpty())) && (!(email.isEmpty())) && (!(affiliazione.isEmpty())) && (controlloPassword(password)) && (controlloEmail(email,"autore"))){
		        Autore nuovo= new Autore(nome,cognome,email,affiliazione,password);
		        listaAutori.add(nuovo);
		        return "I dati inseriti sono corretti, registrazione effettuata!";
		    }
		    return "I dati inseriti non sono corretti.";
		}

		public String inValutazione(String commento, String giudizio, int voto_t, int voto_o, int voto_p, int voto_ov) { 
			Valutazione nuova;
			if(giudizio.isEmpty()) {
				if (controlloRevisioneJunior(voto_t,voto_o,voto_p,voto_ov)) {
					RevisoreJunior revisoreJuniorCorrente=(RevisoreJunior)revisoreCorrente;
		    		nuova=revisoreJuniorCorrente.getValutazione(revisoreCorrente, voto_t, voto_o, voto_p, voto_ov, null, null);
		    	}
				else {
					return "inserire i dati in maniera corretta";
				}
			}
			else {
				RevisoreSenior revisoreSeniorCorrente=(RevisoreSenior)revisoreCorrente;
				nuova= revisoreSeniorCorrente.getValutazione(revisoreCorrente, 0, 0, 0, 0, commento, giudizio);
			}
			revisoreCorrente.rimuoviArticolo(articoloCorrente);
			String risposta=articoloCorrente.addValutazione(nuova);
			if (risposta.contains("candidato")){
				listaArticoliCandidati.add(articoloCorrente);
			}
			addTraccia(articoloCorrente.getTitolo(),revisoreCorrente.getEmail(),"valutazione");
			return risposta;
		}

		public boolean autenticazioneRevisore(String email, String password){
		    int dimensione= listaRevisoriSenior.size();
		    int i=0;
		    RevisoreSenior prova;
		    while(i<dimensione){
		        prova=listaRevisoriSenior.get(i);
		        if((email.equals(prova.getEmail())) && (password.equals(prova.getPassword()))){
		            revisoreCorrente=prova;
		            return true;
		        }
		        i++;
		    }
		    RevisoreJunior prova1;
		    dimensione= listaRevisoriJunior.size();
		    i=0;
		    while(i<dimensione){
		        prova1=listaRevisoriJunior.get(i);
		        if(email.equals(prova1.getEmail()) && password.equals(prova1.getPassword())){
		            revisoreCorrente=prova1;
		            return true;
		        }
		        i++;
		    }
		    return false;
		}

		private boolean controlloEmail(String email,String tipo){
		    if((!(email.contains("@"))) || (!(email.contains(".")))) return false;
		    int i=0;
		    tipo=tipo.toLowerCase();
		    if (tipo.equals("senior")) {
		    	while(i<listaRevisoriSenior.size()) {
		    		if (email.equals(listaRevisoriSenior.get(i).getEmail())) return false;
		            i++;
		    	}
		    }
		    else if(tipo.equals("junior")) {
		    	while(i<listaRevisoriJunior.size()) {
		    		if (email.equals(listaRevisoriJunior.get(i).getEmail())) return false;
		            i++;
		    	}
		    }
		    else {
		    	while(i<listaAutori.size()){
		            if (email.equals(listaAutori.get(i).getEmail())) return false;
		            i++;
		        }
		    }
		    return true;
		}

		private boolean controlloRevisioneJunior(int voto_t, int voto_o, int voto_p, int voto_or) {
			if (((voto_t<0)||(voto_t>9)) || ((voto_o<0)||(voto_o>9)) || ((voto_p<0)||(voto_p>9)) || ((voto_or<0)||(voto_or>9))) return false;
			return true;
		}

		public String confermaSottomissioneArticolo() {
			int i=0;
			while (i<listaAutoriDaAggiungereAllArticolo.size()) {
				articoloCorrente.associaAutore(listaAutoriDaAggiungereAllArticolo.get(i));
				articoloCorrente.addObserver(listaAutoriDaAggiungereAllArticolo.get(i));
				listaAutoriDaAggiungereAllArticolo.get(i).associaArticolo(articoloCorrente);
				i++;
			}
			addTraccia(articoloCorrente.getTitolo(),autoreCorrente.getEmail(),"sottomissione");
			associazioneRevisori();
			listaAutoriDaAggiungereAllArticolo.clear();
			// Aggiunta articolo
		    listaArticoli.add(articoloCorrente);
			return "Articolo inserito correttamente";
		}

		private void addTraccia(String t_articolo,String email,String tipoOperazione) {
			Date data= new Date();
		    SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy"); 
		    Traccia nuova=new Traccia(t_articolo,(sdf.format(data)),tipoOperazione,email);
		    listaTracce.add(nuova);
		}

		public String registrazioneRevisore(String nome, String cognome, String email, String nazionalita, int anni_esperienza, String password, String tipo) {
			tipo=tipo.toLowerCase();
			if ((!(nome.isEmpty())) && (!(cognome.isEmpty())) && (!(email.isEmpty())) && (anni_esperienza!=0) && (controlloPassword(password)) && (controlloEmail(email,tipo)) && (!(tipo.isEmpty()))) 
			{
				if(tipo.equals("senior")) {
					RevisoreSenior nuovo= new RevisoreSenior(nome,cognome,email,nazionalita,anni_esperienza,password);
					listaRevisoriSenior.add(nuovo);
					return "Il revisore Senior è stato registrato correttamente";
				}
				if(tipo.equals("junior")) {
					RevisoreJunior nuovo= new RevisoreJunior(nome,cognome,email,nazionalita,anni_esperienza,password);
					listaRevisoriJunior.add(nuovo);
					return "Il revisore Junior è stato registrato correttamente";
				}
			}
			return "i dati inseriti non sono corretti, controllare i dati";
		}

		public String decisioneFinale(String decisione) {
			boolean ris=articoloCorrente.decisioneFinale(decisione);
			if(ris==true) {
				listaArticoliCandidati.remove(articoloCorrente);
				//TRACCIA
				addTraccia(articoloCorrente.getTitolo(),editoreCorrente.getEmail(),articoloCorrente.getStato());
				return "La valutazione finale è stata inserita con successo";
			}
			return "La valutazione non è stata inserita";
		}

		public boolean autenticazioneEditore(String email,String password) {
			if ((email.equals("editore@gmail.com"))&&(password.equals("ciaoCiao1"))) {
				editoreCorrente=new Editore(email,password);
				return true;
			}
			return false;
		}

		public LinkedList<Valutazione> getValutazioniArticolo(String titoloArticoloScelto) {
			Articolo articoloScelto=autoreCorrente.getArticolo(titoloArticoloScelto);
			return articoloScelto.getListaValutazioni();
		}

		//METODI GET E SET
		
		public void setListaAutoriDaAggiungereAllArticolo(LinkedList <Autore> listaAutoriDaAggiungere)
	    {
	    	listaAutoriDaAggiungereAllArticolo=listaAutoriDaAggiungere;
	    }
	    
	    public LinkedList<Autore> getListaAutoriDaAggiungereAllArticolo() {
	    	return listaAutoriDaAggiungereAllArticolo;
	    }
	    
	    public void setListaArticoli(LinkedList<Articolo> listaArticoli){
	        this.listaArticoli=listaArticoli;
	    }
	    
	    public LinkedList<Articolo> getListaArticoli (){
	        return listaArticoli;
	    }
	    
	    public void setListaAutori(LinkedList<Autore> listaAutori){
	        this.listaAutori=listaAutori;
	    }
	    
	    public LinkedList<Autore> getListaAutori(){
	        return listaAutori;
	    }
	    
	    public void setListaRevisoriSenior(LinkedList<RevisoreSenior> listaRevisori){ 
	        listaRevisoriSenior=listaRevisori;
	    }
	    
	    public LinkedList<RevisoreSenior> getListaRevisoriSenior (){ 
	        return listaRevisoriSenior;
	    }
	    
	    public void setListaRevisoriJunior(LinkedList <RevisoreJunior> listaRevisori){
	        listaRevisoriJunior=listaRevisori;
	    }
	    
	    public LinkedList<RevisoreJunior> getListaRevisoriJunior (){
	        return listaRevisoriJunior;
	    }
	    
	    public void setListaTracce(LinkedList<Traccia> listaTracce){
	        this.listaTracce=listaTracce;
	    }
	    
	    public LinkedList<Traccia> getListaTracce(){
	        return listaTracce;
	    }
	    
	    public void setArticoloCorrente(Articolo articolo_corrente){
	        articoloCorrente=articolo_corrente;
	    }
	    
	    public Articolo getArticoloCorrente(){
	        return articoloCorrente;
	    }
	    
	    public void setAutoreCorrente(Autore autore_corrente){
	        autoreCorrente=autore_corrente;
	    }
	    
	    public Autore getAutoreCorrente(){
	        return autoreCorrente;
	    }
	    
	    public void setListaArticoliCandidati(LinkedList <Articolo>lista) {
	    	listaArticoliCandidati=lista;
	    }
	    
	    public LinkedList<Articolo> getListaArticoliCandidati(){
	    	return listaArticoliCandidati;
	    }
	    
	    public void setRevisoreCorrente(Revisore revisore) {
	    	revisoreCorrente=revisore;
	    }
	    
	    public Revisore getRevisoreCorrente() {
	    	return revisoreCorrente;
	    }
	    
	    public void setEditoreCorrente(Editore editore) {
	    	editoreCorrente=editore;
	    }
	    
	    public Editore getEditoreCorrente() {
	    	return editoreCorrente;
	    }
	    
}
