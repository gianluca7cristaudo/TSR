import java.util.LinkedList;
import java.sql.*;

public class AutoreDAOimpl implements AutoreDAO {
	public static final String password = "Rossellabella94";
	public static final String username = "Samuele";
	public static final String url = "jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	@Override
	public LinkedList<Autore> doRetrieveAll()  {
		LinkedList<Autore> lista = new LinkedList<Autore>();
		try {
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	            Connection conn = DriverManager.getConnection(url, username, password);
	            Statement stt = conn.createStatement();
	            Statement stt_articoli = conn.createStatement();
	            stt.execute("create database if not exists databaseTSR");
	            stt.execute("use databaseTSR");
	            ResultSet res = stt.executeQuery("select * from Autore;");
	            while (res.next()) {
	            	String email_corrente = res.getString("email");
	            	Autore AutoreCorrente = new Autore(res.getString("nome"), res.getString("cognome"), email_corrente, res.getString("affiliazione"), res.getString("password"));
	            	//riempio lista articoli associati
	            	ResultSet res_articoli = stt_articoli.executeQuery("select Articolo.* from Autore join AutoreArticolo on Autore.email = AutoreArticolo.email join Articolo on AutoreArticolo.titolo = Articolo.titolo where Autore.email = '" + email_corrente +"';");
	            	while (res_articoli.next()) {
	            		Articolo ArticoloCorente = new Articolo(res_articoli.getString("titolo"), res_articoli.getString("abstract"), res_articoli.getInt("dimensione"), res_articoli.getString("nome_file"),res_articoli.getString("stato"));
	            		AutoreCorrente.associaArticolo(ArticoloCorente);
	            	}
	            	lista.add(AutoreCorrente);
	            	}
	            stt.close();
	            stt_articoli.close();
	            res.close();
	            conn.close();	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return lista;
	}
	
	public AutoreDAOimpl() {
		super();
	}

	@Override
	public short inserisciAutore(Autore A) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stt = conn.createStatement();
            Statement stt_articoli = conn.createStatement();
            stt.execute("create database if not exists databaseTSR");
            stt.execute("use databaseTSR");
            String query = "insert into Autore values('"+A.getNome()+"','"+A.getCognome()+"','"+A.getEmail()+"','"+A.getAffiliazione()+"','"+A.getPassword()+"');";
            PreparedStatement stt_insert = conn.prepareStatement(query);
            stt_insert.execute();
            stt.close();
            stt_insert.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return 0;
	}
}
