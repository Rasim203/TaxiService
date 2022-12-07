public class Driver extends Person implements Movable {
    private int drivingExperience;
    private Company taxiCompany;

    Driver(String name, int age, int money, int drivingExperience, Company taxiCompany) {
        super(name, age, money);
        setDrivingExperience(drivingExperience);
        setTaxiCompany(taxiCompany);

    }

    public void setDrivingExperience(int drivingExperience) {
        if (super.getAge() - 18 >= drivingExperience) {
            this.drivingExperience = drivingExperience;
        } else {
            System.out.println("Вы нас обманываете. У вас не такой стаж вождения!");
        }
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setTaxiCompany(Company taxiCompany) {
        this.taxiCompany = taxiCompany;
        taxiCompany.addDriver(this);
    }

    public Company getTaxiCompany() {
        return taxiCompany;
    }

    public void addMoney(int priceForTrip) {
        int moneyForDriver = (int) ((double) taxiCompany.getPercentRate() / 100 * priceForTrip);
        int moneyForTaxiCompany = priceForTrip - moneyForDriver;
        setMoney(getMoney() + moneyForDriver);
        taxiCompany.increaseCompanyBudget(moneyForTaxiCompany);
    }

    @Override
    public void driveTo(Passenger passenger, Point finishLocation) {
        int priceForTrip = taxiCompany.calculatePriceOfTrip(passenger.getCurrentLocation(), finishLocation);
        if (passenger.getMoney() >= priceForTrip) {
            passenger.setCurrentLocation(finishLocation); // доставили пассажира до точки B
            passenger.payMoney(this, priceForTrip);
            System.out.println("Пассажир " + passenger.getName() + " доставлен в место назначения");
            if (passenger.getMoney() > 1000) { // если у пассажира осталось много денег, то он еще платит чаевые
                passenger.payTip(this, (int) (passenger.getMoney() * 0.01));
                System.out.println("Заплатил чаевые водителю");
            }
        } else {
            System.out.println("У пассажира " + passenger.getName() + " недостаточно денег для поездки");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("""
                Имя водителя: %s
                Возраст: %d
                Количество денег: %d
                Водительский стаж: %d
                Компания такси: %s
                """, getName(), getAge(), getMoney(), getDrivingExperience(), getTaxiCompany().getCompanyName());
    }
}
