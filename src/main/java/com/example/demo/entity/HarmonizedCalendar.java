@Entity
public class HarmonizedCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String eventTitle;
    private String description;

    public HarmonizedCalendar(){}
    
    public HarmonizedCalendar(long id, String date, String eventTitle, String description) {
        this.id = id;
        this.date = date;
        this.eventTitle = eventTitle;
        this.description = description;
    }

    // Getters & Setters
}
