package com.jcertif.web.service;


import com.jcertif.web.model.Warid;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Named
@ApplicationScoped
public class EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @Inject
    private ResourceService res;

    public boolean sendWarid(final Warid waridBean) {
        boolean okResult = true;

        try {
            String template = setProperties(waridBean, res.getWaridMailTemplate());
            HtmlEmail email = new HtmlEmail();
            email.setHostName(res.getMailHost());
            email.setSmtpPort(res.getMailPort());
            email.setAuthentication(res.getMailUser(), res.getMailPassword());
            email.setSSLOnConnect(true);
            email.addTo(waridBean.getEmail());
            email.addCc("waridlab@waridtel.cg");
            if(res.getMailDiffusion().contains(",")) {
                String[] mails = res.getMailDiffusion().split(",");
                for(String mail : mails) {
                    email.addBcc(mail);
                }
            }
            email.setFrom(res.getMailUser(), "Warid Congo");
            email.setSubject(res.getLib("warid.mail.subject") + " (" + waridBean.getGroupName() + ")");
            email.setMsg(template);

            EmailAttachment attachment = new EmailAttachment();
            String fileName = res.getMailTempDir() + "/" + waridBean.getFile().getFileName() + "_" + waridBean.getGroupName() + "_" +  System.currentTimeMillis() + ".docx";
            FileOutputStream file = new FileOutputStream(fileName);
            file.write(waridBean.getFile().getContents());


            attachment.setPath(fileName);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setName(waridBean.getFile().getFileName());

            // add the attachment
            email.attach(attachment);

            email.send();
        } catch (EmailException e) {
            LOG.error("Warid Email Send Error",e);
            okResult = false;
        } catch (IllegalAccessException e) {
            LOG.error("Warid Email Template Error",e);
            okResult = false;
        } catch (InvocationTargetException e) {
            LOG.error("Warid Email Template Error",e);
            okResult = false;
        } catch (FileNotFoundException e) {
            LOG.error("Warid Email Template Error",e);
            okResult = false;
        } catch (IOException e) {
            LOG.error("Warid Email Template Error",e);
            okResult = false;
        }

        return okResult;

    }

    private String setProperties(final Warid waridBean, String htmlEmailTemplate) throws InvocationTargetException, IllegalAccessException {

        for(Method method : waridBean.getClass().getMethods()) {
            if(method.getName().startsWith("get")){
                htmlEmailTemplate = htmlEmailTemplate.replace("${" + method.getName() + "}", method.invoke(waridBean).toString());
            }
        }

        return htmlEmailTemplate;
    }
}
