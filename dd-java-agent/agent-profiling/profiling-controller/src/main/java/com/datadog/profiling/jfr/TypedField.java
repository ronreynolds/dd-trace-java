package com.datadog.profiling.jfr;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** A representation of a typed field with a name */
public final class TypedField {
  private final String name;
  private final Type type;
  private final boolean isArray;
  private final List<Annotation> annotations;

  TypedField(Type type, String name) {
    this(type, name, false, Collections.emptyList());
  }

  TypedField(Type type, String name, boolean isArray) {
    this(type, name, isArray, Collections.emptyList());
  }

  TypedField(Type type, String name, boolean isArray, List<Annotation> annotations) {
    Objects.requireNonNull(type);
    Objects.requireNonNull(name);
    Objects.requireNonNull(annotations);

    this.name = name;
    this.type = type;
    this.isArray = isArray;
    this.annotations = Collections.unmodifiableList(annotations);
  }

  /** @return field name */
  public String getName() {
    return name;
  }

  /** @return field type */
  public Type getType() {
    return type;
  }

  /** @return is the field content an array */
  public boolean isArray() {
    return isArray;
  }

  public List<Annotation> getAnnotations() {
    return annotations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TypedField that = (TypedField) o;
    return isArray == that.isArray
        && name.equals(that.name)
        && type.equals(that.type)
        && annotations.equals(that.annotations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, isArray, annotations);
  }
}