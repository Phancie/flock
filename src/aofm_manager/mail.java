package aofm_manager;

import java.util.Properties; 
import javax.activation.DataHandler; 
import javax.activation.DataSource; 
import javax.activation.FileDataSource; 
import javax.mail.BodyPart; 
import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.Multipart; 
import javax.mail.PasswordAuthentication; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeBodyPart; 
import javax.mail.internet.MimeMessage; 
import javax.mail.internet.MimeMultipart; 
import javax.swing.JOptionPane;


public class mail 
{ 
    static String details;

    public mail(String senderName, String to) {
        System.out.println("in mail handler");
        //Attachments array
        String attachments[] = {"c:\\Flock\\BarChart.jpeg"}; 
        
        // Recipient's email ID needs to be mentioned. 
        //String to = "busben97@gmail.com"; 
        // Sender's email ID needs to be mentioned 
        String from = "flockmanagment@gmail.com"; 
        //final String username = "manishaspatil";
//change accordingly 
        final String password = "psalm231";
//change accordingly 
// Assuming you are sending email through relay.jangosmtp.net 
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
// Get the Session object. 
        Session session = Session.getInstance(props, new javax.mail.Authenticator() 
        { 
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            { 
                return new PasswordAuthentication(from, password);
            }
        });
        
        try 
        { 
// Create a default MimeMessage object. 
            Message message = new MimeMessage(session); 
// Set From: header field of the header. 
            message.setFrom(new InternetAddress(from)); // Set To: header field of the header.

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); 
// Set Subject: header field 
            message.setSubject("ANNUAL MICRO-CHURCH GROWTH CHART(AMGC)  "); 
// Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart(); 
// Now set the actual message 
            String messageBody = "Hello,\nPlease find the attached file of "+senderName+"\'s Annual Micro-Church Growth chart .\nNB: This email is automated please do not reply as you may not get any feedback.\n\nThank You.\nThe Flock Team";
            messageBodyPart.setText(messageBody); 
// Create a multipar message 
            Multipart multipart = new MimeMultipart(); 
// Set text message part 
            multipart.addBodyPart(messageBodyPart); 
// Part two is attachment 
            for(int i = 0; i < attachments.length; i++)
            {
                messageBodyPart = new MimeBodyPart(); 
                String filename = attachments[i]; 
                DataSource source = new FileDataSource(filename); 
                messageBodyPart.setDataHandler(new DataHandler(source)); 
                messageBodyPart.setFileName(filename); 
                multipart.addBodyPart(messageBodyPart); 
                System.out.println(filename);
            }
// Send the complete message parts 
            message.setContent(multipart); 
// Send message 
            Transport.send(message); 
            JOptionPane.showMessageDialog(null,"Chart Delivered Successfully!", "Statistics Message", 1); 
        } 
        catch (MessagingException e) 
        { 
            JOptionPane.showMessageDialog(null, "An error occured while sending email.\nPlease make there is an active internet connection","Email Message", 0);
            throw new RuntimeException(e);    
        }
    }
    
    
//    public static void main(String[] args) 
//    { 
//        mail m = new mail();
//        m.deliveryMethod();
//    }
}


