public class Main {
    public static void main(String[] args) {
        // equals для точек
        Point point1 = new Point(10, 20);
        Point point2 = new Point(10, 20);
        Point point3 = new Point(30, 70);
        System.out.println(point1.equals(point2)); // true
        System.out.println(point1.equals(point3)); // false

        System.out.println();

        // создание городов
        Point moscow = new Point(0, 0);
        Point kazan = new Point(70, 10);
        System.out.println(kazan);

        // Пассажир
        Passenger passenger = new Passenger("Ivan", 25, 2000);
        passenger.setCurrentLocation(moscow);
        passenger.addMoney(50); // теперь у passenger 2050 денег
        System.out.println(passenger); // вызывается переопределенный в классе Passenger метод toString()


        // Компания такси
        Company yandexTaxi = new Company("Yandex Taxi", 70, 11);
        System.out.println(yandexTaxi);

        // Водитель
        Driver driver = new Driver("Alexander", 37, 384, 12, yandexTaxi);
        System.out.println(driver);
        driver.driveTo(passenger, kazan);

        System.out.println(passenger);
        System.out.println(driver);
        System.out.println(yandexTaxi);
    }
}