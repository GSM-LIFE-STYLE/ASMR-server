package lifestyle.awardscore.domain.product.entity;

import lifestyle.awardscore.domain.shop.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Long price;

    @Column(name = "description")
    private String description;

    public void updateProduct(String productName , Long price , String description) {
        this.productName = productName != null ? productName : this.productName;
        this.description = description != null ? description : this.description;
        this.price = price != null ? price : this.price;
    }
}
