package com.cpgp.grpcproject.service;

import com.cpgp.grpcproject.GreetingRequest;
import com.cpgp.grpcproject.GreetingResponse;
import com.cpgp.grpcproject.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

  @Override
  public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
    String message = request.getMessage();
    log.info("Message was received: {}", message);

    GreetingResponse greetingResponse = GreetingResponse.newBuilder()
        .setMessage("Your input message is: " + message + ". Successfully from server")
        .build();

    responseObserver.onNext(greetingResponse);
    responseObserver.onCompleted();
  }
}
