package fi.academy.opaivakirja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TopicController {
    @Autowired
    private TopicRepository repository;

    @GetMapping("/topics")
    public Iterable<Topic>findAll(){return repository.findAll();}

    @PostMapping("/topics")
    public void insert(@RequestBody Topic t) {
        repository.save(t);
    }

    @DeleteMapping("/topics/{id}")
    public void delete(@PathVariable(name="id")Integer id){
        repository.deleteById(id);
    }

    @PutMapping("/topics/{id}")
    public void update(@RequestBody Topic topic, @PathVariable(name = "id", required = true) int id) {
        Optional<Topic> top = repository.findById(id);
        Topic c = top.orElseThrow(RuntimeException::new);
        c.setTopic(topic.getTopic());
        c.setDescription(topic.getDescription());
        c.setSources(topic.getSources());
        c.setStartdate(topic.getStartdate());
        c.setFinishingdate(topic.getFinishingdate());
        c.setFinished(topic.isFinished());
        repository.save(c);
    }


}
