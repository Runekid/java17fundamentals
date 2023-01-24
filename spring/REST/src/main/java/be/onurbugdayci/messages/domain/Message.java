package be.onurbugdayci.messages.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.*;

@XmlRootElement
@JsonPropertyOrder({"MessageId", "MessageAuthor", "MessageText"})
public class Message {
    private int id;
    @NotBlank
    private String author;
    @NotBlank
    private String text;

    public Message() {
    }

    public Message(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    @XmlAttribute(name = "messageId")
    @JsonProperty("MessageId")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlAttribute(name = "messageAuthor")
    @JsonProperty("MessageAuthor")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlAttribute(name = "messageText")
    @JsonProperty("MessageText")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @JsonIgnore
    @XmlTransient
    public void getDisplayText() {
        System.out.println(this.getText());
    }
}
