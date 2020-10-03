package br.com.enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class AppTest {
	@Test
	public void testeEmail() {

		final String userName = "sr.programador.java@gmail.com";
		final String senha = "giordanob2";

		try {
			Properties properties = new Properties();

			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");/* Autorização */
			properties.put("mail.smtp.starttls", "true");/* Autenticação */
			properties.put("mail.smtp.host", "smtp.gmail.com");/* Servidor gmail google */
			properties.put("mail.smtp.port", "465");/* Porta do servidor */
			properties.put("mail.smtp.socketFactory.port", "465");/* Expecifica a porta a ser conectada pelo socket */
			properties.put("mail.smtp.socketFactory.class",
					"jajax.net.ssl.SSLSocketFactory");/* Classe socket de conexao ao SMTP */
			properties.put("mail.smtp.ssl.enable", "true");

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("sr.programador.java@gmail.com", "giordanob2");
				}
			});

			Address[] toUser = InternetAddress.parse("sr.programador.java@gmail.com, alyneodyicm@gmail.com");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sr.programador.java@gmail.com", "Giordano"));
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Chegou e-mail enviado com java");
			message.setText(
					"Olá programador, você acaba de receber um e-mail enviado com Java com curso de formação web");

			Transport.send(message);

			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
