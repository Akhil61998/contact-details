"# contact-details" 


@Entity
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    private String address;
    private String phoneNumber;

    // Getters and setters...
}

