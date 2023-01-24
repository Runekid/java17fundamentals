package be.onurbugdayci.beers.domain;

public class BeerOrderRequest {
    private String name;
    private int beerId;
    private int amount;

    public BeerOrderRequest() {
    }

    public BeerOrderRequest(String name, int beerId, int amount) {
        this.name = name;
        this.beerId = beerId;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
