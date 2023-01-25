import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class ShoppingList {
    List<Product> shoppingList = new ArrayList<>();
    public void terminateProgram(){
        System.out.println("Děkuji za využití nákupního seznamu");
        exit(0);
    }

    public void shopApp(){
        System.out.println("Pro přidání produktu do seznamu stiskněte 1\n" +
                "Pro odstranění produktu ze seznamu stiskněte 2\n" +
                "Pro výpis produktů na seznamu stiskněte 3\n" +
                "Pro ukončení programu stisknete 4");
        Scanner scanner = new Scanner(System.in);
        int determinator = scanner.nextInt();
        while(determinator!=4){
           if (determinator==1){
               addProduct();
               System.out.println("Pro přidání produktu do seznamu stiskněte 1\n" +
                       "Pro odstranění produktu ze seznamu stiskněte 2\n" +
                       "Pro výpis produktů na seznamu stiskněte 3\n" +
                       "Pro ukončení programu stisknete 4");
               determinator = scanner.nextInt();
           } else if (determinator==2) {
               removeProduct();
               System.out.println("Pro přidání produktu do seznamu stiskněte 1\n" +
                       "Pro odstranění produktu ze seznamu stiskněte 2\n" +
                       "Pro výpis produktů na seznamu stiskněte 3\n" +
                       "Pro ukončení programu stisknete 4");
               determinator = scanner.nextInt();
           } else if (determinator==3) {
               printList();
               System.out.println("Pro přidání produktu do seznamu stiskněte 1\n" +
                       "Pro odstranění produktu ze seznamu stiskněte 2\n" +
                       "Pro výpis produktů na seznamu stiskněte 3\n" +
                       "Pro ukončení programu stisknete 4");
               determinator = scanner.nextInt();
           }
           if (determinator==4){
               terminateProgram();
           }
        }
        }



    //metoda pro vlozeni produktu na seznam
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte název produktu");
        String name = scanner.next();
        System.out.println("Zadejte cenu");
        BigDecimal price = scanner.nextBigDecimal();
        LocalDate purchaseDate = LocalDate.now();
        shoppingList.add(new Product(name, price, purchaseDate));
        shoppingList.forEach(System.out::println);
    }
    //metoda pro odstraneni produktu ze seznamu
    public void removeProduct() {
        System.out.println("Pokud chcete smazat konkretní produkt stistkněte 1 " +
                "a enter pokud chcete smazat produkt na určité pozici stiskněte 2 a enter");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Zadej název produktu");
                int i = 1;
                for (Product product : shoppingList) {
                    System.out.println("pro smazání produktu: " + product.getName() + " stistněte " + i);
                    i++;
                }
                int removeIndex = scanner.nextInt();
                System.out.println("product " + shoppingList.get(removeIndex - 1) + "byl smazán");
                shoppingList.remove(removeIndex - 1);
                break;
            case 2:
                System.out.println("Zadej index produktu");
                int productIndex = scanner.nextInt() - 1;
                String productIndexName = shoppingList.get(productIndex).toString();
                shoppingList.remove(productIndex);
                System.out.println("product " + productIndexName + " byl odebrán");
                shoppingList.forEach(System.out::println);
                break;
        }

    }
//vypis vsech produktu na seznamu
    public void printList() {
        shoppingList.forEach(System.out::println);
    }

}
