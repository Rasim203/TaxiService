public class Passenger extends Person implements Payable {
    private int money;
    private Point currentLocation;
    Passenger(String name, int age, int money) {
        super(name, age, money);
    }
    Passenger(String name, int age) {
        this(name, age, 100);
    }

    //@Override
    public void addMoney(int money) { // пассажир просто добавляет себе деньги
        this.money += money;
    }
    public int getMoney() {
        return money;
    }

    public void setCurrentLocation(Point otherLocation) {
        this.currentLocation = otherLocation;
    }
    public Point getCurrentLocation() {
        return currentLocation;
    }
    @Override
    public void payMoney(Driver driver, int priceForTrip) {
        driver.addMoney(priceForTrip);
        money -= priceForTrip;
    }
    @Override
    public void payTip(Driver driver, int tipMoney) {
        driver.setMoney(driver.getMoney() + tipMoney);
    }
    @Override
    public String toString() {
        return String.format("Имя: %s\nВозраст: %d\nКоличество денег: %d", getName(), getAge(), money);
    }
}
