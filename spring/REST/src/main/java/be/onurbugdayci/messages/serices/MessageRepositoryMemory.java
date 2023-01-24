package be.onurbugdayci.messages.serices;

import be.onurbugdayci.messages.domain.Message;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryMemory implements MessageRepository {
   private Map<Integer, Message> messages = new HashMap<>();

   @PostConstruct
   public void init() {
      Message message = new Message(1, "Homer", "Hello");
      messages.put(message.getId(), message);
   }

   public synchronized Message getMessageById(int id) {
      return messages.get(id);
   }

   public synchronized List<Message> getAllMessages() {
      return new ArrayList(messages.values());
   }

   public synchronized List<Message> getMessagesByAuthor(
         String author) {
      return messages.values().stream()
            .filter(m -> m.getAuthor().equals(author))
            .collect(Collectors.toList());
   }

   public synchronized Message createMessage(Message message) {
      if (message.getId() == 0) {
         message.setId(createId());
      }
      messages.put(message.getId(), message);
      return message;
   }

   public synchronized Message updateMessage(Message message) {
      messages.put(message.getId(), message);
      return message;
   }

   public synchronized void deleteMessage(int id) {
      messages.remove(id);
   }


   private int createId() {
      OptionalInt max =
            messages.keySet().stream().mapToInt(Integer::intValue)
                  .max();
      return max.isEmpty() ? 1 : max.getAsInt() + 1;
   }


}
