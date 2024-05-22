package clases;

import excepciones.NegativeCodigoException;
import excepciones.NegativePrecioException;
import excepciones.PocasLetrasException;

public class Medicina implements Comparable <Medicina> {

	private int codigo;
	private String nombre;
	private String descripcion;
	private String posologia;
	private double precio;
	
	public Medicina(int codigo) throws NegativeCodigoException {
		if(codigo > 0) {
			this.codigo = codigo;
		}else {
			throw new NegativeCodigoException();
		}
	}
	
	public Medicina (int codigo, String nombre) throws NegativeCodigoException, PocasLetrasException {
		this(codigo);
		if(validaNombre(nombre)) {
			this.nombre = nombre;
		}else {
			throw new PocasLetrasException();
		}
	}
	
	public Medicina(int codigo, String nombre, String descripcion, double precio, String posologia)
			throws NegativeCodigoException, PocasLetrasException, NegativePrecioException {
		this(codigo, nombre);
		this.descripcion = descripcion;
		if(precio > 0) {
			this.precio = precio;
		}else {
			throw new NegativePrecioException();
		}
		this.posologia = posologia;
		
	}
	
	
	
	
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getPosologia() {
		return posologia;
	}

	public double getPrecio() {
		return precio;
	}
	
	

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public void setPrecio(double precio) throws NegativePrecioException {
		if(precio > 0) {
			this.precio = precio;
		}else {
			throw new NegativePrecioException();
		}
	}

	public boolean validaNombre(String nombre) {
		boolean valido = false;
		
		valido = (nombre!=null && nombre.length()>3) ? true : false;
		
		return valido;
	}
	@Override
	public String toString() {
		String cadena = "";
		cadena += this.codigo + "\n";
		cadena += this.nombre + "\n";
		cadena += this.descripcion + "\n";
		cadena += this.precio + "\n";
		cadena += this.posologia + "\n";
		cadena += "---------------------------" + "\n";
		
		return cadena;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		Medicina m = (Medicina) obj;
		
		if(this.codigo == m.codigo) {
			iguales = true;
		}
		
		return iguales;
	}
	
	@Override
	public int compareTo(Medicina m) {
		int res;
		
		res = this.codigo - m.codigo;
		
		
		return res;
	}
	
	
	
	
	
}
