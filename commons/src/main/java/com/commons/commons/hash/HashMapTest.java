package com.commons.commons.hash;

import java.util.*;

/**
 * @Author zhaomengxia
 * @create 2019/11/12 9:00
 */
public class HashMapTest {
    public static void main(String[] args) {
        //都实现了map接口，不允许key重复，如果重复赋值key相同 value不同的 key-value，
        // 则会去查找是否存在即将要put的key值如果存在即将要put的value值会覆盖已存在的key对应的value的值
        //hashmap允许key值为null
        // hashmap方法没有
        Map map=new HashMap();
        map.put(null,null);
        map.put(null,123);
        for (Object key:
             map.keySet()) {
            System.out.println(key+"----------------");
        }
        //hashtable不允许key和value值为null
        Map map1=new Hashtable();

        map1.put(1,1);
        map1.put(1,3);

        for (Object value:
             map1.values()) {
            System.out.println(value+"--------");
        }

        //无序，不重复
        Set set=new HashSet();
        set.add(3);
        set.add(2);
        set.add(2);

        set.add(1);

        set.add(11);
        set.add(22);
        set.add(33);
        set.add(0);
        for (Object s:
             set) {
            System.out.println(s+"--------");
        }


        Set set1=new LinkedHashSet();


    }
}
