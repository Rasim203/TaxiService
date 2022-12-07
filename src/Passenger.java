public class Passenger extends Person implements Payable {
    private Point currentLocation;
    Passenger(String name, int age, int money) {
        super(name, age, money);
    }
    Passenger(String name, int age) {
        this(name, age, 100);
    }

    //@Override
    public void addMoney(int money) { // пассажир просто добавляет себе деньги
        setMoney(getMoney() + money);
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
        setMoney(getMoney() - priceForTrip);
    }
    @Override
    public void payTip(Driver driver, int tipMoney) {
        driver.setMoney(driver.getMoney() + tipMoney);
    }
    @Override
    public String toString() {
        return String.format("""
                Имя пассажира: %s
                Возраст: %d
                Количество денег: %d
                Текущее местоположение на карте: (%d, %d)
                """, getName(), getAge(), getMoney(), currentLocation.getX(), currentLocation.getY());
    }
}
