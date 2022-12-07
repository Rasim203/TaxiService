public interface Payable {
    public void payMoney(Driver driver, int priceForTrip);
    public void payTip(Driver driver, int tipMoney); // оставить чаевые
}
