interface Messenger {
    void notify(String message);
}

class EmailMessenger implements Messenger {
    @Override
    public void notify(String message) {
        System.out.println("Sending email: " + message);
    }
}

abstract class MessengerDecorator implements Messenger {
    protected Messenger messenger;

    public MessengerDecorator(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void notify(String message) {
        messenger.notify(message);
    }
}

class SMSMessengerDecorator extends MessengerDecorator {
    public SMSMessengerDecorator(Messenger messenger) {
        super(messenger);
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackMessengerDecorator extends MessengerDecorator {
    public SlackMessengerDecorator(Messenger messenger) {
        super(messenger);
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {      
        Messenger emailMessenger = new EmailMessenger();
        Messenger emailAndSMSMessenger = new SMSMessengerDecorator(emailMessenger);
        Messenger emailSMSAndSlackMessenger = new SlackMessengerDecorator(emailAndSMSMessenger);

        System.out.println("Notifying with Email, SMS, and Slack:");
        emailSMSAndSlackMessenger.notify("Hello!");

        System.out.println("\nNotifying with Email and SMS:");
        emailAndSMSMessenger.notify("Test Message!");
    }
}
