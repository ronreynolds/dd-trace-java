package datadog.trace.instrumentation.jedis30;

import datadog.trace.api.DDSpanTypes;
import datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import datadog.trace.bootstrap.instrumentation.decorator.DBTypeProcessingDatabaseClientDecorator;
import redis.clients.jedis.commands.ProtocolCommand;

public class JedisClientDecorator extends DBTypeProcessingDatabaseClientDecorator<ProtocolCommand> {
  public static final CharSequence REDIS_COMMAND = UTF8BytesString.createConstant("redis.command");
  public static final JedisClientDecorator DECORATE = new JedisClientDecorator();

  private static final String SERVICE_NAME = "redis";
  private static final String COMPONENT_NAME = SERVICE_NAME + "-command";

  @Override
  protected String[] instrumentationNames() {
    return new String[] {"jedis", "redis"};
  }

  @Override
  protected String service() {
    return SERVICE_NAME;
  }

  @Override
  protected String component() {
    return COMPONENT_NAME;
  }

  @Override
  protected String spanType() {
    return DDSpanTypes.REDIS;
  }

  @Override
  protected String dbType() {
    return "redis";
  }

  @Override
  protected String dbUser(final ProtocolCommand session) {
    return null;
  }

  @Override
  protected String dbInstance(final ProtocolCommand session) {
    return null;
  }
}
