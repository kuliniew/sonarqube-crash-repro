package repro;

public abstract class Fruit<E extends Enum<E>> {

  public interface Builder<T extends Fruit<E>, B extends Fruit.Builder<T, B, E>, E extends Enum<E>> {
    default T build() {
      return null;
    }
  }

}
