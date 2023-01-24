package be.onurbugdayci.beers.client;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerList;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class BeersRestClient implements BeersClient{

    private String baseURL;
    private RestTemplate template;

    @Value("http://localhost:8080")
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @Autowired
    public void setTemplate(RestTemplate template) {
        this.template = template;
    }

    @Override
    public Beer getBeerById(int id) {
        ResponseEntity<Beer> response =template.getForEntity(baseURL + "/beers/{id}",Beer.class,id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public BeerList getBeerByAlcohol(float alcohol) {
        return template.getForEntity(baseURL + "/beers?alcohol={0}",BeerList.class,alcohol).getBody();
    }

    @Override
    public BeerList getBeerByName(String name) {
        ResponseEntity<BeerList> response = template.getForEntity(baseURL + "/beers?name={0}",BeerList.class,name);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public URI addOrder(BeerOrderRequest beerOrderRequest) {
        return template.postForLocation(baseURL + "/orders",beerOrderRequest);
    }

    @Override
    public BeerOrder getOrderById(int id) {
        ResponseEntity<BeerOrder> response =template.getForEntity(baseURL + "/orders/{id}",BeerOrder.class,id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
