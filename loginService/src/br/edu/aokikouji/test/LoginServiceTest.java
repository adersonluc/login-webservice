package br.edu.aokikouji.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.aokikouji.model.LoginEntry;
import br.edu.aokikouji.service.LoginService;

public class LoginServiceTest {

	@Test
	public void loginCheckTest() {
		LoginEntry usuario = new LoginEntry("adersona", "lucas");
		LoginService ls = new LoginService();
		String resultado = ls.loginCheck(usuario);
		assertEquals("true", resultado);
	}

}
