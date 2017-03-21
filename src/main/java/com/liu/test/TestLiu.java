package com.liu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.context.annotation.Configuration;
public class TestLiu {

	public static void main(String[] args) {
		/*Thread t;
		int []ret = new int[5];
		Class<? extends int[]> class1 = ret.getClass();
		BeanFactory b;
		//ClassPathXmlApplicationContext a;
		//BeanDefinition a1;
		Map<String, String> map =new HashMap<String, String>();
		map.get("");
		map.put("s", "");*/
		List<Integer> list=new ArrayList<Integer>();
		System.out.println(list.size());
		//list.set(100, 66);
		Set<Integer> set= new TreeSet<Integer>();
		
		/*Singleton.getInstance();
        while(true){
            new Object();
        }*/
		list.add(1);
		new Thread().start();
	}
	
	static class Singleton {
        private byte[] a = new byte[6*1024*1024];
        private static Singleton singleton = new Singleton();
        private Singleton(){}

        public static Singleton getInstance(){
            return singleton;
        }
    }

    class Obj {
        private byte[] a = new byte[3*1024*1024];
    }
    
	static class MyTest1{
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
	}
	
	static class MyTest2 implements Cloneable{
		@Override
		public MyTest2 clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return (MyTest2) super.clone();
		}
	}
}
