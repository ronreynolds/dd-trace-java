package datadog.smoketest

class SpringBootGrpcSpannerTest extends SpringBootWithGRPCTest {

  @Override
  boolean isAcceptable(String trace) {
    return (trace.startsWith("[servlet.request[spring.handler[SpannerTask.spannerResultSet[grpc.client]") || trace.startsWith("[grpc.client]") || trace.startsWith("[http.request]"))
  }

  @Override
  String route() {
    return "spanner"
  }
}
