package Interfacce;

import java.util.LinkedList;

import Classi.Autore;

public interface AutoreDAO {
	public LinkedList<Autore> doRetrieveAll() throws Exception;
	public short inserisciAutore(Autore A) throws Exception;
}
