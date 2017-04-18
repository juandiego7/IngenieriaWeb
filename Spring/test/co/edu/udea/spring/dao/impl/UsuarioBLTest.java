package co.edu.udea.spring.dao.impl;

import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.spring.bl.UsuarioBL;
import co.edu.udea.spring.dao.UsuarioDAO;
import co.edu.udea.spring.dto.Usuario;
import co.edu.udea.spring.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:config.xml")
public class UsuarioBLTest {

	@Autowired//Inyectar datos desde la base de datos
	UsuarioBL usuarioBL;
		
	@Test
	public void testValidarUsuario() {
		boolean usuario = false; //Defino el objeto para almacenar el Usuario
		try{
			usuario = usuarioBL.validarUsuario("elver","1g0/KkFdhrmg1DYJWFdd2A=="); 
			assertTrue(usuario);		
		}catch (MyException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
	}

}
