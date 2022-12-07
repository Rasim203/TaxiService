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
    public void driveTo(Passenger passenger, Point startLocation, Point finishLocation) {
        passenger.setCurrentLocation(finishLocation); // доставили пассажира до точки B
        int priceForTrip = taxiCompany.calculatePriceOfTrip(startLocation, finishLocation);
        passenger.payMoney(this, priceForTrip);
        if (passenger.getMoney() > 1000) {
            passenger.payTip(this, (int) (passenger.getMoney() * 0.01));
        }
    }
}
