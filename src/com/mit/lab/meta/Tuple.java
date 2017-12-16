package com.mit.lab.meta;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.meta.Tuple</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 11/28/2017
 */
public class Tuple<T, U> {

    private final T first;
    private final U second;

    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
