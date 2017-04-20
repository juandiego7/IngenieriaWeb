package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Servicio
 * @author Juan Diego Goez Durango - diego.goez@udea.edu.co
 *
 */
@Path("saludo")//Definicion de la ruta con que va a responder el servicio
public class PrimerEjemplo {

	@GET//Identificar el metodo http con que responde este metodo
	@Produces(MediaType.TEXT_HTML)//Formato de respuesta
	public String saludar(){
		return "Buenas tardes";
	}
	
	@GET//Identificar el metodo http con que responde este metodo
	@Produces(MediaType.APPLICATION_JSON)//Formato de respuesta
	@Path("2")//Definicion de la ruta para invocar este metodo
	public String saludar2(){
		return "Hola";
	}
	
	@POST//Identificar el metodo http con que responde este metodo
	@Produces(MediaType.APPLICATION_XML)//Formato de respuesta
	@Path("3")//Definicion de la ruta para invocar este metodo
	public String saludar3(@QueryParam("a")String nombre/*para solicitar los parametros*/){
		return "buenas tardes " + nombre;
	}
	
	@POST//Identificar el metodo http con que responde este metodo
	@Produces(MediaType.APPLICATION_XML)//Formato de respuesta
	@Path("4/{a}")//Definicion de la ruta para invocar este metodo
	public String saludar4(@PathParam("a")String nombre/*para solicitar los parametros*/){
		return "buenas noches " + nombre;
	}
}
