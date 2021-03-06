package com.mit.lab.meta;

import com.mit.lab.intf.Function;

import java.util.Objects;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.meta.Tuple</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 12/16/2017
 */
public class Tuple<T,U> {


    public final T _1;
    public final U _2;

    public Tuple(T t, U u) {
        this._1 = Objects.requireNonNull(t);
        this._2 = Objects.requireNonNull(u);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", _1, _2);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o.getClass() == this.getClass()))
            return false;
        else {
            @SuppressWarnings("rawtypes")
            Tuple that = (Tuple) o;
            return _1.equals(that._1) && _2.equals(that._2);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + _1.hashCode();
        result = prime * result + _2.hashCode();
        return result;
    }

    public Tuple<U, T> swap() {
        return new Tuple<>(_2, _1);
    }

    public static <T> Tuple<T, T> swapIf(Tuple<T, T> t, Function<T, Function<T, Boolean>> p) {
        return p.apply(t._1).apply(t._2) ? t.swap() : t;
    }
}
