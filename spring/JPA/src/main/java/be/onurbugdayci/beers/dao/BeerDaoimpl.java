package be.onurbugdayci.beers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("beerDao")
public class BeerDaoimpl implements BeerDao {

    private final static String QUERY_ID = "SELECT Name, Alcohol, Price, Stock FROM Beers WHERE Id=?";
    private final static String QUERY_ALCOHOL = "SELECT Name, Alcohol, Price, Stock FROM Beers WHERE Alcohol=?";
    private final static String UPDATE_STOCK = "UPDATE Beers SET Stock = ? WHERE Id=?";

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public String getBeerById(int id) {
        Map<String, Object> result = template.queryForMap(QUERY_ID, id);
        return String.format("%s %s %s %s", result.get("name"), result.get("alcohol"), result.get("price"), result.get("stock"));
    }

    @Override
    public void setStock(int id, int stock) {
        template.update(UPDATE_STOCK, stock, id);
    }

    @Override
    public List<String> getBeerByAlcohol(float alcohol) {
        List<Map<String, Object>> result = template.queryForList(QUERY_ALCOHOL, alcohol);
        return result.stream().map(r -> String.format("%s %s %s %s",
                r.get("name"),
                r.get("alcohol"),
                r.get("price"),
                r.get("stock")))
                .collect(Collectors.toList());
    }
}
