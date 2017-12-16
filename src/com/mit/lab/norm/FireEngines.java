package com.mit.lab.norm;

import com.mit.lab.intf.Transport;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.norm.FireEngines</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 9/5/2014
 */
public class FireEngines<T> extends Truck<T> implements Transport<T> {

    public FireEngines() {
        setSpeed(20.0d);
        System.out.println("Have a fire engine with default setting!");
    }

    public FireEngines(double volume) {
        setSpeed(volume);
        System.out.println("Have a fire engine with initial speed: " + volume);
    }

    @Override
    public void start() {
        System.out.println("Fire engines starts!");
    }

    @Override
    public void speed(double volume) {
        setSpeed(getSpeed() + volume);
        System.out.println("Fire engines speed: " + volume);
    }
}
