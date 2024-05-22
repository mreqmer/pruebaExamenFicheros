package excepciones;

public class NegativeCodigoException extends Exception {

	@Override
	public String toString() {
		String error;
		
		error = "El código no puede ser negativo";
		
		return error;
	}
	
	@Override 
	public String getMessage() {
		String error = super.getMessage();
		error = this.getClass() + "El código no puede ser negativo";
		return error;
	}
}
