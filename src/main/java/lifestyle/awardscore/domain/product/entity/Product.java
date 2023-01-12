package lifestyle.awardscore.domain.product.entity;

import lifestyle.awardscore.domain.order.entity.Order;
import lifestyle.awardscore.domain.order.entity.OrderHistory;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "order_history_id")
    private OrderHistory orderHistory;

    public void updateProduct(String productName , Long price , String description) {
        this.productName = productName != null ? productName : this.productName;
        this.description = description != null ? description : this.description;
        this.price = price != null ? price : this.price;
    }
}
