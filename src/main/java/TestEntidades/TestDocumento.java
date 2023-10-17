package TestEntidades;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblDocumento;
import model.TblTipodocumento;

public class TestDocumento {

	public static void main(String[] args) {
		//Establecemos conexion con persistencia
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Permite gestionar entidades
		EntityManager Emng = conexion.createEntityManager();
		//Iniciamos transacciones
		Emng.getTransaction().begin();
		//Instanciamos las entidades
		TblDocumento doc = new TblDocumento();
		TblTipodocumento Tdoc = new TblTipodocumento();
		
		String accion = JOptionPane.showInputDialog("¿Que realizara?");
		switch (accion) {
		case "R":
			Tdoc.setNomdocum("Otros");
			Tdoc.setDescripdocum("Comprobante de Pago");
			Emng.persist(Tdoc);
			//
			doc.setNrodocument("10003");
			doc.setProveedocument("BioFarm");
			doc.setRucdocument("99188291791");
			Date fecha = new Date();
			Date fechasql = new Date(fecha.getTime());
			doc.setFecha(fechasql);
			doc.setDescripdocument("Inventariado");
			Emng.persist(doc);
			//Mensaje
			System.out.println("Registros Guardadoss");
			//Confirmamos la transaccion
			Emng.getTransaction().commit();
			//Cerramos
			Emng.close();
			//Cuando no usamos cascada debemos poner el persiste a ambas tablas 
			//pero si tenemos cascada debemos hacer el persist a la tabla padre  
			break;
		case "A":
			Tdoc.setIdtipodocum(1);
			Tdoc.setNomdocum("Ticket");
			Tdoc.setDescripdocum("Control Interno");
			Emng.merge(Tdoc);
			//
			doc.setIddocument(1);
			doc.setNrodocument("10002");
			doc.setProveedocument("MediFarmacos");
			doc.setRucdocument("99188291791");
			Date fechaII = new Date();
			Date fechasqlII = new Date(fechaII.getTime());
			doc.setFecha(fechasqlII);
			doc.setDescripdocument("Compra Mercaderia");
			Emng.merge(doc);
			//Mensaje
			System.out.println("Registros Actualizados");
			//Confirmamos
			Emng.getTransaction().commit();
			//Cerramos
			Emng.close();
			break;
		case "L":
			List<TblDocumento> listDoc = Emng.createQuery("Select d from TblDocumento d",TblDocumento.class).getResultList();
			//Aplicamos bucle for
			for(TblDocumento listado:listDoc){
				System.out.println("\nCodigo : " + listado.getIddocument() +
								   "\nN° Documento : " + listado.getNrodocument() +
								   "\nProveedor : " + listado.getProveedocument() +
								   "\nRUC : " + listado.getRucdocument() +
								   "\nFecha : " + listado.getFecha() + 
								   "\nDescripcion : " + listado.getDescripdocument() +
								   "\nCodigo T.Doc : " + listado.getTblTipodocumento().getIdtipodocum() +
								   "\nNombre Doc : " + listado.getTblTipodocumento().getNomdocum() +
								   "\nDescripcion T.Doc : " + listado.getTblTipodocumento().getDescripdocum());
			} //Error linea 82
			break;
		case "B":
			
			
			
			break;
		case "E":
			
			
			
			break;
		}//Fin switch
		
		
		
		
		
		
	}
}
