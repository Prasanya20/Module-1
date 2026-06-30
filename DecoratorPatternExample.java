interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("SMS Notification: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Slack Notification: " + message);
    }
}

public class Main {
    public static void main(String[] args) {

        Notifier email = new EmailNotifier();
        System.out.println("Email Notification:");
        email.send("Your order has been placed.");

        System.out.println();

        Notifier emailSMS = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("Email + SMS Notification:");
        emailSMS.send("Your order has been shipped.");

        System.out.println();

        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        System.out.println("Email + SMS + Slack Notification:");
        allNotifications.send("Your order has been delivered.");
    }
}
