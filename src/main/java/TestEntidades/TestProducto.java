package TestEntidades;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblCategoria;
import model.TblProducto;

public class TestProducto {

	public static void main(String[] args) {
		//Establecemos conexion con la unidad de persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Gestionar entidades como registrar, actualizar, eliminar y buscar
		EntityManager Emanager = conexion.createEntityManager();
		//Iniciamos la transaccion
		Emanager.getTransaction().begin();//getTransaction => Sirve para iniciar las operaciones
		//-------------------------------------------
		//Realizamos las respctevitas instancias
		TblProducto P = new TblProducto();
		TblCategoria C = new TblCategoria();
		//Realizamos un switch		
		String accion = JOptionPane.showInputDialog("¿Qué desea realizar?");
		switch (accion) {
		case "R":
			//Ingresamos datos a la tabla categoria
			C.setNomcatg("Otros");
			C.setDescrip("Producto alto y bajo precio");
			//Ingresamos datos a la tabla producto
			P.setNomprod("Cetirizina");
			P.setPrecio(8.00);
			Date fech = new Date();
			Date fechasql = new Date(fech.getTime());
			P.setFechavenc(fechasql);
			P.setCodbarras("774350");
			P.setNrolote("L003");
			//Asignamos el objeto C
			P.setTblCategoria(C);
			Emanager.persist(P);
			//Emitimos mensaje por consola 
			System.out.println("Dato registrado");
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos 
			Emanager.close();
			break;
		case "A":
			C.setIdcategoria(1);
			C.setNomcatg("Generico");
			C.setDescrip("Recomendado por el MINSA");
			//
			P.setIdproducto(1);
			P.setNomprod("Paracetamol");
			P.setPrecio(6.00);
			Date fech2 = new Date();
			Date fechasql2 = new Date(fech2.getTime());
			P.setFechavenc(fechasql2);
			P.setCodbarras("774200");
			P.setNrolote("L004");
			//
			P.setTblCategoria(C);
			//Actualiamos
			Emanager.merge(P);
			//Emitimos mensaje
			System.out.println("Dato actualizado");
			//Confirmamos
			Emanager.getTransaction().commit();
			//Cerramos
			Emanager.close();
			break;
		case "E":
			break;
		case "L":
			break;
		case "B":
			break;
		}//Fin switch
	}//Fin del main
}//Fin de la clase
