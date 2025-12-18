
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EventMergeRecordServiceImpl implements EventMergeRecordService {

    @Autowired
    private EventMergeRecordRepository repo;

    @Override
    public EventMergeRecord create(EventMergeRecord e) {
        return repo.save(e);
    }

    @Override
    public List<EventMergeRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public EventMergeRecord getById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public EventMergeRecord update(long id, EventMergeRecord e) {
        EventMergeRecord exist = repo.findById(id).orElse(null);
        if (exist != null) {
            exist.setSourceEvent(e.getSourceEvent());
            exist.setMergedEvent(e.getMergedEvent());
            exist.setStatus(e.getStatus());
            return repo.save(exist);
        }
        return null;
    }

    @Override
    public String delete(long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return "Record Deleted";
        }
        return "Not Found";
    }
}
