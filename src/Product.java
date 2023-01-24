import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private String name;
    private BigDecimal price;
    private LocalDate purchaseDate;

    public Product(String name, BigDecimal price, LocalDate purchaseDate) {
        this.name = name;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
