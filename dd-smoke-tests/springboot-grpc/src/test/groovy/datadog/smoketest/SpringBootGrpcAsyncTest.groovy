package datadog.smoketest

class SpringBootGrpcAsyncTest extends SpringBootWithGRPCTest {
  private static final Set<String> EXPECTED_TRACES =
    ["[grpc.server[grpc.message]]",
     "[servlet.request[spring.handler[grpc.client[grpc.message]]]]"].toSet()

  @Override
  boolean isAcceptable(String trace) {
    return EXPECTED_TRACES.contains(trace)
  }

  @Override
  String route() {
    return "async_greeting"
  }
}
