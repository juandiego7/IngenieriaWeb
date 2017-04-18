package co.edu.udea.spring.dao.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.spring.bl.ClienteBL;
import co.edu.udea.spring.dto.Cliente;
import co.edu.udea.spring.dto.Direccion;
import co.edu.udea.spring.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:config.xml")
public class ClienteBLTest {

	@Autowired
	ClienteBL clienteBL;
	
	@Test
	public void testObtener() {
		List<Cliente> resultado = null;
		try {
			resultado = clienteBL.obtener();
//			for(Cliente c: resultado){
//				System.out.println("Cliente: " + c.getNombres() +" Cedula: "+c.getCedula());
//				Set<Direccion> dir = c.getDirecciones();
//				for(Direccion d: dir){
//					System.out.println("Nombre: "+ c.getNombres() + " Direcci�n: "+d.getDireccion());
//				}
//			}
			assertTrue(resultado.size() > 0);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
