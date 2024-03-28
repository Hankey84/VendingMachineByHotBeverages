public class Coffee extends HotBeverage{
    private String roastType;

    public Coffee(String name, double price, int volume, double temperature, String roastType) {
        super(name, price, volume, temperature);
        this.roastType = roastType;
    }

    public String getRoastType() {
        return roastType;
    }

    @Override
    public String toString() {
        return "Кофе: {" +
                "Наименование='" + name + '\'' + ", Цена=" + price +
                " руб., Объём=" + volume + " " + ", температура=" + temperature + " тип прожарки=" +
                roastType + "}";
    }
}
