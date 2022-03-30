import java.util.Scanner;

public class TestGaraje {
	public static void main(String[] args) {
		// Crear un garaje.
		Garaje garaje = new Garaje();

		Scanner entrada = new Scanner(System.in);
		mostrarMenu();
		int opcion = entrada.nextInt();
		entrada.nextLine();
		
		// Variables para usar en las opciones del menú
		Resultado resultado;
		String id;

		while(opcion!=0) {
			switch(opcion) {

			// 1- Crear trabajo
			case 1:
				System.out.println("Introduzca la descripción del trabajo:");
				String descripcion = entrada.nextLine();
				System.out.println("Introduzca el tipo de trabajo (reparación mecánica(1), reparación de chapa y pintura(2) o revisión(3)):");
				int tipo = entrada.nextInt();
				entrada.nextLine();
				// TODO: Completar llamada y comprobación de errores
				// ...
				
				Resultado res_nuevoTrabajo = garaje.nuevoTrabajo(descripcion, tipo);
				mostrarResultado(res_nuevoTrabajo);
				
				break;

				// 2- Añadir horas a un trabajo
			case 2:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				System.out.println("Introduzca el número de horas:");
				int horas = entrada.nextInt();
				entrada.nextLine();
				// TODO: Completar llamada y mostrar resultado
				// ...
				
				Resultado res_horas = garaje.añadirHoras(id, horas);
				mostrarResultado(res_horas);
				
				break;

				// 3- Añadir coste material a un trabajo
			case 3:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				System.out.println("Introduzca el importe del material:");
				int importe = entrada.nextInt();
				entrada.nextLine();
				// TODO: Completar llamada y mostrar resultado
				// ...
				
				Resultado res_importe = garaje.añadirMaterial(id, importe);
				mostrarResultado(res_importe);
				break;

				// 4- Listar trabajos
			case 4:
				// TODO: Realizar llamada y mostrar resultado
				// ...
				String listaTrabajos = garaje.listarTrabajos();
				if (listaTrabajos.length() > 0) System.out.println(listaTrabajos);
				else System.out.println("NO HAY TRABAJOS");
				
				break;

				// 5- Finalizar trabajo
			case 5:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				// TODO: Completar llamada y mostrar factura
				// ...
				double factura[] = garaje.finalizarTrabajo(id);
				
				System.out.println("Num. horas: "+factura[0]);
				System.out.println("Precio total: "+factura[1]);
				break;

				// 6- Duplicar revisión
			case 6:
				System.out.println("Introduzca el id del trabajo:");
				id = entrada.nextLine();
				// TODO: Completar llamada y mostrar resultado
				// ...
				Resultado res_dup = garaje.duplicarRevision(id);
				mostrarResultado(res_dup);
				break;

				// 7- Eliminar duplicados
			case 7:
				// TODO: llamada para eliminar duplicados
				// ...
				garaje.eliminarDuplicados();
				break;

				// Desconocido- Salir del programa
			default:
				opcion = 0;
			}
			// Mostramos menú y pedimos nueva opción
			mostrarMenu();
			opcion = entrada.nextInt();
			entrada.nextLine();
		}

		// Fin del programa
		System.out.println("Saliendo del programa");
		entrada.close();
	}

	// Mostrar el menú principal
	public static void mostrarMenu() {
		System.out.println("Elija una opción:");
		System.out.println("1- Crear un trabajo");
		System.out.println("2- Añadir horas a un trabajo");
		System.out.println("3- Añadir coste material a un trabajo");
		System.out.println("4- Listar trabajos");
		System.out.println("5- Finalizar trabajo");
		System.out.println("6- Duplicar revisión");
		System.out.println("7- Eliminar duplicados");
		System.out.println("0- Salir");
	}

	// Mostrar resultado obtenido en la operación
	public static void mostrarResultado(Resultado resultado) {
		switch(resultado) {
		case NO_EXISTE:
			System.out.println("El trabajo no existe");
			break;
		case TIPO_INCORRECTO:
			System.out.println("El trabajo no es del tipo adecuado para esta operación");
			break;
		case FINALIZADO:
			System.out.println("El trabajo está finalizado");
			break;
		case CORRECTO:
			System.out.println("La operación se ha realizado correctamente");
			break;
		default:
			break;
		}
	}
}
