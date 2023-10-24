<%@page import="model.TblAuto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Importamos -->
<%@page import="java.util.*"%>
<%@page import="model.TblAuto"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Auto</title>
</head>
<body bgcolor="#E5F0B5">
	<h1>Gestionar Auto</h1>
	<form action="ControladorServlet" method="post">
		<table>	
			<tr>
				<td>Color</td>
				<td><input type="text" name="color" class="form-control"></td>
			</tr>	
			<tr>
				<td>Modelo</td>
				<td><input type="text" name="modelo" class="form-control"></td>
			</tr>
			<tr>
				<td>Motor</td>
				<td><input type="text" name="motor"></td>
			</tr>
			<tr>
				<td>Precio</td>
				<td><input type="text" name="precio"></td>
			</tr>
			<tr>
				<td>Marca</td>
				<td><input type="text" name="marca"></td>
			</tr>
			<tr>
				<td>Fabricacion</td>
				<td><input type="text" name="fabricacion"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Registrar"></td>
			</tr>
		</table>
	</form>
	
	
	<!-- Listado de Autos -->
	<table border="2">
		<tr>
			<th>Codigo</th>
			<th>Color</th>
			<th>Modelo</th>
			<th>Motor</th>
			<th>Precio</th>
			<th>Marca</th>
			<th>Fabricacion</th>
		</tr>
		<%
			List<TblAuto> Listado = (List<TblAuto>)request.getAttribute("listado"); 
			if(Listado != null){
				for(TblAuto List:Listado){
		%>
		<tr>
			<td><%=List.getIdauto()%></td>
			<td><%=List.getColor()%></td>
			<td><%=List.getModelo()%></td>
			<td><%=List.getMotor()%></td>
			<td><%=List.getPrecio()%></td>
			<td><%=List.getMarca()%></td>
			<td><%=List.getFabricacion()%></td>
		</tr>
		<%			
				}
			}
		%>
	</table>
	
	
</body>
</html>