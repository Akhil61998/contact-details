package com.hello.contact_details.service;



import com.hello.contact.Contact;
import com.hello.contact.ContactDetailsRequest;
import com.hello.contact.ContactDetailsResponse;
import com.hello.contact.ContactDetailsServiceGrpc;
import com.hello.contact_details.service.handler.ContactInformationRequestHandler;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ContactService extends ContactDetailsServiceGrpc.ContactDetailsServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    private final ContactInformationRequestHandler contactInformationRequestHandler;

    @Autowired
    public ContactService(ContactInformationRequestHandler userRequestHandler) {
        this.contactInformationRequestHandler = userRequestHandler;
    }


    /**
     * @param request
     * @param responseObserver
     */
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getContactDetails(ContactDetailsRequest request, StreamObserver<ContactDetailsResponse> responseObserver) {
        log.info("user information for id {}", request.getContactId());
        ContactDetailsResponse contactDetailsResponse = contactInformationRequestHandler.getUserInformation(request);
        responseObserver.onNext(contactDetailsResponse);
        responseObserver.onCompleted();
    }
}
