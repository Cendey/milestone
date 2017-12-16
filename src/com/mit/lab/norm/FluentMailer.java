package com.mit.lab.norm;

import java.util.function.Consumer;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: FluentMailer</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 4/23/2014
 */
public class FluentMailer {

    private String mailFrom;
    private String mailTo;
    private String mailSubject;
    private String mailBody;

    private FluentMailer() {
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public FluentMailer from(final String mailFrom) {
        setMailFrom(mailFrom);
        return this;
    }

    public FluentMailer to(final String mailTo) {
        setMailTo(mailTo);
        return this;
    }

    public FluentMailer subject(final String mailSubject) {
        setMailSubject(mailSubject);
        return this;
    }

    public FluentMailer body(final String mailBody) {
        setMailBody(mailBody);
        return this;
    }

    public static void send(final Consumer<FluentMailer> block) {
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("The mail is sending...");
        System.out.println(String.format("From   : %s", mailer.getMailFrom()));
        System.out.println(String.format("To     : %s", mailer.getMailTo()));
        System.out.println(String.format("Subject: %s", mailer.getMailSubject()));
        System.out.println(String.format("Body   : %s", mailer.getMailBody()));
    }
}
