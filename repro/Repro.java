package repro;

public class Repro<E extends Enum<E>> {

  private final Class<E> appleTypeEnum;

  public Repro(Class<E> appleTypeEnum) {
    this.appleTypeEnum = appleTypeEnum;
  }

  public Apple<E> createApple() {
    return baseBuilder(new Apple.Builder<>(), appleTypeEnum)
      .build();
  }

  private static <T extends Fruit<E>, B extends Fruit.Builder<T, B, E>, E extends Enum<E>>
  B baseBuilder(B builder, Class<E> typeEnum) {
    return builder;
  }

}
