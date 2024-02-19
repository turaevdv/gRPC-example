package ru.turaev.grpcclient;

import grpc.generate.HelloRequest;
import grpc.generate.HelloResponse;
import grpc.generate.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Denis")
                .setLastName("Turaev")
                .build());

        channel.shutdown();

        System.out.println("Response: " + helloResponse);
    }
}