package be.onurbugdayci.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "ProductOrderEntry")
public class ProductOrderEntryJPA implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private ProductJPA product;
    @Column(name = "productOrderId")
    private Long productOrderId;
    private int amount;
    private BigDecimal calculatedPrice;
}
