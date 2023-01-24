package be.onurbugdayci.messages.client;

import be.onurbugdayci.messages.domain.Message;
import be.onurbugdayci.messages.domain.MessageList;

import java.net.URI;

public interface MessagesClient {
   public Message getMessageById(int id);
   public MessageList getMessages();
   public MessageList getMessagesByAuthor(String author);
   public URI createMessage(Message message);
   public void updateMessage(Message message);
   public Message patchMessage(int id, String text);
   public void deleteMessage(int id);
}
