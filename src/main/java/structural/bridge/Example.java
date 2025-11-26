package structural.bridge;

public class Example {

    public static void main(String[] args) {
        MessageSender email = new EmailSender();
        MessageSender sms = new SmsSender();

        Message m1 = new ShortMessage(email, "hey email");
        Message m2 = new ShortMessage(sms, "hey sms");
        Message m3 = new UrgentMessage(sms, "hey sms");
        Message m4 = new UrgentMessage(email, "hey email");

        m1.send();
        m2.send();
        m3.send();
        m4.send();
    }

    interface MessageSender {
        void send(String message);
    }

    static class EmailSender implements MessageSender {
        @Override
        public void send(String message) {
            System.out.println("Email: " + message);
        }
    }

    static class SmsSender implements MessageSender {
        @Override
        public void send(String message) {
            System.out.println("SMS: " + message);
        }
    }

//    todo ----------------------------------------

     static abstract class Message {
        protected final MessageSender sender;

        public Message(MessageSender sender) {
            this.sender = sender;
        }

        public abstract void send();
    }

    static class ShortMessage extends Message {
        public final String message;

        public ShortMessage(MessageSender sender ,String message) {
            super(sender);
            this.message = message;
        }

        @Override
        public void send() {
            sender.send(message);
        }
    }

    static class UrgentMessage extends Message {
        public final String message;
        public UrgentMessage(MessageSender sender ,String message) {
            super(sender);
            this.message = message;
        }

        @Override
        public void send() {
            sender.send(message.toUpperCase());
        }
    }

}
