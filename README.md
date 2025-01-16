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

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
}

@Service
public class ContactDetailsServiceImpl extends ContactDetailsServiceGrpc.ContactDetailsServiceImplBase {

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Override
    public void getContactDetails(ContactDetailsRequest request, StreamObserver<ContactDetailsResponse> responseObserver) {
        Long contactId = request.getContactId();

        ContactDetails contact = contactDetailsRepository.findById(contactId)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        ContactDetailsResponse response = ContactDetailsResponse.newBuilder()
                .setContactId(contact.getContactId())
                .setAddress(contact.getAddress())
                .setPhoneNumber(contact.getPhoneNumber())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
