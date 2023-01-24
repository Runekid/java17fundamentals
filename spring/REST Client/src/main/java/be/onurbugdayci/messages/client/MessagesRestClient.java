package be.onurbugdayci.messages.client;

import be.onurbugdayci.messages.domain.Message;
import be.onurbugdayci.messages.domain.MessageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class MessagesRestClient implements MessagesClient{
    private String baseURL;
    private RestTemplate template;

    @Value("${baseURL}")
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @Autowired
    public void setTemplate(RestTemplate template) {
        this.template = template;
    }

    public Message getMessageById(int id) {
        ResponseEntity<Message> response = template
                .getForEntity(baseURL + "/messages/{id}",
                        Message.class, id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public MessageList getMessages() {
        ResponseEntity<MessageList> response = template.getForEntity(baseURL = "/messages", MessageList.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public MessageList getMessagesByAuthor(String author) {
        ResponseEntity<MessageList> response = template.getForEntity(baseURL = "/messages?author={0}", MessageList.class, author);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public URI createMessage(Message message) {
        return template.postForLocation(baseURL + "/messages", message);
    }

    public void updateMessage(Message message) {
        template.put(baseURL + "/messages/{0}", message, message.getId());
    }

    public Message patchMessage(int id, String text) {
        Message message = new Message();
        message.setText(text);
        return template.patchForObject(baseURL + "/messages/{0}", message, Message.class, id);
    }

    public void deleteMessage(int id) {
        template.delete(baseURL + "/messages/{0}", id);
    }
}
