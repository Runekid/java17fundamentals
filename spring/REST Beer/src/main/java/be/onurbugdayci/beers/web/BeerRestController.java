package be.onurbugdayci.beers.web;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerList;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderRequest;
import be.onurbugdayci.beers.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class BeerRestController {
    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BeerOrderRepository beerOrderRepository;

    @Autowired
    private BeerService beerService;

    @GetMapping(value = "/beers/{id:^\\d+$}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Beer> getBeer(@PathVariable("id") int id) {
        Beer beer = beerRepository.getBeerById(id);
        if (beer != null) {
            return new ResponseEntity(beer, HttpStatus.OK);
        } else {
            return new ResponseEntity(beer, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/beers", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}, params = {"alcohol"})
    public ResponseEntity<BeerList> getBeerByAlcohol(@RequestParam("alcohol") float alcohol) {
        List<Beer> beers = beerRepository.getBeerByAlcohol(alcohol);
        BeerList beerList = new BeerList(beers);
        return new ResponseEntity(beerList, HttpStatus.OK);

    }

    @GetMapping(value = "/beers", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}, params = {"name"})
    public ResponseEntity<BeerList> getBeerByName(@RequestParam("name") String name) {
        List<Beer> beers = beerRepository.getBeerByNameContainingOrderByNameAsc(name);
        BeerList beerList = new BeerList(beers);
        return new ResponseEntity(beerList, HttpStatus.OK);

    }

    @PostMapping(value = "/orders",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity addOrder(@Valid @RequestBody BeerOrderRequest beerOrder, HttpServletRequest request) throws InvalidNumberException, InvalidBeerException {

        int orderId = beerService.orderBeer(beerOrder.getName(),beerOrder.getBeerId(),beerOrder.getAmount());
        URI uri = URI.create(request.getRequestURL() + "/" + orderId);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/orders/{id:^\\d+$}",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BeerOrder> getOrderById(
            @PathVariable("id") int id) {
        System.out.println("GET id: " + id);
        BeerOrder beerOrder =
                beerOrderRepository.getBeerOrderById(id);
        if (beerOrder != null) {
            return ResponseEntity.ok(beerOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

}
