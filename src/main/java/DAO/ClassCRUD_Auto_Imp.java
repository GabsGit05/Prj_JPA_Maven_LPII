package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.I_Auto_able;
import model.TblAuto;

public class ClassCRUD_Auto_Imp implements I_Auto_able{

	public void RegistrarAuto(TblAuto A) {
		//Establecemos conexion
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Para gestionar los procesos
		EntityManager em = emf.createEntityManager();
		//Iniciamos la transaccion
		em.getTransaction().begin();
		//Registramos
		em.persist(A);
		//Confirmamos
		em.getTransaction().commit();
		//Cerramos
		em.close();
	}//Fin metodo Registrar

	public void ActualizarAuto(TblAuto A) {
		//Establecemos conexion
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Para gestionar los procesos
		EntityManager em = emf.createEntityManager();
		//Iniciamos la transaccion
		em.getTransaction().begin();
		//Actualizamos
		em.merge(A);
		//Confirmamos
		em.getTransaction().commit();
		//Cerramos
		em.close();	
	}//Fin metodo Actualizar

	public void EliminarAuto(TblAuto A) {
		//Establecemos conexion
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Para gestionar los procesos
		EntityManager em = emf.createEntityManager();
		//Iniciamos la transaccion
		em.getTransaction().begin();
		//Recuperamos el codigo
		TblAuto x = em.merge(A);
		//Removemos
		em.remove(x);
		//Confirmamos
		em.getTransaction().commit();
		//Cerramos
		em.close();
	}//Fin metodo Eliminar

	public List<TblAuto> ListarAuto() {
		//Establecemos conexion
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Para gestionar los procesos
		EntityManager em = emf.createEntityManager();
		//Iniciamos la transaccion
		em.getTransaction().begin();
		//
		List<TblAuto> Listado = em.createQuery("Select a from TblAuto a",TblAuto.class).getResultList();
		//Confirmamos
		em.getTransaction().commit();
		//Cerramos
		em.close();
		//Retornamos el listado
		return Listado;
	}//Fin metodo Listar

	public TblAuto BuscarAuto() {
		//
		return null;
	}//Fin metodo Buscar
}
