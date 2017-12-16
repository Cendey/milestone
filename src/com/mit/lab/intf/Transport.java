package com.mit.lab.intf;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.intf.Transport</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 9/5/2014
 */
public interface Transport<T> {
    void start();
    void speed(double volume);
}
