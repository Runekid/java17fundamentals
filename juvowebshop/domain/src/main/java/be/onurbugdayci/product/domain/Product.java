package be.onurbugdayci.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Currency;

@Setter
@Getter
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor*/
public class Product implements Serializable {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @XmlTransient
    @JsonIgnore
    private byte[] image;


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image=" + image +
                '}';
    }


}
