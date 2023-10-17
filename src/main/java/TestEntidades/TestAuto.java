package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		//Establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestionar entidades como registrar, actualizar, eliminar y buscar
		EntityManager Emanager = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emanager.getTransaction().begin(); //getTransaction => Sirve para iniciar las operaciones
		
		//----------------------------------------------
		
		//Realizamos una instancia
		TblAuto auto = new TblAuto();
		//Aplicamos un switch
		String accion = JOptionPane.showInputDialog("¿Qué desea realizar?");
		switch (accion) {
		case "Registrar":
			//Ingresamos valores a enviar a la base de datos
			auto.setColor("Negro");
			auto.setModelo("Model 2");
			auto.setMotor("1.5");
			auto.setPrecio(50000);
			auto.setMarca("Hyundai");
			auto.setFabricacion("2016");
			//Registramos los datos con persistence
			Emanager.persist(auto);
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
			auto.setIdauto(1);
			auto.setColor("Negro");
			auto.setModelo("Ryo");
			auto.setMotor("1.2");
			auto.setPrecio(18000);
			auto.setMarca("Kya");
			auto.setFabricacion("2016");
			//Actualizamos
			Emanager.merge(auto);
			//Emitimos un mensaje por consola
			System.out.println("Datos actualizados en la BD");
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos la transaccion
			Emanager.close();
			break;
			
			//----------------------------------------------
			
		case "Eliminar": //Primera forma de eliminar
			//Codigo a eliminar
			auto.setIdauto(2);
			TblAuto x = Emanager.merge(auto);
			//Realizamos la eliminacion
			Emanager.remove(x);
			//Emitimos un mensaje por consola
			System.out.println("Datos Eliminamos en la BD");
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos la transaccion
			Emanager.close();
			break;	
		
			//----------------------------------------------
			
		case "Buscar":
			TblAuto b = Emanager.find(TblAuto.class, 3);
			//Aplicamos una condicion
			if (b == null){
				//Emitimos un mensaje por consola
				System.out.println("Registro no encontrado");
			}else{
				System.out.println("Registro encontrado");
				//Imprimimos
				System.out.println("Cod => " + b.getIdauto() + 
								   "\nColor => " + b.getColor() +
								   "\nModelo => " + b.getModelo() +
								   "\nMotor => " + b.getMotor() +
								   "\nPrecio => " + b.getPrecio() + 
								   "\nMarca => " + b.getMarca() +
								   "\nFabricación => " + b.getFabricacion());
			}
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos la transaccion
			Emanager.close();
			break;
			
			//----------------------------------------------
			
		case "Listar":
			List<TblAuto> listado = Emanager.createQuery("Select a From TblAuto a",TblAuto.class).getResultList();
			//Mostramos los datos por consola
			for(TblAuto list:listado){
				System.out.println("------------------------------\n" +
								   "Cod => " + list.getIdauto() + 
								   "\nColor => " + list.getColor() +
								   "\nModelo => " + list.getModelo() +
								   "\nMotor => " + list.getMotor() +
								   "\nPrecio => " + list.getPrecio() + 
								   "\nMarca => " + list.getMarca() +
								   "\nFabricación => " + list.getFabricacion());
			}//Fin del bucle
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos 
			Emanager.close();
			break;
			
			//----------------------------------------------
			
			default:
				//Emitimos mensaje por pantalla
				System.out.println("Accion no encontrada");
				break;
		}//Fin del swicth
	}//Fin del metodo principal
}
