import java.util.List;

interface VendingMachine {

    void addBeverage(List<Product> productLst);

    Product getProduct(String name);
}