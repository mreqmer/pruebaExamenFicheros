package main;

import java.util.Scanner;

import clases.Medicina;
import clases.Medicinas;
import excepciones.NegativeCodigoException;
import excepciones.NegativePrecioException;
import excepciones.PocasLetrasException;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Medicina m;
		int opc;
		
		try {
			Medicinas.inicializa();
		} catch (NegativeCodigoException | PocasLetrasException | NegativePrecioException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		do {
			
			menu();
			opc = sc.nextInt();
			
			switch(opc) {
			case 1->{
				
				m = newMedicamento();
				Medicinas.addMedicina(m);
				
			}case 2->{
				
				System.out.println(Medicinas.listadoDeMedicinas());
				
			}case 3->{
				try {
					m = buscaMedicina();
					if(Medicinas.borraMedicina(m)) {
						System.out.println("Borrado correctamente");
					}else {
						System.out.println("No se pudo borrar.");
					}
				} catch (NegativeCodigoException e) {
					System.out.println(e.getMessage());
				}
			}case 4->{
				Medicinas.guarda();
				System.out.println("Guardado");
			}case 0->{
				System.out.println("Saliendo...");
			}default->{
				System.out.println("Numero introducido incorrecto");
			}
			}
		}while(opc!=0);
		
		
		

	}


	public static Medicina buscaMedicina() throws NegativeCodigoException {
		int codigo;
		Medicina m;
		System.out.println("Codigo de medicamento a eliminar: ");
		codigo = sc.nextInt();
		sc.nextLine();
		m = new Medicina(codigo);
		return m;
	}

	
	public static void menu() {
		System.out.println("1.Añadir medicamento");
		System.out.println("2.Listar medicamento");
		System.out.println("3.Eliminar medicamento");
		System.out.println("4.Guardar");
		System.out.println("0.Añadir medicamento");
	}
	
	public static Medicina newMedicamento () {
		int codigo=1;
		String nombre = "";
		String descripcion = "";
		double precio;
		String posologia = "";
		Medicina m = null;
		
		System.out.println("Introduce el código: ");
		codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el nombre del medicamento: ");
		nombre = sc.nextLine();
		System.out.println("Introduce la descripción: ");
		descripcion = sc.nextLine();
		System.out.println("Introduce el precio: ");
		precio = sc.nextDouble();
		sc.nextLine();
		System.out.println("Introduce la posología");
		posologia = sc.nextLine();
		
		try {
			m = new Medicina(codigo, nombre, descripcion, precio, posologia);
		} catch (NegativeCodigoException | PocasLetrasException | NegativePrecioException e) {
			System.out.println(e.getMessage());
		}
		return m;
	}
	
}
