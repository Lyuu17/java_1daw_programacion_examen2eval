
/**
 * Clase Revisiones extiende Trabajo
 * @author daw
 *
 */
public class Revisiones extends Trabajo {

	final private static double COSTE_REVISION = 20; // 20 €
	
	/**
	 * @param id ID del nuevo trabajo
	 * @param descripcion Descripcion del trabajo Revisiones
	 */
	public Revisiones(int id, String descripcion) {
		super(id, descripcion, TIPO_TRABAJO_REVISION);
	}
	
	/**
	 * @param rev Clase para copiar el objeto Revisiones
	 * @param id ID del nuevo trabajo
	 */
	public Revisiones(Revisiones rev, int id) {
		super(id, (Trabajo)rev);
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "REVISIÓN" + " "
				+ "identificador=" + getId() + " descripcion=" + getDescripcion() + " horas=" + getHoras() + " "
				+ "Precio Final=" + ((getHoras() * 30) + calcularPrecio());
	}
	
	/**
	 * @return double
	 */
	@Override
	public double calcularPrecio() {
		return COSTE_REVISION;
	}

	/**
	 * @param importe Importe del material
	 */
	@Override
	public Resultado usarMaterial(double importe) {
		return null;
	}
	
}
