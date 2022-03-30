import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Clase principal Garaje
 * Implementa la interfaz Tienda y crea los métodos necesarios para utilizarlos
 * por el menú interactivo.
 */
public class Garaje implements Tienda {
	
	Map<String, Trabajo> trabajos;
	
	private int CONTEO_TRABAJOS = 0;
	
	final private static int OPCION_TIPO_TRABAJO_REPARACION_MECANICA = 1;
	final private static int OPCION_TIPO_TRABAJO_REPARACION_CHAPA_Y_PINTURA = 2;
	final private static int OPCION_TIPO_TRABAJO_REVISION = 3;

	/**
	 * Initializamos la clase Garaje
	 */
	public Garaje() {
		trabajos = new HashMap<String, Trabajo>();
	}
	
	/**
	 * @param descripcion Descripción del trabajo
	 * @param tipo Tipo del trabajo (Opción en el menú -> Tipo trabajo)
	 * @return Resultado
	 */
	@Override
	public Resultado nuevoTrabajo(String descripcion, int tipo) {
		Trabajo trabajo = null;
		int numId = Integer.valueOf(CONTEO_TRABAJOS);
		String id = String.format("T%07d", numId);

		//el tipo de opción en el menú es diferente al subtipo en cada trabajo
		switch(tipo) {
		case OPCION_TIPO_TRABAJO_REPARACION_MECANICA:
		case OPCION_TIPO_TRABAJO_REPARACION_CHAPA_Y_PINTURA:
			if (tipo == OPCION_TIPO_TRABAJO_REPARACION_MECANICA) 
				tipo = Reparaciones.TIPO_REPARACION_MECANICA;
			else if (tipo == OPCION_TIPO_TRABAJO_REPARACION_CHAPA_Y_PINTURA)
				tipo = Reparaciones.TIPO_REPARACION_CHAPA_Y_PINTURA;

			trabajo = new Reparaciones(numId, descripcion, tipo);
			break;
		case OPCION_TIPO_TRABAJO_REVISION:
			trabajo = new Revisiones(numId, descripcion);
			break;
		default:
			return Resultado.TIPO_INCORRECTO;
		}
		
		trabajos.put(id, trabajo);
		
		CONTEO_TRABAJOS++; //en una base de datos no se debe decrementar el ID (rendimiento) y debe ser único
		
		return Resultado.CORRECTO;
	}

	/**
	 * @param id ID del trabajo
	 * @param horas Horas del trabajo
	 * @return Resultado
	 */
	@Override
	public Resultado añadirHoras(String id, int horas) {
		Trabajo trabajo = trabajos.get(id);
		if (trabajo == null) return Resultado.NO_EXISTE;
		if (horas < 0) return Resultado.TIPO_INCORRECTO;
		
		return trabajo.incrementarHoras(horas);
	}

	/**
	 * @param id ID del trabajo
	 * @param importe Importe del material
	 * @return Resultado
	 */
	@Override
	public Resultado añadirMaterial(String id, int importe) {
		Trabajo trabajo = trabajos.get(id);
		if (trabajo == null) return Resultado.NO_EXISTE;
		if (trabajo.getTipo() != Trabajo.TIPO_TRABAJO_REPARACION) return Resultado.TIPO_INCORRECTO;
		
		return trabajo.usarMaterial(importe);
	}

	/**
	 * @param id ID del trabajo
	 * @return double[] horas,precioFinal
	 */
	@Override
	public double[] finalizarTrabajo(String id) {
		Trabajo trabajo = trabajos.get(id);
		if (trabajo == null) return null;
		
		double trabajoPrecioHoras = trabajo.getHoras() * 30;

		trabajo.setResultado(Resultado.FINALIZADO);
		
		double[] res = {trabajo.getHoras(), trabajoPrecioHoras + trabajo.calcularPrecio()};
		
		return res;
	}

	/**
	 * @return String Trabajos ordenada de mayor horas a menor horas
	 */
	@Override
	public String listarTrabajos() {
		ArrayList<Trabajo> temp = new ArrayList<Trabajo>(trabajos.values());
		
		Collections.sort(temp);

		String res = "";
		for(Trabajo trab : temp) {
			res += trab.toString();
			res += "\n";
		}
		return res;
	}

	/**
	 * @param id ID del trabajo
	 * @return Resultado
	 */
	@Override
	public Resultado duplicarRevision(String id) {
		Trabajo trabajo = trabajos.get(id);
		if (trabajo == null) return Resultado.NO_EXISTE;
		
		if (trabajo.getTipo() != Trabajo.TIPO_TRABAJO_REVISION) return Resultado.TIPO_INCORRECTO;
		
		Revisiones revTrabajo = (Revisiones)trabajo;
		
		int nuevaIID = Integer.valueOf(CONTEO_TRABAJOS);
		String nuevaId = String.format("T%07d", nuevaIID);
		Revisiones nuevaRev = new Revisiones(revTrabajo, nuevaIID);
		
		trabajos.put(nuevaId, nuevaRev);
		
		return Resultado.CORRECTO;
	}

	/**
	 */
	@Override
	public void eliminarDuplicados() {
		//hay que crear una instancia de hashset nueva separada de trabajos ya que no le gusta que borremos mientras está en bucle
		for(String id : new HashSet<String>(trabajos.keySet())) {
			for(String buscarId : new HashSet<String>(trabajos.keySet())) {
				if (id.equals(buscarId)) continue; //que no se elimine a sí mismo
				if (trabajos.get(id) == null) continue;
				
				if (trabajos.get(id).equals(trabajos.get(buscarId))) {
					System.out.println("Eliminando "+buscarId+", duplicado de "+id);
					
					trabajos.remove(buscarId);
				}
			}
		}
		
	}
	
}
