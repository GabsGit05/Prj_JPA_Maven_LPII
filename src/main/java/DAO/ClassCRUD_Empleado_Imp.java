package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Interfaces.I_Empleado_able;
import model.TblEmpleado;

public class ClassCRUD_Empleado_Imp implements I_Empleado_able{

	@Override
	public void RegistrarEmpleado(TblEmpleado Emp) {
		//Establecemos la conexion con la unidad de persistencua
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades 
		EntityManager Emanager = conexion.createEntityManager(); 
		//Realizamos el proceso
			//Iniciamos la transaccion
		Emanager.getTransaction().begin();
		//Registramos datos
		Emanager.persist(Emp);
		//Confirmamos
		Emanager.getTransaction().commit();
		//Cerramos
		Emanager.close();
	}//Fin registrar

	@Override
	public void ActualizarEmpleado(TblEmpleado Emp) {
		//Establecemos la conexion con la unidad de persistencua
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades 
		EntityManager Emanager = conexion.createEntityManager(); 
		//Realizamos el proceso
			//Iniciamos la transaccion
		Emanager.getTransaction().begin();
		//Actualizamos datos
		Emanager.merge(Emp);
		//Confirmamos
		Emanager.getTransaction().commit();
		//Cerramos
		Emanager.close();
	}//Fin actualizar

	@Override
	public void EliminarEmpleado(TblEmpleado Emp) {
		//Establecemos la conexion con la unidad de persistencua
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades 
		EntityManager Emanager = conexion.createEntityManager(); 
		//Realizamos el proceso
			//Iniciamos la transaccion
		Emanager.getTransaction().begin();
		//Recuperamos el codigo a eliminar 
		//1° FORMA DE ELIMINAR
		TblEmpleado X = Emanager.merge(Emp);   
		//Eliminamos el dato de la base de datos
		Emanager.remove(X);
		//Confirmamos
		Emanager.getTransaction().commit();
		//Cerramos
		Emanager.close();
	}//Fin eliminar

	@Override
	public List<TblEmpleado> ListaEmpleado() {
		//Establecemos la conexion con la unidad de persistencua
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades 
		EntityManager Emanager = conexion.createEntityManager(); 
		//Realizamos el proceso
			//Iniciamos la transaccion
		Emanager.getTransaction().begin();
		//Aplicamos JPQL en base a entidades
		List<TblEmpleado> Listado = Emanager.createQuery("Select e from TblEmpleado e", TblEmpleado.class).getResultList();
		//Confirmamos
		Emanager.getTransaction().commit();
		//Cerramos
		Emanager.close();
		//Retornamos el listado
		return Listado;
	}//Fin lista

	@Override
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado Emp) {
		//Establecemos la conexion con la unidad de persistencua
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades 
		EntityManager Emanager = conexion.createEntityManager(); 
		//Realizamos el proceso
			//Iniciamos la transaccion
		Emanager.getTransaction().begin();
		//Enviamos el codigo que queremos buscar en la bd
		TblEmpleado Buscado = Emanager.find(TblEmpleado.class,Emp.getIdempleado());
		//Confirmamos
		Emanager.getTransaction().commit();
		//Cerrramos 
		Emanager.close();
		//Retornamos el valor buscado
		return Buscado;
	}//Fin busqueda
}//Fin de la clase
