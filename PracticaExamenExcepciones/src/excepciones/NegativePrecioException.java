package excepciones;

public class NegativePrecioException extends Exception {

	@Override
	public String toString() {
		String error;
		
		error = "El precio no puede ser negativo";
		
		return error;
	}
	
	@Override 
	public String getMessage() {
		String error = super.getMessage();
		error = this.getClass() + "El precio no puede ser negativo";
		return error;
	}
	
}
