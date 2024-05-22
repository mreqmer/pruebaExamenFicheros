package excepciones;

public class PocasLetrasException extends Exception {

	@Override
	public String toString() {
		String error;
		
		error = "El nombre no puede tener menos de 2 letras.";
		
		return error;
	}
	
	@Override 
	public String getMessage() {
		String error;
		error = this.getClass() + "El nombre no puede tener menos de 2 letras.";
		return error;
	}
	
}
