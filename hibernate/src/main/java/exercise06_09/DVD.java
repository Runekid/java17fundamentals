package exercise06_09;

import javax.persistence.Entity;

@Entity
public class DVD extends AudioVisual{
    private int subtitles;

    public int getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(int subtitles) {
        this.subtitles = subtitles;
    }

    @Override
    public String toString() {
        return super.toString() + "DVD{" +
                "subtitles=" + subtitles +
                '}';
    }
}
