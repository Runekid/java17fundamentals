package be.onurbugdayci.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User")
public class UserJPA {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String passwordbc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJPA userJPA = (UserJPA) o;
        return id.equals(userJPA.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserJPA{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordbc='" + passwordbc + '\'' +
                '}';
    }
}
