package TestEntidades;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.ClassCRUD_Empleado_Imp;
import model.TblEmpleado;


public class TestEmpleado {

	public static void main(String[] args) {
		//Realizamos las respectivas instancias
		TblEmpleado Emp = new TblEmpleado();
		ClassCRUD_Empleado_Imp E_Imp = new ClassCRUD_Empleado_Imp();
		
		String accion = JOptionPane.showInputDialog("¿Qué desea realizar?");
		switch (accion) {
		case "Registrar":
			//Ingresamos los valores 
			Emp.setNombre("Angeles");
			Emp.setApellido("Vera Muro");
			Emp.setSexo("F");
			Emp.setEmail(Emp.getNombre() + "@gmail.com");
			Emp.setDni("71301433");
			Emp.setTelf("986799150");
			//Convertimos la fecha a javasql
			Date Fecha = new Date(); //Date de java.util
			Date FechaSQL = new Date(Fecha.getTime());
			Emp.setFechanac(FechaSQL);
			//Invocamos al metodo
			E_Imp.RegistrarEmpleado(Emp);
			//Emitimos un mensaje
			System.out.println("Empleado registrado en BD");
			break;
			//----------------------------------------------------
		case "Actualizar" :
			//Ingresamos los datos
			Emp.setIdempleado(1);
			Emp.setNombre("Luis");
			Emp.setApellido("Fernandez Cabrera");
			Emp.setSexo("M");
			Emp.setEmail(Emp.getNombre() + "@gmail.com");
			Emp.setDni("71301433");
			Emp.setTelf("986799150");
			//Convertimos la fecha a sql
			Date Fecha_II = new Date();
			Date FechaSQL_II= new Date(Fecha_II.getTime());
			Emp.setFechanac(FechaSQL_II);
			//Invocamos al metodo 
			E_Imp.ActualizarEmpleado(Emp);
			//Emitimos un mensaje 
			System.out.println("Empleado Actualizado en BD");
			break;
			//----------------------------------------------------
		case "Eliminar" :
			//Ingresamos el codigo 
			Emp.setIdempleado(2);
			//Invocamos al metodo
			E_Imp.EliminarEmpleado(Emp);
			//Emitimos un mensaje
			System.out.println("Empleado Eliminado en BD");
			break;
			//----------------------------------------------------
		case "Listar" :
			//Creamos una listya e invocamos al metodo
			List<TblEmpleado> Listar = E_Imp.ListaEmpleado();
			//Imprimimos
			for(TblEmpleado List:Listar){
				System.out.println("ID:" + List.getIdempleado() +
								   "\nNombre:" + List.getNombre() +
								   "\nApellido:" + List.getApellido() +
								   "\nSexo:" + List.getSexo() +
								   "\nEmail:" + List.getEmail() +
							       "\nDNI:" + List.getDni() +
								   "\nTelefono:" + List.getTelf() +
								   "\nNacimiento:" + List.getFechanac() +
								   "\n------------------------------------");
			}
			break;
			//----------------------------------------------------
		case "Buscar" :
			//Ingresamos el metodo y el codigo a buscar
			Emp.setIdempleado(3);
			TblEmpleado E = E_Imp.BuscarEmpleadoCodigo(Emp);
			//Impirmimos
			System.out.println("ID:" + E.getIdempleado() +
					   		   "\nNombre:" + E.getNombre() +
					   		   "\nApellido:" + E.getApellido() +
					   		   "\nSexo:" + E.getSexo() +
					   		   "\nEmail:" + E.getEmail() +
					   		   "\nDNI:" + E.getDni() +
					   		   "\nTelefono:" + E.getTelf() +
					   		   "\nNacimiento:" + E.getFechanac() +
					   		   "\n------------------------------------");
			break;
			//----------------------------------------------------
		default:
			break;
		}//Fin del switch
	}//Fin del metodo
}//Fin de clase
