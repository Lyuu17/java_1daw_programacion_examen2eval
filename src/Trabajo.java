
/**
 * Clase Trabajo implementa el Comparable
 * @author daw
 *
 */
public abstract class Trabajo implements Comparable<Trabajo> {
	private String id;
	private String descripcion;
	private double horas;
	private int tipo;
	private Resultado resultado;
	
	final static int TIPO_TRABAJO_REPARACION = 0;
	final static int TIPO_TRABAJO_REVISION = 1;
	
	/**
	 * 
	 * @param id ID del trabajo
	 * @param descripcion Descripción del trabajo
	 * @param tipo Tipo del trabajo
	 */
	public Trabajo(int id, String descripcion, int tipo) {
		this.id = String.format("T%07d", id);
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	
	/**
	 * 
	 * @param id ID del trabajo
	 * @param trab Trabajo copia
	 */
	public Trabajo(int id, Trabajo trab) {
		this.id = String.format("T%07d", id);
		this.descripcion = trab.descripcion;
		this.tipo = trab.tipo;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id Establecer Id del trabajo
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * getDescripcion()
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establecer descripción del trabajo
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * getHoras()
	 * @return
	 */
	public double getHoras() {
		return horas;
	}

	/**
	 * Establecer horas del Trabajo
	 * @param horas Establecer horas del Trabajo
	 */
	public void setHoras(double horas) {
		this.horas = horas;
	}

	/**
	 * getTipo()
	 * @return
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo Establecer tipo del trabajo
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * getResultado()
	 * @return Resultado
	 */
	public Resultado getResultado() {
		return resultado;
	}

	/**
	 * 
	 * @param resultado Resultado (Finalizado, correcto...)
	 */
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	/**
	 * 
	 * @param horas Horas para incrementar al trabajo
	 * @return Resultado
	 */
	Resultado incrementarHoras(double horas) {
		if (resultado == Resultado.FINALIZADO) return Resultado.FINALIZADO;
		
		this.horas += horas;
		
		return Resultado.CORRECTO;
	}
	
	/**
	 * 
	 * @param tipo Tipo del Trabajo
	 * @return String
	 */
	public static String getTrabajoTipoNombre(int tipo) {
		switch(tipo) {
		case TIPO_TRABAJO_REPARACION:
			return "REPARACION";
		case TIPO_TRABAJO_REVISION:
			return "REVISION";
		default:
			return "DESCONOCIDO";
		}
	}
	
	/**
	 * 
	 * @return double
	 */
	public abstract double calcularPrecio();
	
	/**
	 * material
	 * @param importe Importe del Material
	 * @return Resultado
	 */
	public abstract Resultado usarMaterial(double importe);
	
	@Override
	public boolean equals(Object obj) {
		Trabajo trab = (Trabajo)obj;
		
		if (!this.descripcion.equals(trab.descripcion)) return false;
		if (this.horas != trab.horas) return false;
		if (this.tipo != trab.tipo) return false;
		return true;
	}

	@Override
	public int compareTo(Trabajo o) {
		return Double.compare(this.horas, o.horas) * -1; //-1 para invertir de MAYOR a MENOR
	}
}
