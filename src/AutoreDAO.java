import java.util.LinkedList;

public interface AutoreDAO {
	
	public LinkedList<Autore> doRetrieveAll() throws Exception;
	public short inserisciAutore(Autore A) throws Exception;
}
