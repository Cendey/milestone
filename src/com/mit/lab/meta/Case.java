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

    private Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
        super(booleanSupplier, resultSupplier);
    }

    private static class DefaultCase<T> extends Case<T> {

        private DefaultCase(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
            super(booleanSupplier, resultSupplier);
        }
    }

    public static <T> DefaultCase<T> matchCase(Supplier<Result<T>> value) {
        return new DefaultCase<>(() -> true, value);
    }

    public static <T> Case<T> matchCase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        return new Case<>(condition, value);
    }

    @SafeVarargs
    public static <T> Result<T> matchOption(DefaultCase<T> defaultCase, Case<T>... matchCases) {
        for (Case<T> match : matchCases) {
            if (match._1.get()) return match._2.get();
        }
        return defaultCase._2.get();
    }
}
