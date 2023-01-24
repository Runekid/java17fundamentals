package players;

import java.io.Serializable;
import java.util.Objects;

public class PlayerPK implements Serializable {
    private String club;
    private int number;

    public PlayerPK() {
    }

    public PlayerPK(String club, int number) {
        this.club = club;
        this.number = number;
    }

    public String getClub() {

        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPK playerPK = (PlayerPK) o;
        return number == playerPK.number && Objects.equals(club, playerPK.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(club, number);
    }
}
