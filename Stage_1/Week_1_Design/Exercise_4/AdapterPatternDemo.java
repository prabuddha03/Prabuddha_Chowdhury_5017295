public class AdapterPatternDemo {

    public interface TransactionProcessor {
        void executeTransaction(double amount);
    }

    public static class SquareGateway {
        public void initiatePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through Square.");
        }
    }

    public static class RazorpayGateway {
        public void processCharge(double amount) {
            System.out.println("Charging $" + amount + " through Razorpay.");
        }
    }

    public static class SquareAdapter implements TransactionProcessor {
        private SquareGateway squareGateway;

        public SquareAdapter(SquareGateway squareGateway) {
            this.squareGateway = squareGateway;
        }

        @Override
        public void executeTransaction(double amount) {
            squareGateway.initiatePayment(amount);
        }
    }

    public static class RazorpayAdapter implements TransactionProcessor {
        private RazorpayGateway razorpayGateway;

        public RazorpayAdapter(RazorpayGateway razorpayGateway) {
            this.razorpayGateway = razorpayGateway;
        }

        @Override
        public void executeTransaction(double amount) {
            razorpayGateway.processCharge(amount);
        }
    }

    public static void main(String[] args) {
        SquareGateway squareGateway = new SquareGateway();
        RazorpayGateway razorpayGateway = new RazorpayGateway();

        TransactionProcessor squareAdapter = new SquareAdapter(squareGateway);
        TransactionProcessor razorpayAdapter = new RazorpayAdapter(razorpayGateway);

        System.out.println("Using Square Adapter:");
        squareAdapter.executeTransaction(150.0);

        System.out.println("\nUsing Razorpay Adapter:");
        razorpayAdapter.executeTransaction(250.0);
    }
}
