package Controller;

import Entity.Message;
import Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        try {
            Message savedMessage = messageRepository.save(message);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessagesByRequest(
            @RequestParam Long requestId
    ) {
        return ResponseEntity.ok(messageRepository.findByRequestId(requestId));
    }
}