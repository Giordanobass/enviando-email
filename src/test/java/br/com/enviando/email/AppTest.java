package br.com.enviando.email;

import org.junit.Test;

public class AppTest {
	@Test
	public void testeEmail() throws Exception {

		StringBuilder stringBuilderTextoEmail = new StringBuilder();

		stringBuilderTextoEmail.append(" Olá,<br/><br/> ");
		stringBuilderTextoEmail.append("Você está recebendo o acesso ao curso de Java.<br/><br/>");
		stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo.<br/><br/>");

		stringBuilderTextoEmail.append("<b>Login:</b>giordano@gmail.com<br/>");
		stringBuilderTextoEmail.append("<b>senha:</b>sdafaasdf<br/>");

		stringBuilderTextoEmail.append(
				"<a target=\"_blank\" href=\"www.bing.com\" style=\" color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier; border : 3px solid green; background-color:#99DA39;\" >Acessar ao bing</a>");

		stringBuilderTextoEmail.append("<span style=\"font-size:8px\">Ass.: Giordano curso.</span>");

		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("sr.programador.java@gmail.com", "Giordano",
				"Testando e-mail com Java", stringBuilderTextoEmail.toString());
		enviaEmail.enviarEmail(true);
		Thread.sleep(5000);

	}
}
