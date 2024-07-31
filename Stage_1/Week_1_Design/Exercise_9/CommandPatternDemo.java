public class CommandPatternDemo {

    public interface Task {
        void execute();
    }

    public static class Fan {
        public void start() {
            System.out.println("Fan is On");
        }

        public void stop() {
            System.out.println("Fan is Off");
        }
    }

    public static class FanStartTask implements Task {
        private Fan fan;

        public FanStartTask(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.start();
        }
    }

    public static class FanStopTask implements Task {
        private Fan fan;

        public FanStopTask(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.stop();
        }
    }

    public static class Switch {
        private Task task;

        public void setTask(Task task) {
            this.task = task;
        }

        public void press() {
            task.execute();
        }
    }

    public static void main(String[] args) {
        Fan fan = new Fan();
        Task fanStart = new FanStartTask(fan);
        Task fanStop = new FanStopTask(fan);

        Switch fanSwitch = new Switch();
        
        fanSwitch.setTask(fanStart);
        fanSwitch.press();
        
        fanSwitch.setTask(fanStop);
        fanSwitch.press();
    }
}
