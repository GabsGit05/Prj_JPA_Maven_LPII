package TestEntidades;

public class Prueba {

	public static void main(String[] args) {

		        int diaDeLaSemana = 3;
		        String nombreDia;

		        switch (diaDeLaSemana) {
		            case 1 : 
		            	nombreDia = "Lunes";
		            	break;
		            case 2 : 
		            	nombreDia ="Martes";
		            	break;
		            case 3 : 
		            	nombreDia = "Miércoles";
		            	break;
		            case 4 : 
		            	nombreDia = "Jueves";
		            	break;
		            case 5 : 
		            	nombreDia = "Viernes";
		            	break;
		            case 6 : 
		            	nombreDia = "Sábado";
		            	break;
		            case 7 : 
		            	nombreDia = "Domingo";
		            	break;
		            default : 
		            	nombreDia = "Día no válido";
		            	break;
		        };

		        System.out.println("Hoy es " + nombreDia);
		    }
}
