
/**
 * Interfaz Tienda
 * @author daw
 *
 */
public interface Tienda {
	/**
	 * nuevoTrabajo
	 * @param descripcion Descripci�n del trabajo
	 * @param tipo Tipo del trabajo
	 * @return Resultado
	 */
	public Resultado nuevoTrabajo(String descripcion, int tipo);
	
	/**
	 * a�adirHoras
	 * @param id ID del trabajo
	 * @param horas Horas del trabajo
	 * @return Resultado
	 */
	public Resultado a�adirHoras(String id, int horas);
	
	/**
	 * a�adirMaterial
	 * @param id ID del trabajo
	 * @param importe Importe del material
	 * @return Resultado
	 */
	public Resultado a�adirMaterial(String id, int importe);
	
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
