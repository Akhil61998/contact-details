package com.hello.contact_details.service.advice;



import com.hello.contact_details.exceptions.InsufficientBalanceException;
import com.hello.contact_details.exceptions.InsufficientSharesException;
import com.hello.contact_details.exceptions.UnknownTickerException;
import com.hello.contact_details.exceptions.UnknownUserException;
import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ServiceExceptionHandler {

    @GrpcExceptionHandler(UnknownTickerException.class)
    public Status handleInvalidArguments(UnknownTickerException e){
        return Status.INVALID_ARGUMENT.withDescription(e.getMessage());
    }

    @GrpcExceptionHandler(UnknownUserException.class)
    public Status handleUnknownEntities(UnknownUserException e){
        return Status.NOT_FOUND.withDescription(e.getMessage());
    }

    @GrpcExceptionHandler({InsufficientBalanceException.class, InsufficientSharesException.class})
    public Status handlePreconditionFailures(Exception e){
        return Status.FAILED_PRECONDITION.withDescription(e.getMessage());
    }

}
