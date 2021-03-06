package datadog.trace.instrumentation.servlet.filter;

import datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import datadog.trace.bootstrap.instrumentation.decorator.BaseDecorator;

public class FilterDecorator extends BaseDecorator {
  public static final CharSequence SERVLET_FILTER =
      UTF8BytesString.createConstant("servlet.filter");
  public static final FilterDecorator DECORATE = new FilterDecorator();

  @Override
  protected String[] instrumentationNames() {
    return new String[] {"servlet-filter"};
  }

  @Override
  protected String spanType() {
    return null;
  }

  @Override
  protected String component() {
    return "java-web-servlet-filter";
  }
}
