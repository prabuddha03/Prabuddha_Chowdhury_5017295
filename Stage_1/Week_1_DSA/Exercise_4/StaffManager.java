public class StaffManager {

    public static class Staff {
        private int id;
        private String fullName;
        private String role;
        private double wage;

        public Staff(int id, String fullName, String role, double wage) {
            this.id = id;
            this.fullName = fullName;
            this.role = role;
            this.wage = wage;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public double getWage() {
            return wage;
        }

        public void setWage(double wage) {
            this.wage = wage;
        }

        @Override
        public String toString() {
            return "Staff ID: " + id + ", Name: " + fullName + ", Role: " + role + ", Wage: " + wage;
        }
    }

    private Staff[] staffArray;
    private int count;

    public StaffManager(int capacity) {
        staffArray = new Staff[capacity];
        count = 0;
    }

    public void addStaff(Staff staff) {
        if (count < staffArray.length) {
            staffArray[count++] = staff;
        } else {
            System.out.println("Staff array is full.");
        }
    }

    public Staff findStaff(int id) {
        for (int i = 0; i < count; i++) {
            if (staffArray[i].getId() == id) {
                return staffArray[i];
            }
        }
        return null;
    }

    public void displayAllStaff() {
        for (int i = 0; i < count; i++) {
            System.out.println(staffArray[i]);
        }
    }

    public void removeStaff(int id) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (staffArray[i].getId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                staffArray[i] = staffArray[i + 1];
            }
            staffArray[--count] = null;
        } else {
            System.out.println("Staff not found.");
        }
    }

    public static void main(String[] args) {
        StaffManager manager = new StaffManager(5);

        manager.addStaff(new Staff(101, "Alice Johnson", "Engineer", 70000));
        manager.addStaff(new Staff(102, "Bob Brown", "Consultant", 80000));
        manager.addStaff(new Staff(103, "Carol White", "Analyst", 75000));

        System.out.println("All Staff Members:");
        manager.displayAllStaff();

        System.out.println("\nSearching for staff with ID 102:");
        Staff staff = manager.findStaff(102);
        System.out.println(staff != null ? staff : "Staff not found");

        System.out.println("\nRemoving staff with ID 102");
        manager.removeStaff(102);

        System.out.println("\nAll Staff Members after removal:");
        manager.displayAllStaff();
    }
}
