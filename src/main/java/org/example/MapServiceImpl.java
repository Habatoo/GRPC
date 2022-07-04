package org.example;


import com.example.grpc.MapServiceGrpc;
import com.example.grpc.MapServiceOuterClass;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class MapServiceImpl extends MapServiceGrpc.MapServiceImplBase {

    Map<String, String> codeMap = new HashMap<>();

    @Override
    public void takeMap(MapServiceOuterClass.MapRequest request,
                        StreamObserver<MapServiceOuterClass.MapResponse> responseObserver) {

        System.out.println("request " + request);

        codeMap.put("1111111", "SUSE");
        codeMap.put("1111112", "SUSU");

        MapServiceOuterClass.MapResponse response = MapServiceOuterClass.MapResponse
                .newBuilder()
                .setResponse("Map from server")
                .putAllCode(codeMap)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}