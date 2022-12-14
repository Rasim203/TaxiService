public class Person {
    private String name;
    private int age;
    private int money;

    Person(String name, int age, int money) {
        setName(name);
        setAge(age);
        setMoney(money);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        } else {
            System.out.println("Количество денег должно быть строго больше нуля!");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.format("""
                Имя: %s
                Возраст: %d
                Количество денег: %d
                """, getName(), getAge(), getMoney());
    }
}
