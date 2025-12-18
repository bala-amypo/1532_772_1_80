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
