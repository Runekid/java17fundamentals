package be.onurbugdayci.user.domain;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String passwordbc;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordbc='" + passwordbc + '\'' +
                '}';
    }
}
