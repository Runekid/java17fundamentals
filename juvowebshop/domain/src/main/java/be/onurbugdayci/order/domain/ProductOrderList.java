package be.onurbugdayci.order.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;


public record ProductOrderList(
        @JsonProperty @JacksonXmlElementWrapper(localName = "Orders") @JacksonXmlProperty(localName = "Order") List<ProductOrder> orderList) implements Serializable {

}
