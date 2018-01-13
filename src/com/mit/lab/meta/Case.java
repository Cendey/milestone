package com.mit.lab.meta;

import com.mit.lab.coms.Result;
import com.mit.lab.intf.Supplier;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.meta.Case</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 01/11/2018
 */
public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {

    private Case(Supplier<Boolean> condition, Supplier<Result<T>> result) {
        super(condition, result);
    }

    private static class DefaultCase<T> extends Case<T> {

        private DefaultCase(Supplier<Boolean> condition, Supplier<Result<T>> result) {
            super(condition, result);
        }
    }

    public static <T> DefaultCase<T> match(Supplier<Result<T>> value) {
        return new DefaultCase<>(() -> true, value);
    }

    public static <T> Case<T> match(Supplier<Boolean> condition, Supplier<Result<T>> result) {
        return new Case<>(condition, result);
    }

    @SafeVarargs
    public static <T> Result<T> options(DefaultCase<T> defaultOption, Case<T>... otherOptions) {
        for (Case<T> option : otherOptions) {
            if (option._1.get()) return option._2.get();
        }
        return defaultOption._2.get();
    }
}
