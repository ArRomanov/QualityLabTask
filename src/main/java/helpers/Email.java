package helpers;

/**
 * The class for creating of new email
 */
public class Email {

    private String emailAddress;
    private String subject;
    private String body;

    public String getSubject() {
        return subject;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Email setBody(String body) {
        this.body = body;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Email setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
}
