@Entity
public class EventMergeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sourceEvent;
    private String mergedEvent;
    private String status;

    public EventMergeRecord() {}

    public EventMergeRecord(long id, String sourceEvent, String mergedEvent, String status) {
        this.id = id;
        this.sourceEvent = sourceEvent;
        this.mergedEvent = mergedEvent;
        this.status = status;
    }

    // Getters & Setters
}
