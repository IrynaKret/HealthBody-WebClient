package edu.softserveinc.healthbody.webclient.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailSender implements Runnable {

	private static final String USER_NAME = "healthbodyservice@gmail.com";
	private static final String PASSWORD = "healthbody185";
	private String subject;
	private String text;
	private String toEmail;
	public static EmailSender mailSender = null;
	private static Properties propetries = new Properties();

	private EmailSender() {

	}

	public void setParameters(String subject, String text, String toEmail) {
		this.subject = subject;
		this.text = text;
		this.toEmail = toEmail;
	}

	public static EmailSender getInstance() {
		if (mailSender == null) {
			mailSender = new EmailSender();
			propetries.put("mail.smtp.auth", "true");
			propetries.put("mail.smtp.starttls.enable", "true");
			propetries.put("mail.smtp.host", "smtp.gmail.com");
			propetries.put("mail.smtp.port", "587");
		}
		return mailSender;
	}

	public synchronized void send() {
		Session session = Session.getInstance(propetries, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASSWORD);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(USER_NAME));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			message.setText(text);

			message.setContent(text, "text/html; charset=utf-8");
			log.debug("send email to " + toEmail);
			Transport.send(message);

		} catch (MessagingException e) {
			log.error("failed to send email", e);
		}

	}

	@Override
	public void run() {
		this.send();
	}
	/*
	 * static { properties.put("mail.smtp.auth", "true");
	 * properties.put("mail.smtp.starttls.enable", "true");
	 * properties.put("mail.smtp.host", "smtp.gmail.com");
	 * properties.put("mail.smtp.port", "587"); }
	 * 
	 * public static void sendMail(String recipient, String subject, String
	 * body) throws MessagingException {
	 * 
	 * Session session = Session.getInstance(properties, new Authenticator() {
	 * protected PasswordAuthentication getPasswordAuthentication() { return new
	 * PasswordAuthentication(USER_NAME, PASSWORD); } });
	 * 
	 * Runnable AsyncThread = new Runnable() {
	 * 
	 * @Override public void run() { MimeMessage message = new
	 * MimeMessage(session);
	 * 
	 * try { message.setFrom(new InternetAddress(USER_NAME));
	 * message.addRecipient(Message.RecipientType.TO, new
	 * InternetAddress(recipient));
	 * 
	 * message.setSubject(subject);
	 * 
	 * message.setContent(body, "text/html; charset=utf-8");
	 * 
	 * log.debug("send email to " + recipient);
	 * 
	 * Transport.send(message); } catch (MessagingException e) {
	 * log.error("failed to send email", e); }
	 * 
	 * } };
	 * 
	 * 
	 * new Thread(AsyncThread).start(); }
	 */
}