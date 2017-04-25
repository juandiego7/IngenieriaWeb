package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.spring.bl.UsuarioBL;
import co.edu.udea.spring.exception.MyException;

/**
 * @author Juan Diego Goez - diego.goez@udea.edu.co
 *
 */
@Path("usuario")
@Component//Para reconocer el proyecto de Spring
public class UsuarioWS {
	
	@Autowired
	UsuarioBL usuarioBL;
	
	@GET//metodo al que responde
	@Produces(MediaType.TEXT_HTML)
	public String autenticar(@QueryParam("login")String login,
							 @QueryParam("pws")String pws){
		try {
			usuarioBL.validarUsuario(login, pws);
		} catch (MyException e) {
				return e.getMessage();
		}
		return "";
	}
}
