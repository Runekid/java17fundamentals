package be.onurbugdayci.user.services;

import be.onurbugdayci.jpa.ProductOrderEntryJPA;
import be.onurbugdayci.order.domain.ProductOrderEntry;
import be.onurbugdayci.order.mapper.ProductOrderEntryMapper;
import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.repositories.ProductOrderEntryRepository;
import be.onurbugdayci.repositories.UserRepository;
import be.onurbugdayci.user.domain.User;
import be.onurbugdayci.user.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findById(long id);
    User findLoggedInUser();
    User createUser(String username, String password);
    User findByUsername(String username);
    Long getLoggedInUserId();
}
