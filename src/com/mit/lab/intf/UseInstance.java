package com.mit.lab.intf;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: UseInstance</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 4/24/2014
 */
@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {

    void accept(T instance) throws X;
}
