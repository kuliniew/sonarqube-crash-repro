package repro;

public abstract class Apple<E extends Enum<E>> extends Fruit<E> {

  public static class Builder<E extends Enum<E>> implements Fruit.Builder<Apple<E>, Apple.Builder<E>, E> {}

}
