public class Tea extends HotBeverage{
    private String type;

    public Tea(String name, double price, int volume, double temperature, String type) {
        super(name, price, volume, temperature);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Чай: {" +
                "Наименование='" + name + '\'' + ", Цена=" + price +
                " руб., Объём=" + volume + " " + " мл., температура=" + temperature + "°С  тип чая='" +
                type + "\'}";
    }
}
