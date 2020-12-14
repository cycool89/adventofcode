package src.adventofcode2020.day11;

@FunctionalInterface
public interface TwoParameterFunction<T, U, R> {
    public R apply(T t, U u);
}