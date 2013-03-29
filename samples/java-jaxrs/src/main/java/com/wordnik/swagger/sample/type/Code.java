package com.wordnik.swagger.sample.type;


/**
 * A class for type-safe, immutable, string-based value that can be easily persisted.
 * The generic parameter {@code T} is never used explicitly, but rather is used for
 * type-safety; for example, a method expecting an {@code Code<ReturnReason>} will not compile when
 * passed an {@code Code<NoteType>}.
 */
public class Code<T> {

  private final String code;

  public Code(String code) {
    if (code == null) {
      throw new IllegalArgumentException("cannot have a null code");
    }
    this.code = code;
  }

  /**
   * Given a string representation of a code, return a {@code Code} instance, or null if the string
   * is null.
   * @param <T> the class this is a code for
   * @param code a string representation of the code.
   * @return an appropriate Code<T> instance, or {@code null} if the string is null.
   */
  public static <T> Code<T> fromString(String code) {
    return code == null || code.length() == 0
    ? null
    : new Code<T>(code);
  }

  @Override
  public final String toString() {
    return code;
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == null || !(obj.getClass().equals(this.getClass()))) {
      return false;
    }
    return code.equals(((Code<?>) obj).code);
  }

}
