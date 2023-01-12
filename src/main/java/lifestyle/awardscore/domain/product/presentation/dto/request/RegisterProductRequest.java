package lifestyle.awardscore.domain.product.presentation.dto.request;

import lifestyle.awardscore.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterProductRequest {
    @NotEmpty
    private String productName;
    @NotEmpty
    private Long price;
    @NotEmpty
    private String description;

    public Product toEntity() {
        return Product.builder()
                .productName(productName)
                .price(price)
                .description(description)
                .build();
    }
}
