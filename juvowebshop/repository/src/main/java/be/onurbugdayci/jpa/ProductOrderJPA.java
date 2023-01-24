package be.onurbugdayci.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ProductOrder")
@NamedQuery(name="findAllOrdersOfToday", query = "select p from ProductOrderJPA p where p.purchaseDate = current_date and p.orderCompleted = true ")
public class ProductOrderJPA implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "productOrderId")
    private List<ProductOrderEntryJPA> productOrderEntryList = new ArrayList<>();
    @OneToOne
    private UserJPA user;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private BigDecimal totalPrice;
    private boolean orderCompleted;

}
