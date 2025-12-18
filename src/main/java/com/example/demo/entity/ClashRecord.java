@Entity
public class ClashRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String eventA;
    private String eventB;
    private String clashReason;

    public ClashRecord() {}

    public ClashRecord(long id, String eventA, String eventB, String clashReason) {
        this.id = id;
        this.eventA = eventA;
        this.eventB = eventB;
        this.clashReason = clashReason;
    }

    // Getters & Setters
}
