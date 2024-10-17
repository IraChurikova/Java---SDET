
public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры автомобилей
        Car car = new Car("Toyota", "Camry", 2023, 1000);
        SportCar sportCar = new SportCar("Porsche", "911", 2024, 2000, "Turbo", 200);
        Truck truck = new Truck("Ford", "F-150", 2022, 5000, 10000);

        // Выводим информацию о каждом автомобиле
        System.out.println("Car:");
        System.out.println(car);
        System.out.println("SportCar:");
        System.out.println(sportCar);
        System.out.println("Truck:");
        System.out.println(truck);

        // Тестируем методы интерфейсов
        System.out.println("\nTesting interface methods:");
        car.startEngine();
        sportCar.startEngine();
        truck.startEngine();

        System.out.println("\nTesting static methods:");
        System.out.println("Total number of vehicles: " + Vehicle.getTotalVehicles());
    }
}

// Абстрактный класс Vehicle
abstract class Vehicle {
    // Статическое поле для подсчета общего количества транспортных средств
    private static int totalVehicles = 0;

    // Поля
    protected String brand;
    protected String model;
    protected int year;
    protected double price;

    // Параметризованный конструктор
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        totalVehicles++;
    }

    // Абстрактный метод для запуска двигателя
    public abstract void startEngine();

    // Метод для получения общего количества транспортных средств
    public static int getTotalVehicles() {
        return totalVehicles;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Price: " + price;
    }
}

// Интерфейс для транспортных средств с двигателем
interface Engine {
    void startEngine();
    void stopEngine();
}

// Интерфейс для транспортных средств с грузоподъемностью
interface LoadCapacity {
    double getLoadCapacity();
    void setLoadCapacity(double loadCapacity);
}

// Класс Car
class Car extends Vehicle implements Engine {
    // Поля
    private String color;
    private int seats;

    // Параметризованный конструктор
    public Car(String brand, String model, int year, double price) {
        super(brand, model, year, price);
        this.color = "Black"; // Default color
        this.seats = 5; // Default number of seats
    }

    // Реализация метода startEngine() из интерфейса Engine
    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + ": Engine started!");
    }

    // Реализация метода stopEngine() из интерфейса Engine
    @Override
    public void stopEngine() {
        System.out.println(brand + " " + model + ": Engine stopped!");
    }

    // Метод для изменения цвета автомобиля
    public void setColor(String color) {
        this.color = color;
    }

    // Метод для получения цвета автомобиля
    public String getColor() {
        return color;
    }

    // Метод для установки количества мест
    public void setSeats(int seats) {
        this.seats = seats;
    }

    // Метод для получения количества мест
    public int getSeats() {
        return seats;
    }
}

// Класс SportCar
class SportCar extends Car implements Engine {
    // Поля
    private String engineType;
    private int topSpeed;

    // Параметризованный конструктор
    public SportCar(String brand, String model, int year, double price, String engineType, int topSpeed) {
        super(brand, model, year, price);
        this.engineType = engineType;
        this.topSpeed = topSpeed;
    }

    // Реализация метода startEngine() из интерфейса Engine
    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + " (" + engineType + "): Engine roaring!");
    }

    // Реализация метода stopEngine() из интерфейса Engine
    @Override
    public void stopEngine() {
        System.out.println(brand + " " + model + " (" + engineType + "): Engine stopped!");
    }

    // Метод для получения типа двигателя
    public String getEngineType() {
        return engineType;
    }

    // Метод для получения максимальной скорости
    public int getTopSpeed() {
        return topSpeed;
    }
}

// Класс Truck
class Truck extends Vehicle implements LoadCapacity {
    // Поля
    private double loadCapacity;
    private int axles;

    // Параметризованный конструктор
    public Truck(String brand, String model, int year, double price, double loadCapacity) {
        super(brand, model, year, price);
        this.loadCapacity = loadCapacity;
        this.axles = 2; // Default number of axles
    }

    // Реализация метода startEngine() из интерфейса Engine
    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + ": Engine rumbling!");
    }

    // Реализация метода getLoadCapacity() из интерфейса LoadCapacity
    @Override
    public double getLoadCapacity() {
        return loadCapacity;
    }

    // Реализация метода setLoadCapacity() из интерфейса LoadCapacity
    @Override
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    // Метод для установки количества осей
    public void setAxles(int axles) {
        this.axles = axles;
    }

    // Метод для получения количества осей
    public int getAxles() {
        return axles;
    }
}