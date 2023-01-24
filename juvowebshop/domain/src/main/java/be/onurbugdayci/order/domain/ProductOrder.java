package be.onurbugdayci.order.domain;

import be.onurbugdayci.user.domain.User;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class ProductOrder{

    private Long id;
    @JacksonXmlElementWrapper(localName = "OrderEntries")
    @JacksonXmlProperty(localName = "OrderEntry")
    private List<ProductOrderEntry> productOrderEntryList;
    private User user;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private BigDecimal totalPrice;
    private boolean orderCompleted;

}
