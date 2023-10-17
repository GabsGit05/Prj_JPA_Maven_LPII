package Interfaces;

import java.util.List;

import model.TblEmpleado;

public interface I_Empleado_able {
	//Creamos los respectivos metodos
	public void RegistrarEmpleado(TblEmpleado Emp);
	public void ActualizarEmpleado(TblEmpleado Emp);
	public void EliminarEmpleado(TblEmpleado Emp);
	public List<TblEmpleado> ListaEmpleado();
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado Emp);
}//Fin de la interfaz
