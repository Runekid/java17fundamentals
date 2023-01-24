package be.onurbugdayci.beers.dao;

import java.util.List;

public interface BeerDao {
    public String getBeerById(int id);
    public void setStock(int id, int stock);
    public List<String> getBeerByAlcohol(float alcohol);
}
