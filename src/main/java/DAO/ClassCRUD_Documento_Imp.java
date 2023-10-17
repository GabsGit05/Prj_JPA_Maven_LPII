package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.I_Documento_able;
import model.TblDocumento;

public class ClassCRUD_Documento_Imp implements I_Documento_able{

	@Override
	public void RegistrarDocumento(TblDocumento doc) {
		//Establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestor de entidades
		EntityManager Emng = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emng.getTransaction().begin();
		//Registramos
		Emng.persist(doc);
		//Confirmamos
		Emng.getTransaction().commit();
		//Cerramos
		Emng.close();
	}//Fin metodo

	@Override
	public void ActualizarDocumento(TblDocumento doc) {
		//Establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestor de entidades
		EntityManager Emng = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emng.getTransaction().begin();
		//Registramos
		Emng.merge(doc);
		//Confirmamos
		Emng.getTransaction().commit();
		//Cerramos
		Emng.close();
	}//Fin metodo

	@Override
	public void EliminarDocumento(TblDocumento doc) {
		//Establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestor de entidades
		EntityManager Emng = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emng.getTransaction().begin();
		//Recuperamos el codigo
		TblDocumento X = Emng.merge(doc);
		//Eliminamos 
		Emng.remove(X);
		//Confirmamos
		Emng.getTransaction().commit();
		//Cerramos
		Emng.close();
	}//Fin metodo

	@Override
	public List<TblDocumento> ListadoDocumentos() {
		//Establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestor de entidades
		EntityManager Emng = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emng.getTransaction().begin();
		//
		List<TblDocumento> listado = Emng.createQuery("Select d from TblDocumento d",TblDocumento.class).getResultList();
		//Confirmamos
		Emng.getTransaction().commit();
		//Cerramos
		Emng.close();
		//Retornamos la lista
		return listado;
	}//Fin metodo

	@Override
	public TblDocumento BuscarDocumento(TblDocumento doc) {
		//Establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestor de entidades
		EntityManager Emng = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emng.getTransaction().begin();
		//
		TblDocumento busca = Emng.find(TblDocumento.class, doc.getIddocument());
		//Confirmamos
		Emng.getTransaction().commit();
		//Cerramos 
		Emng.close();
		//Retornamos
		return busca;
	}//Fin metodo
}
