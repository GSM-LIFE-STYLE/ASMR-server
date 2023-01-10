package lifestyle.awardscore.domain.product.repository;

import lifestyle.awardscore.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
