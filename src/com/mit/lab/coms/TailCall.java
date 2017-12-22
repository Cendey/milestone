package com.mit.lab.coms;

import com.mit.lab.intf.Supplier;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.coms.TailCall</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 12/16/2017
 */
public abstract class TailCall<T> {
    public abstract TailCall<T> resume();

    public abstract T eval();

    public abstract boolean isSuspend();

    private TailCall() {
    }

    private static class Return<T> extends TailCall<T> {

        private final T t;

        private Return(T t) {
            this.t = t;
        }

        @Override
        public T eval() {
            return t;
        }

        @Override
        public boolean isSuspend() {
            return false;
        }

        @Override
        public TailCall<T> resume() {
            throw new IllegalStateException("Return has no resume");
        }
    }

    private static class Suspend<T> extends TailCall<T> {

        private final Supplier<TailCall<T>> resume;

        private Suspend(Supplier<TailCall<T>> resume) {
            this.resume = resume;
        }

        @Override
        public T eval() {
            TailCall<T> tailRec = this;
            while(tailRec.isSuspend()) {
                tailRec = tailRec.resume();
            }
            return tailRec.eval();
        }

        @Override
        public boolean isSuspend() {
            return true;
        }

        @Override
        public TailCall<T> resume() {
            return resume.get();
        }
    }

    public static <T> Return<T> ret(T t) {
        return new Return<>(t);
    }

    public static <T> Suspend<T> sus(Supplier<TailCall<T>> s) {
        return new Suspend<>(s);
    }
}
