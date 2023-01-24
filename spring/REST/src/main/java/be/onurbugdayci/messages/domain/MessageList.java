package be.onurbugdayci.messages.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class MessageList {
    private List<Message> messageList;

    public MessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @JsonProperty("Messages")
    @XmlElementWrapper(name="Messages")
    @XmlElement(name = "Message")
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
