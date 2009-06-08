package Email;

import com.jscape.inet.email.EmailMessage;
import com.jscape.inet.smtpssl.SmtpSsl;



/**
 * Classe que manda um email a partir de uma conta do Gmail
 * 
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 	20621165
 * @author Renata Braga		20721334
 * @author Tatyanne Lapa	20621176
 */	
 
 
public class EmailGMAIL {
	private static String loginEmail, senhaEmail, titulo, destinatario, mensagem, mailSMTPServer;
	private static int mailSMTPServerPort;
	
	private static final String SMTP_GMAIL = "smtp.gmail.com";
	private static final int SMTP_GMAIL_PORT = 465;	
	
	/**
	 * Metodo estatico usado para enviar um email a partir de uma conta do Gmail
	 * @param remetenteLogin - o login do Gmail de quem quer enviar o email
	 * @param remetenteSenha - a senha da conta do Gmail do remetente
	 * @param para - o email do destinatario
	 * @param tituloEmail - titulo do email
	 * @param mensagemEmail - 'body text' do email
	 */
	public static void enviarEmailPeloGmail(String remetenteLogin, String remetenteSenha, 
								 String para, String tituloEmail, String mensagemEmail){
		loginEmail = remetenteLogin;
		senhaEmail = remetenteSenha;
		destinatario = para;
		titulo = tituloEmail;
		mensagem = mensagemEmail;
		
		try{
			SmtpSsl smtp = null;
			
			smtp = new SmtpSsl(SMTP_GMAIL, SMTP_GMAIL_PORT);
			
			smtp.connect();
			
			smtp.login(loginEmail, senhaEmail);
			
			EmailMessage message = new EmailMessage();
			message.setTo(destinatario);
			message.setFrom(loginEmail);
			message.setSubject(tituloEmail);
			message.setBody(mensagemEmail);
			
			smtp.send(message);
			
			smtp.disconnect();			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
