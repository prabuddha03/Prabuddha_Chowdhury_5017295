public class MVCPatternDemo {

    public static class Employee {
        private String employeeId;
        private String employeeName;
        private String employeeRating;

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeRating() {
            return employeeRating;
        }

        public void setEmployeeRating(String employeeRating) {
            this.employeeRating = employeeRating;
        }
    }

    public static class EmployeeView {
        public void displayEmployeeDetails(String employeeName, String employeeId, String employeeRating) {
            System.out.println("Employee Details:");
            System.out.println("Name: " + employeeName);
            System.out.println("ID: " + employeeId);
            System.out.println("Rating: " + employeeRating);
        }
    }

    public static class EmployeeController {
        private Employee model;
        private EmployeeView view;

        public EmployeeController(Employee model, EmployeeView view) {
            this.model = model;
            this.view = view;
        }

        public void setEmployeeName(String name) {
            model.setEmployeeName(name);
        }

        public String getEmployeeName() {
            return model.getEmployeeName();
        }

        public void setEmployeeId(String id) {
            model.setEmployeeId(id);
        }

        public String getEmployeeId() {
            return model.getEmployeeId();
        }

        public void setEmployeeRating(String rating) {
            model.setEmployeeRating(rating);
        }

        public String getEmployeeRating() {
            return model.getEmployeeRating();
        }

        public void updateView() {
            view.displayEmployeeDetails(model.getEmployeeName(), model.getEmployeeId(), model.getEmployeeRating());
        }
    }

    public static void main(String[] args) {
        Employee model = new Employee();
        model.setEmployeeName("Ravi Kumar");
        model.setEmployeeId("EMP102");
        model.setEmployeeRating("Excellent");

        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);

        controller.updateView();

        controller.setEmployeeName("Ravi Kumar");
        controller.setEmployeeRating("Outstanding");

        controller.updateView();
    }
}
