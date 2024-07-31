class Device {
    private String processor;
    private String memory;
    private String disk;
    private String graphicsCard;
    private String mainboard;

    private Device(Builder builder) {
        this.processor = builder.processor;
        this.memory = builder.memory;
        this.disk = builder.disk;
        this.graphicsCard = builder.graphicsCard;
        this.mainboard = builder.mainboard;
    }

    public static class Builder {
        private String processor;
        private String memory;
        private String disk;
        private String graphicsCard;
        private String mainboard;

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder setDisk(String disk) {
            this.disk = disk;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setMainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }

    @Override
    public String toString() {
        return "Device Configuration: \n" +
                "Processor: " + processor + "\n" +
                "Memory: " + memory + "\n" +
                "Disk: " + disk + "\n" +
                "Graphics Card: " + graphicsCard + "\n" +
                "Mainboard: " + mainboard + "\n";
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Device gamingPC = new Device.Builder()
                .setProcessor("Intel Core i9-13900K")
                .setMemory("64GB")
                .setDisk("2TB NVMe SSD")
                .setGraphicsCard("AMD Radeon RX 7900 XT")
                .setMainboard("ASUS ROG Crosshair X670E Hero")
                .build();

        System.out.println(gamingPC);

        Device officePC = new Device.Builder()
                .setProcessor("Intel Core i5-13400")
                .setMemory("16GB")
                .setDisk("1TB SATA SSD")
                .setMainboard("ASUS Prime B660-PLUS")
                .build();

        System.out.println(officePC);
    }
}
