package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClassCRUD_Auto_Imp;
import model.TblAuto;

/**
 * Servlet implementation class ControladorServlet
 */
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }//Fin constructor

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Recuperamos el listado de autos
		ClassCRUD_Auto_Imp Aimp = new ClassCRUD_Auto_Imp();
		List<TblAuto> List = Aimp.ListarAuto();
		//Enviamos a la vista 
		request.setAttribute("listado", List);
		request.getRequestDispatcher("/GestionAuto.jsp").forward(request, response);
	}//Fin GET

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//Recuperamos los valores del form que ingresa el usuario
		//
		String color = request.getParameter("color");
		String modelo = request.getParameter("modelo");
		String motor = request.getParameter("motor");
		Double precio = Double.parseDouble(request.getParameter("precio"));
		String marca = request.getParameter("marca");
		String fabricacion = request.getParameter("fabricacion");
		//Intanciamos
		TblAuto A = new TblAuto();
		ClassCRUD_Auto_Imp Aimp = new ClassCRUD_Auto_Imp();
		//Asignamos los valores 
		A.setColor(color);
		A.setModelo(modelo);
		A.setMotor(motor);
		A.setPrecio(precio);
		A.setMarca(marca);
		A.setFabricacion(fabricacion);
		//Invocamos al metodo registrar
		Aimp.RegistrarAuto(A);
		//Recuperamos el listado de autos
		List<TblAuto> List = Aimp.ListarAuto();
		//Enviamos a la vista 
		request.setAttribute("listado", List);
		//Redireccionamos
		request.getRequestDispatcher("/GestionAuto.jsp").forward(request, response);
	}//Fin POST
}
