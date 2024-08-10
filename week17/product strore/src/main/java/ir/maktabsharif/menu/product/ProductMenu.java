package ir.maktabsharif.menu.product;

import ir.maktabsharif.entity.User;
import ir.maktabsharif.enums.ProductType;
import ir.maktabsharif.menu.util.Message;
import ir.maktabsharif.service.product.ProductService;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.InputMismatchException;
import java.util.Scanner;

@RequiredArgsConstructor
@Accessors(chain = true)
public class ProductMenu {
    private @Getter
    @Setter User token = null;
    @NonNull Scanner scanner;
    private final ProductService productService;
    private final Message message;


    public void show() {
        while (true) {

            System.out.println(
                    "select between" + "\n" +
                            "Add Product = 1" + "\n" +
                            "Buy = 2" + "\n" +
                            "Search card by name = 3" + "\n" +
                            "Search card on bank = 4" + "\n" +
                            "Show all cards = 5" + "\n" +
                            "go previous menu = 6"
            );

            int inputtedValue = scanner.nextInt();
            switch (inputtedValue) {
                case 1 -> {
                    addProduct();
                }
                case 6 -> {
                    return;
                }

                default -> System.out.println("wrong input value");
            }
            System.out.println();
        }
    }

    private void addProduct() {
        System.out.println(message.getInputMessage("product name"));
        String name = scanner.next();
        ProductType productType = getType();
        Double price = getaDouble();

        boolean register = productService.addProduct(name, productType, price);
        if (register) {
            System.out.println(message.getSuccessfulMessage("registered"));
        } else {
            System.out.println(message.getFailedMessage("registering "));
        }
    }

    private ProductType getType() {
        ProductType productType = null;
        while (productType == null) {
            try {
                System.out.println(message.getInputMessage("product type :"));
                String type = scanner.next().toUpperCase();
                productType = ProductType.valueOf(type);
            } catch (IllegalArgumentException e) {
                System.out.println(STR."\{message.getInvalidInputMessage()} \{message.getEnterAgainMessage()}");
            }
        }
        return productType;
    }

    private Double getaDouble() {
        Double price = null;
        while (price == null) {
            try {
                System.out.println(message.getInputMessage("price "));
                price = new Scanner(System.in).nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(STR."\{message.getInvalidInputMessage()} \{message.getEnterAgainMessage()}");
            }
        }
        return price;
    }
}
