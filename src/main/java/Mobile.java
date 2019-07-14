public class Mobile {
    private String name;
    private String color;
    private String brand;

    public Mobile(String name, String color, String brand) {
        this.name = name;
        this.color = color;
        this.brand = brand;
    }

    String getName() {
        return this.name;
    }

    String getColor() {
        return this.color;
    }

    String getBrand() {
        return this.brand;
    }

    public void call(String message) {
        System.out.println("Message : " + message);
    }

    String getBasicInfo() {
        return "name: " + this.name + ", color: " + this.color + ", brand: " + this.brand;
    }
}
