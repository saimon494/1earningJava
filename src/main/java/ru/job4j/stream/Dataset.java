package ru.job4j.stream;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Dataset<T> {
    private final Generator<T> generator;

    private Dataset(Generator<T> generator) {
        this.generator = generator;
    }

    public void forEach(Consumer<T> consumer) {
        generator.generate(consumer);
    }

    public static <T> Dataset<T> of(Collection<T> collection) {
        return new Dataset<>(generatorContext ->
                collection.forEach(generatorContext)
        );
    }

    public Dataset<T> filter(Predicate<T> predicate) {
        return new Dataset<>(generatorContext -> generator.generate(value -> {
            if (predicate.test(value)) {
                generatorContext.accept(value);
            }
        }));
    }

    public <R> Dataset<R> map(Function<T, R> function) {
        return new Dataset<>(generatorContext -> generator.generate(
                value -> generatorContext.accept(function.apply(value))
        ));
    }
}
