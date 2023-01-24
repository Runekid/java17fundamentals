package be.onurbugdayci.beers.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class BeerList {
    private List<Beer> beerList;

    public BeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    @XmlElementWrapper(name = "Beers")
    @XmlElement(name = "Beer")
    @JsonProperty("Beer")
    public List<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }
}
