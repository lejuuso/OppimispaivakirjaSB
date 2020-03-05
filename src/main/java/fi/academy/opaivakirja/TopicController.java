package fi.academy.opaivakirja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/api")
public class TopicController {
    @Autowired
    private TopicRepository repository;

    @GetMapping("/topics")
    public Iterable<Topic>findAll(){return repository.findAll();}

    @PostMapping("/topics")
    public void update(@RequestBody Topic t) {
        repository.save(t);
    }

    @DeleteMapping("/topics/{id}")
    public void delete(@PathVariable(name="id")Integer id){
        repository.deleteById(id);
    }

}
