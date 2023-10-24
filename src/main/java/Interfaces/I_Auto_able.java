package Interfaces;

import java.util.List;

import model.TblAuto;

public interface I_Auto_able {
	//Declaramos los metodos
	public void RegistrarAuto(TblAuto A);
	public void ActualizarAuto(TblAuto A);
	public void EliminarAuto(TblAuto A);
	public List<TblAuto> ListarAuto();
	public TblAuto BuscarAuto();
}//Fin de la interface
