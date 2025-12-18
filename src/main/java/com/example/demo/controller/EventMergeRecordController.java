import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class EventMergeRecordController {

    @Autowired
    private EventMergeRecordService service;

    @PostMapping("/addmerge")
    public EventMergeRecord add(@RequestBody EventMergeRecord e) {
        return service.create(e);
    }

    @GetMapping("/showmerge")
    public List<EventMergeRecord> get() {
        return service.getAll();
    }

    @GetMapping("/getmerge/{id}")
    public EventMergeRecord getOne(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("/updatemerge/{id}")
    public EventMergeRecord update(@PathVariable long id, @RequestBody EventMergeRecord e) {
        return service.update(id, e);
    }

    @DeleteMapping("/deletemerge/{id}")
    public String delete(@PathVariable long id) {
        return service.delete(id);
    }
}
