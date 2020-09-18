package datadog.smoketest

class SpringBootGrpcAsyncAnnotationTest extends SpringBootWithGRPCTest {

  private static final Set<String> EXPECTED_TRACES =
    ["[grpc.server[grpc.message]]",
     "[servlet.request[spring.handler[AsyncTask.greet[grpc.client[grpc.message]]]]]"].toSet()

  @Override
  boolean isAcceptable(String trace) {
    return EXPECTED_TRACES.contains(trace)
  }

  @Override
  String route() {
    return "async_annotation_greeting"
  }
}
