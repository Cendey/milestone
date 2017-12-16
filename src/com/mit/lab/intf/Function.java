package com.mit.lab.intf;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.intf.Function</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 12/02/2017
 */
public interface Function<T, U> {

    U apply(T arg);

    default <V> Function<V, U> compose(Function<V, T> f) {
        return x -> apply(f.apply(x));
    }

    default <V> Function<T, V> andThen(Function<U, V> f) {
        return x -> f.apply(apply(x));
    }

    static <T> Function<T, T> identify() {
        return t -> t;
    }

    static <T, U, V> Function<V, U> compose(Function<T, U> f, Function<V, T> g) {
        return x -> f.apply(g.apply(x));
    }

    static <T, U, V> Function<T, V> andThen(Function<T, U> f, Function<U, V> g) {
        return x -> g.apply(f.apply(x));
    }

    static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>> compose() {
        return x -> y -> y.compose(x);
    }

    static <T, U, V> Function<Function<T, U>, Function<Function<V, T>, Function<V, U>>> andThen() {
        return x -> y -> y.andThen(x);
    }

    static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>> higherAndThen() {
        return x -> y -> z -> y.apply(x.apply(z));
    }

    static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
        return x -> y -> z -> x.apply(y.apply(z));
    }

    static <T, U, V> Function<U, Function<T, V>> swap(Function<T, Function<U, V>> f) {
        return u -> t -> f.apply(t).apply(u);
    }
}
