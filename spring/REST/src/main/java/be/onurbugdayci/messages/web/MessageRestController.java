package be.onurbugdayci.messages.web;

import be.onurbugdayci.messages.domain.Message;
import be.onurbugdayci.messages.domain.MessageList;
import be.onurbugdayci.messages.serices.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageRestController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Message> getMessage(@PathVariable("id") int id) {
        Message message = messageRepository.getMessageById(id);
        if (message != null) {
            return new ResponseEntity(message, HttpStatus.OK);
        } else {
            return new ResponseEntity(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "{id:^\\d+$}/author", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Message> getMessageText(@PathVariable("id") int id) {
        Message message = messageRepository.getMessageById(id);
        if (message != null) {
            return new ResponseEntity(message.getAuthor(), HttpStatus.OK);
        } else {
            return new ResponseEntity(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MessageList> getMessages() {
        List<Message> messages = messageRepository.getAllMessages();
        MessageList messageList = new MessageList(messages);
        return new ResponseEntity(messageList, HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}, params = {"author"})
    public ResponseEntity<MessageList> getMessagesForAuthor(@RequestParam(value = "author", required = false, defaultValue = "unknown") String author) {
        List<Message> messages = messageRepository.getMessagesByAuthor(author);
        MessageList messageList = new MessageList(messages);
        return new ResponseEntity(messageList, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity addMessage(@Valid @RequestBody Message message, HttpServletRequest request) {
        if (message.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        message = messageRepository.createMessage(message);
        URI uri = URI.create(request.getRequestURL() + "/" + message.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "{id:^\\d+$}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity updateMessage(@PathVariable("id") int id, @Valid @RequestBody Message message) {
        if (message.getId() != id) {
            return ResponseEntity.badRequest().build();
        }

        message = messageRepository.updateMessage(message);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "{id:^\\d+$}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Message> patchMessage(@PathVariable("id") int id, @RequestBody Message patchMessage) {
        Message message = messageRepository.getMessageById(id);
        if (message == null) {
            return ResponseEntity.notFound().build();
        }

        if (patchMessage.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        if (patchMessage.getAuthor() != null) {
            message.setAuthor(patchMessage.getAuthor());
        }
        if (patchMessage.getText() != null) {
            message.setText(patchMessage.getText());
        }

        message = messageRepository.updateMessage(message);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("{id:^\\d+$}")
    public ResponseEntity deleteMessage(@PathVariable("id") int id) {
        messageRepository.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
