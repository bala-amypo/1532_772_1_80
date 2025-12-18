import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



public interface EventMergeRecordService {
    EventMergeRecord create(EventMergeRecord e);
    List<EventMergeRecord> getAll();
    EventMergeRecord getById(long id);
    EventMergeRecord update(long id, EventMergeRecord e);
    String delete(long id);
}
