package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8888)
                .addService(new MapServiceImpl())
                .build();

        server.start();
        System.out.println("Server start");
        server.awaitTermination();
    }
}
