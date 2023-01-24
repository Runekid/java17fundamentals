package players;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PlayerPK.class)
public class Player {

    private String club;
    private int number;
    private String name;

    public Player() {
    }

    public Player(String club, int number, String name) {
        this.club = club;
        this.number = number;
        this.name = name;
    }

    @Id
    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Id
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "club='" + club + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
