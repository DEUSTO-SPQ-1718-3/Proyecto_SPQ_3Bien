package Cuotas;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**Clase con los metodos necesarios para enviar el email con la cuota correspondiente al estudiante.
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class enviar_Email {

/**
*Metodo que es llamado una vez pulsado el boton enviar en frmEnviarCuota y que dispone de todo el codigo para conectarse
*al gmail de la academia y enviar el mensaje. A traves de los parametros, se le pasa el email del estudiante al que se va a enviar el 
*correo y otros datos para completar el contenido.
*/
public void mandarCorreo(String nombre, String apellido, String email, int horas, int precio, String fecha) {
// El correo gmail de envío
String correoEnvia = "miAcademiaDonosti@gmail.com";
String claveCorreo = "miAcademia123";

// La configuración para enviar correo
Properties properties = new Properties();
properties.put("mail.smtp.host", "smtp.gmail.com");
properties.put("mail.smtp.starttls.enable", "true");
properties.put("mail.smtp.port", "587");
properties.put("mail.smtp.auth", "true");
properties.put("mail.user", correoEnvia);
properties.put("mail.password", claveCorreo);

// Obtener la sesion

Session session = Session.getInstance(properties, null);

try {
// Crear el cuerpo del mensaje
MimeMessage mimeMessage = new MimeMessage(session);

// Agregar quien envía el correo
mimeMessage.setFrom(new InternetAddress(correoEnvia, "miAcademia Donosti"));

// Los destinatarios
InternetAddress[] internetAddresses = {
new InternetAddress("pablovillegas@opendeusto.es")};

// Agregar los destinatarios al mensaje
mimeMessage.setRecipients(Message.RecipientType.TO,
internetAddresses);

// Agregar el asunto al correo
mimeMessage.setSubject("Cuota miAcademia");

// Creo la parte del mensaje
MimeBodyPart mimeBodyPart = new MimeBodyPart();
mimeBodyPart.setText("La cuota a pagar con fecha " + fecha + " por el estudiante " + nombre + " " + apellido + " por un total de " + horas + " horas realizadas en miAcademia es de " + precio + " €");

// Crear el multipart para agregar la parte del mensaje anterior
Multipart multipart = new MimeMultipart();
multipart.addBodyPart(mimeBodyPart);

// Agregar el multipart al cuerpo del mensaje
mimeMessage.setContent(multipart);

// Enviar el mensaje
Transport transport = session.getTransport("smtp");
transport.connect(correoEnvia, claveCorreo);
transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
transport.close();

} catch (Exception ex) {
ex.printStackTrace();
}
System.out.println("Correo enviado");
}

}