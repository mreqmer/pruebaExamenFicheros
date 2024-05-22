package clases;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import excepciones.NegativeCodigoException;
import excepciones.NegativePrecioException;
import excepciones.PocasLetrasException;
import gestion.archivos.GestionArchivos;

public class Medicinas {

	private static Set<Medicina> listaMedicamentos = new TreeSet<>();
	
	public static void inicializa() throws NegativeCodigoException, PocasLetrasException, NegativePrecioException {
		listaMedicamentos = GestionArchivos.leeArchivo();
	}
	
	public static void guarda() {
		GestionArchivos.escribeArchivo(listaMedicamentos);
	}
	
	
	public static boolean addMedicina(Medicina m) {
		boolean added = false;
		if(listaMedicamentos.add(m)) {
			added = true;
		}
		
		return added;
		
	}
	
	public static String listadoDeMedicinas() {
		 String cadena = "";
		 
		 for(Medicina valor : listaMedicamentos) {
			 cadena += valor;
		 }
		
		return cadena;
	}
	
	public static boolean borraMedicina(Medicina m) {
		boolean borrado = false;
		
		if(listaMedicamentos.remove(m)) {
			borrado = true;
		}
		
		return borrado;
	}
		
		
	}
	
