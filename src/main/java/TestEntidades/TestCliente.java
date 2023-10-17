package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		//Establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestionar entidades como registrar, actualizar, eliminar y buscar
		EntityManager Emanager = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emanager.getTransaction().begin(); //getTransaction => Sirve para iniciar las operaciones

		//----------------------------------------------
		
		//Realizamos una instancia
		TblCliente cliente = new TblCliente();
		//Aplicamos un switch
		String accion = JOptionPane.showInputDialog("¿Qué desea realizar?");
		switch (accion) {
		case "Registrar":
			//Ingresamos los valores a enviar a la BD
			cliente.setNombre("Angeles");
			cliente.setApellido("Roman");
			cliente.setEmail("Angeles@gmail.com");
			cliente.setDni("15802068");
			cliente.setSexo("F");
			//Registramos los datos con persistence
			Emanager.persist(cliente);
			//Emitimos un mensaje por consola
			System.out.println("Datos ingresados en la BD");
			//Confirmamos 	
			Emanager.getTransaction().commit();
			//Cerramos la transaccion
			Emanager.close();
			break;
		
		//----------------------------------------------
			
		case "Actualizar":
			//Seteamos el id a ser actualizado
			cliente.setIdcliente(3);
			cliente.setNombre("Angeles");
			cliente.setApellido("Yupanqui");
			cliente.setEmail("Angeles@gmail.com");
			cliente.setDni("15802068");
			cliente.setSexo("F");
			//Actualizamos
			Emanager.merge(cliente);
			//Emitimos un mensaje por consola
			System.out.println("Datos actualizados en la BD");
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos la transaccion
			Emanager.close();
			break;
		
		//----------------------------------------------
			
		case "Eliminar": //Segunda forma
			//Eliminando el codigo seleccionado
			TblCliente x = Emanager.find(TblCliente.class, 3);
			//Aplicamos una condicion 
			if(x == null){
				//Emitimos un mensaje
				System.out.println("Codigo no encontrado");
			}else{
				//Emitimos un mensaje
				System.out.println("Codigo encontrado");
				//Eliminamos
				Emanager.remove(x);
				//Confirmamos
				Emanager.getTransaction().commit();
				//Cerramos
				Emanager.close();
				//Emitimos un mensaje de validacion
				System.out.println("Datos eliminados");
			}
			break;
		
		//----------------------------------------------	
		
		case "Buscar":
			TblCliente b = Emanager.find(TblCliente.class, 6);
			//Aplicamos una condicion
			if(b == null){
				//Emitimos un mensaje
				System.out.println("Registro no encontrado");
			}else{
				//Emitimos un mensaje
				System.out.println("Registro encontrado");
				//Imprimimos
				System.out.println("Cod => " + b.getIdcliente() + 
						   		   "\nNombre => " + b.getNombre() +
						   		   "\nApellido => " + b.getApellido() +
						   		   "\nEmail => " + b.getEmail() +
						   		   "\nDNI => " + b.getDni() + 
						   		   "\nSexo => " + b.getSexo());
			}
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos la transaccion
			Emanager.close();
			break;
			
		//----------------------------------------------
		
		case "Listar":
			List<TblCliente> listado = Emanager.createQuery("Select c From TblCliente c",TblCliente.class).getResultList();
			//Mostramos los datos por consola
			for(TblCliente list:listado){
				System.out.println("------------------------------\n" +
								   "Cod => " + list.getIdcliente() + 
				   		   		   "\nNombre => " + list.getNombre() +
				   		   		   "\nApellido => " + list.getApellido() +
				   		   		   "\nEmail => " + list.getEmail() +
				   		   		   "\nDNI => " + list.getDni() + 
				   		   		   "\nSexo => " + list.getSexo());
			}//Fin del bucle
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos 
			Emanager.close();
			break;

		//----------------------------------------------	
		
		default:
			//Emitimos un mensaje por consola
			System.out.println("Accion no encontrada");
			break;
		}//Fin del switch
	}//Fin del metodo principal
}
