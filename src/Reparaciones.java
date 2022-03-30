
/**
 * Clase Reparaciones extiende Trabajo
 * @author daw
 *
 */
public class Reparaciones extends Trabajo {
	private double precioMaterial;
	private int reparacionTipo;
	
	final static int TIPO_REPARACION_MECANICA = 0;
	final static int TIPO_REPARACION_CHAPA_Y_PINTURA = 1;
	
	final private static double COSTE_REPARACION_MECANICA = 1.1; // 10%
	final private static double COSTE_REPARACION_CHAPA_Y_PINTURA = 1.3; // 30%
	
	/**
	 * @param id ID del trabajo
	 * @param descripcion Descripción del trabajo
	 * @param reparacionTipo Tipo de Reparación (Mecánica 0, ChapaYPintura 1)
	 */
	public Reparaciones(int id, String descripcion, int reparacionTipo) {
		super(id, descripcion, TIPO_TRABAJO_REPARACION);
		
		this.reparacionTipo = reparacionTipo;
	}

	/**
	 * @return double Leer Precio Material
	 */
	public double getPrecioMaterial() {
		return precioMaterial;
	}

	/**
	 * @param precioMaterial Establecer precio del material
	 */
	public void setPrecioMaterial(double precioMaterial) {
		this.precioMaterial = precioMaterial;
	}

	/**
	 * @param importe Importe del precio del material
	 * @return Resultado
	 */
	public Resultado usarMaterial(double importe) {
		if (getResultado() == Resultado.FINALIZADO) return Resultado.FINALIZADO;
		
		precioMaterial += importe;
		
		return Resultado.CORRECTO;
	}

	/**
	 * @return int SubTipo (Reparacion Mecanica(0), ChapaYPintura (1))
	 */
	public int getSubTipo() {
		return reparacionTipo;
	}
	
	/**
	 * @param tipo Tipo de la Reparación (Reparacion Mecanica(0), ChapaYPintura (1))
	 * @return String Nombre del tipo de Reparación
	 */
	public static String getReparacionTipoNombre(int tipo) {
		switch(tipo) {
		case TIPO_REPARACION_MECANICA:
			return "MECANICA";
		case TIPO_REPARACION_CHAPA_Y_PINTURA:
			return "CHAPA Y PINTURA";
		default:
			return "DESCONOCIDO";
		}
	}

	@Override
	public String toString() {
		return getTrabajoTipoNombre(getTipo()) + " " + getReparacionTipoNombre(reparacionTipo) + " "
				+ "identificador=" + getId() + " descripcion=" + getDescripcion() + " horas=" + getHoras() + " coste material=" + precioMaterial + " "
				+ "Precio Final=" + ((getHoras() * 30) + calcularPrecio());
	}

	@Override
	public double calcularPrecio() {
		switch(getSubTipo()) {
		case TIPO_REPARACION_MECANICA:
			return getPrecioMaterial() * COSTE_REPARACION_MECANICA;
		case TIPO_REPARACION_CHAPA_Y_PINTURA:
			return getPrecioMaterial() * COSTE_REPARACION_CHAPA_Y_PINTURA;
		default:
			return 0;
		}
	}
}
