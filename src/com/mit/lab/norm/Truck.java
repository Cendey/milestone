package com.mit.lab.norm;

import com.mit.lab.intf.Transport;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.norm.Truck</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 9/5/2014
 */
public class Truck<T> implements Transport<T> {

    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Truck() {
        System.out.println("Have a truck with default setting!");
    }

    public Truck(double volume) {
        speed = volume;
        System.out.println("Have a truck with initial speed: " + volume);
    }

    @Override
    public void start() {
        System.out.println("The truck starts!");
    }

    @Override
    public void speed(double volume) {
        System.out.println("Speed the truck by 50 mile/h!");
    }
}
