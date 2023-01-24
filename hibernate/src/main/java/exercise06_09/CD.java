package exercise06_09;

import javax.persistence.Entity;

@Entity
public class CD extends AudioVisual{
    private int tracks;

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return super.toString() + "CD{" +
                "tracks=" + tracks +
                '}';
    }
}
