public class Company {
    private String companyName;
    private int companyBudget = 0;
    private int percentRate; // число от 1 до 99 - столько процентов от стоимости поездки будет начисляться водителю
    private int pricePerKilometer;
    private final int CAPACITY = 100;
    private int numberOfDrivers = 0;
    Driver[] drivers = new Driver[CAPACITY];

    Company(String companyName, int percentRate, int pricePerKilometer) {
        setCompanyName(companyName);
        setPercentRate(percentRate);
        setPricePerKilometer(pricePerKilometer);
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setPercentRate(int percentRate) {
        if (percentRate >= 1 && percentRate <= 99) {
            this.percentRate = percentRate;
        } else {
            System.out.println("Процентная ставка водителя принимает целые значения от 1 до 99!");
        }
    }

    public int getPercentRate() {
        return percentRate;
    }

    public void setPricePerKilometer(int pricePerKilometer) {
        if (pricePerKilometer > 0) {
            this.pricePerKilometer = pricePerKilometer;
        } else {
            System.out.println("Цена за каждый километр строго положительное число!");
        }
    }

    public int getPricePerKilometer() {
        return pricePerKilometer;
    }

    public int getCompanyBudget() {
        return companyBudget;
    }

    public void addDriver(Driver driver) {
        drivers[numberOfDrivers++] = driver;
    }

    public void increaseCompanyBudget(int money) {
        this.companyBudget += money;
    }

    public int calculatePriceOfTrip(Point startLocation, Point finishLocation) {
        return (int) (startLocation.distance(finishLocation) * pricePerKilometer);
    }

    @Override
    public String toString() {
        return String.format("""
                        Компания "%s"
                        Бюджет компании: %d
                        Процентная ставка за поездку водителю: %d%%
                        Стоимость каждого километра: %d
                        Число водителей, работающих в компании: %d
                        """, getCompanyName(), getCompanyBudget(), getPercentRate(),
                getPricePerKilometer(), numberOfDrivers);
    }
}
