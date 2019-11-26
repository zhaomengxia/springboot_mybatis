package com.commons.commons;


import org.junit.Test;


public class CommonsApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("oooifjjdg");
	}

	/**
	 * 多线程同时运行的时候，没法确定谁在先谁在后，是看谁先抢占到cpu资源的。
	 * 这样就导致调试的时候比较麻烦。
	 * 那么希望断点按自己的顺序执行，则需要选中红点右击接着选中Thread
	 */
	@Test
	public void testMultiThread(){
		new Thread(()->{
			System.out.println("线程1");
		},"线程1").start();

		new Thread(()->{
			System.out.println("线程2");
		},"线程2").start();

		System.out.println("3.锄禾日当午");
	}

}
