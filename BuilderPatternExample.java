class Computer {

    private String cpu;
    private int ram;
    private int storage;
    private String graphicsCard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    public void display() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Storage: " + storage + " GB");
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println();
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private String graphicsCard;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Computer computer1 = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(8)
                .setStorage(512)
                .setGraphicsCard("NVIDIA GTX 1650")
                .build();

        Computer computer2 = new Computer.Builder()
                .setCPU("AMD Ryzen 7")
                .setRAM(16)
                .setStorage(1024)
                .setGraphicsCard("AMD Radeon RX 6600")
                .build();

        System.out.println("Computer 1 Details:");
        computer1.display();

        System.out.println("Computer 2 Details:");
        computer2.display();
    }
}
