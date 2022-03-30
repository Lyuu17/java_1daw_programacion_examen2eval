
/**
 * Interfaz Tienda
 * @author daw
 *
 */
public interface Tienda {
	/**
	 * nuevoTrabajo
	 * @param descripcion Descripción del trabajo
	 * @param tipo Tipo del trabajo
	 * @return Resultado
	 */
	public Resultado nuevoTrabajo(String descripcion, int tipo);
	
	/**
	 * añadirHoras
	 * @param id ID del trabajo
	 * @param horas Horas del trabajo
	 * @return Resultado
	 */
	public Resultado añadirHoras(String id, int horas);
	
	/**
	 * añadirMaterial
	 * @param id ID del trabajo
	 * @param importe Importe del material
	 * @return Resultado
	 */
	public Resultado añadirMaterial(String id, int importe);
	
	/**
	 * finalizarTrabajo
	 * @param id ID del trabajo
	 * @return double[]
	 */
	public double[] finalizarTrabajo(String id);
	
	/**
	 * listarTrabajos
	 * @return String
	 */
	public String listarTrabajos();
	
	/**
	 * duplicarRevision
	 * @param id ID del trabajo
	 * @return Resultado
	 */
	public Resultado duplicarRevision(String id);
	
	/**
	 * eliminarDuplicados
	 */
	public void eliminarDuplicados();
}
