package com.santiago.AppDisney.email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@NoArgsConstructor
@Component
public class ConfigEmail {


    public String sendEmail(String receptor) throws IOException {

        Email from = new Email("hermanramirezsantiago@gmail.com");
        String subject = "Bienvenido a disney app";
        Email to = new Email(receptor);
        from.setName("Disney");
        Content content = new Content("text/plain", "bienvenido a disney app,que comience la aventura de conocer este mundo magico");
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
           /* System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());*/
        } catch (IOException ex) {
            throw ex;
        }
        return "ok";
    }
}
