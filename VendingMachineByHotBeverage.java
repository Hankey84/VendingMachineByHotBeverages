/* Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод 
getProduct(int name, int volume/int temperature), выдающий продукт соответствующий имени, объёму / температуре
В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику, заложенную 
в программе
Всё вышеуказанное создать согласно принципам ООП, пройденным на семинаре */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class VendingMachineByHotBeverage implements VendingMachine {

    private static List<HotBeverage> beverages;

    public VendingMachineByHotBeverage() {
        beverages = new ArrayList<>();
    }

    @Override
    public void addBeverage(List<Product> productLst) {

    }

    public void addBeverage(HotBeverage beverage) {
        beverages.add(beverage);
    }

    @Override
    public Product getProduct(String name) {
        return getProduct(name, 100); // По умолчанию, объем 100 мл
    }

    public Product getProduct(String name, int volume) {
        for (HotBeverage beverage : beverages) {
            if (beverage.getName().equals(name) && beverage.getVolume() == volume) {
                return beverage;
            }
        }
        return null; // Или выбросить исключение, если продукт не найден
    }

    public static void main(String[] args) {
        VendingMachineByHotBeverage machine = new VendingMachineByHotBeverage();

        // Наполнение ассортимента нашего автомата
        Tea greenTea = new Tea("Green Tea", 55.0, 400, 90.0, "Green");
        Coffee espresso = new Coffee("Espresso", 70.0, 100, 85.5, "Dark Roast");
        Coffee americano = new Coffee("Americano", 110.0, 150, 75.0, "Medium Roast");
        Coffee americanoDouble = new Coffee("Americano", 170.0, 300, 75.0, "Medium Roast");
        Tea blackTea = new Tea("Black Tea", 60.0, 400, 90.0, "Black");
        Tea jasmineTea = new Tea("Jasmine Green Tea", 75.0, 400, 90.0, "Jasmine Green");
        Coffee cappucino = new Coffee("Cappucino", 150.0, 300, 72.0, "Light Roast");
        Coffee cappucinoXL = new Coffee("Cappucino", 190.0, 400, 72.0, "Light Roast");
        Coffee cappucinoXXL = new Coffee("Cappucino", 230.0, 500, 72.0, "Light Roast");
        Coffee latte = new Coffee("Latte", 170.0, 300, 72.0, "Light Roast");
        Coffee latteXl = new Coffee("Latte", 210.0, 400, 72.0, "Light Roast");
        Coffee latteXXL = new Coffee("Latte", 250.0, 500, 72.0, "Light Roast");

        machine.addBeverage(greenTea);
        machine.addBeverage(espresso);
        machine.addBeverage(americano);
        machine.addBeverage(americanoDouble);
        machine.addBeverage(blackTea);
        machine.addBeverage(jasmineTea);
        machine.addBeverage(cappucino);
        machine.addBeverage(cappucinoXL);
        machine.addBeverage(cappucinoXXL);
        machine.addBeverage(latte);
        machine.addBeverage(latteXl);
        machine.addBeverage(latteXXL);

        //Реализация логики автомата
        HashSet<HotBeverage> set = new HashSet<>(beverages);
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("Выберите напиток из списка:");
            for (HotBeverage beverage : set) {
                System.out.println(beverage.getName());
            }
            System.out.print("Введите название напитка: ");
            String productName = scanner.nextLine();

            System.out.print("Теперь выберите объём вашего напитка: ");
            try {
                int requiredVolume = scanner.nextInt();
                scanner.nextLine(); // Прочитать оставшийся символ новой строки после nextInt()
                Product product = machine.getProduct(productName, requiredVolume);
                if (product != null) {
                    if (product instanceof HotBeverage) {
                        System.out.println("Вы выбрали: " + product); 
                    }
                } else {
                    System.out.println("Такого напитка в автомате сейчас нет...");
                }              
            } catch (NumberFormatException e) {                
                System.err.println("Ошибка: введенное значение не является целым числом.");
            }

            System.out.print("Продолжить покупки? (y/n): ");
            String choice = scanner.nextLine();
            continueShopping = choice.equalsIgnoreCase("y");
        }

        scanner.close();        
    }

}
