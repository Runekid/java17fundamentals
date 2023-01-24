package be.onurbugdayci.order.domain;

import be.onurbugdayci.product.domain.Product;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class ProductOrderEntry implements Serializable {

    private Long id;
    private Product product;
    private Long productOrderId;
    private int amount;
    private BigDecimal calculatedPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrderEntry that = (ProductOrderEntry) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
