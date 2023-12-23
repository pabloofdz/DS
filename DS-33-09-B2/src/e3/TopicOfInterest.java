package e3;

import java.util.Objects;

public class TopicOfInterest {
    enum Topics {Animales, Cocina, Cine, Deporte, Motor, Literatura, Bricolaje, Música, Arte, Fotografía, Videojuegos}
    private final Topics topic;

    public TopicOfInterest(Topics topic) {
        this.topic = topic;
    }

    public Topics getTopic() {
        return topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicOfInterest that = (TopicOfInterest) o;
        return topic == that.topic;
    }
}
