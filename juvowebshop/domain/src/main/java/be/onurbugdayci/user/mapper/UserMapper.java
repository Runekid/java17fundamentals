package be.onurbugdayci.user.mapper;

import be.onurbugdayci.jpa.UserJPA;
import be.onurbugdayci.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToUser(UserJPA userJPA);
    UserJPA mapToUserJPA(User user);
}
