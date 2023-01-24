package exercise06_09;

import javax.persistence.Entity;

@Entity
public class AudioVisual extends MultiMedia {
    private long duration;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + "AudioVisual{" +
                "duration=" + duration +
                '}';
    }
}
