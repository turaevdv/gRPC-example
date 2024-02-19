package ru.turaev.grpcserver;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends grpc.generate.HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(grpc.generate.HelloRequest request, StreamObserver<grpc.generate.HelloResponse> responseObserver) {

        String greeting = "Hello, " + request.getFirstName() + " " + request.getLastName();

        grpc.generate.HelloResponse response = grpc.generate.HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}