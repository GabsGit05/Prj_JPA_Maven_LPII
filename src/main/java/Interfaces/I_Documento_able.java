package Interfaces;

import java.util.List;

import model.TblDocumento;

public interface I_Documento_able {
	//Dexlaramos los metodos
	public void RegistrarDocumento(TblDocumento doc);
	public void ActualizarDocumento(TblDocumento doc);
	public void EliminarDocumento(TblDocumento doc);
	public List<TblDocumento> ListadoDocumentos();
	public TblDocumento BuscarDocumento(TblDocumento doc);
}
