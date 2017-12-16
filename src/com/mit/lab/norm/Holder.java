package com.mit.lab.norm;

import java.util.function.Supplier;

/**
 * <p>
 * Title: Blueprint
 * </p>
 * <p>
 * Description: Holder
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: MIT-LAB Co., Ltd
 * </p>
 *
 * @author Developer
 * @version 1.0
 * @date 4/25/2014
 */
public class Holder {

	private Supplier<Heavy> heavy = this::createAndCacheHeavy;

	public Holder() {
		System.out.println("Holder created");
	}

	public Heavy getHeavy() {
		return heavy.get();
	}

	private synchronized Heavy createAndCacheHeavy() {
		class HeavyFactory implements Supplier<Heavy> {

			private final Heavy heavyInstance = new Heavy();

			public Heavy get() {
				return heavyInstance;
			}
		}
		if (!HeavyFactory.class.isInstance(heavy)) {
			heavy = new HeavyFactory();
		}
		return heavy.get();
	}
}
