package gestion.archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import clases.Medicina;
import excepciones.NegativeCodigoException;
import excepciones.NegativePrecioException;
import excepciones.PocasLetrasException;

public class GestionArchivos {
	
	static final String RUTA = "src/archivos/texto.txt";

	public static Set<Medicina> leeArchivo() throws NegativeCodigoException, PocasLetrasException, NegativePrecioException{
		
		Set<Medicina> listaMedicamentos = new TreeSet<>();
		
		String linea;
		String[] medicinas;
		int codigo;
		double precio;
		
		Medicina m;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(RUTA));
				linea = br.readLine();
				
				while(linea!=null) {	
					medicinas = linea.split("::");
					codigo = Integer.parseInt(medicinas[0]);
					precio = Double.parseDouble(medicinas[3]);
					m = new Medicina(codigo, medicinas[1], medicinas[2], precio, medicinas[4]);
					listaMedicamentos.add(m);

					linea = br.readLine();
				}
				
				
		} catch (IOException e) {	
			System.out.println("Hay algún error.");
		}
		
		return listaMedicamentos;
	}
	
	
	public static void escribeArchivo(Set<Medicina> listadoMedicamento) {
		String cadena;
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter (new FileWriter (RUTA));
			for(Medicina valor : listadoMedicamento) {
				cadena = "";
				cadena += valor.getCodigo() + "::";
				cadena += valor.getNombre() + "::";
				cadena += valor.getDescripcion() + "::";
				cadena+= valor.getPrecio() + "::";
				cadena += valor.getPosologia();
				
				bw.write(cadena);
				bw.newLine();
			}
		
		} catch (IOException e) {
			System.out.println("Ha habido algún error");
		}finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				System.out.println("Ha habido algún error");
			}
		}
		
	}
}
