package be.onurbugdayci.messages.serices;


import be.onurbugdayci.messages.domain.Message;

import java.util.List;

public interface MessageRepository {
    public Message getMessageById(int id);
    public List<Message> getAllMessages();
    public List<Message> getMessagesByAuthor(String author);
    public Message createMessage(Message message);
    public Message updateMessage(Message message);
    public void deleteMessage(int id);
}
