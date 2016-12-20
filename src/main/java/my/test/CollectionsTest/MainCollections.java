package my.test.CollectionsTest;

import java.util.*;

/**
 * Created by Nikita on 05.10.2016.
 */
public class MainCollections {


    public static void main(String[] args) {
        test8();

    }

    /**
     * Задача с PriorityQueue.
     * Создать очередь чисел которая сеачала возвращает все четные, a потом
     * нечетные числв в порядке возрастания.
     */
    public static void test8(){
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                boolean int1Even = int1 % 2 == 0;
                boolean int2Even = int2 % 2 == 0;

                if(!int1Even && !int2Even){
                    return int1-int2;
                }

                if(!int1Even){
                    return 1;
                }
                if(!int2Even){
                    return -1;
                }

                return int1-int2;
            }
        });

        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(4);

        showQueue(priorityQueue);

    }

    /**
     * Работа с очередью.
     */
    public static void test7(){
        Queue<Integer> linkedList = new LinkedList();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        fillingQueue(priorityQueue);
        fillingQueue(linkedList);
        System.out.println("linkedList = " +linkedList);
        System.out.println("priorityQueue = " +priorityQueue);
        showQueue(linkedList);
        showQueue(priorityQueue);
    }

    private static void showQueue(Queue queue) {
        System.out.println("showQueue() = "+queue.getClass().getName());
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println("=====");
    }

    private static void fillingQueue(Queue<Integer> priorityQueue) {
        for (int i = 5; i > 0; i--) {
            priorityQueue.add(i);
        }
    }

    /**
     * Лист с слабыми ссылками.
     */
    public static void test6(){
        Map<Date, String> map = new WeakHashMap<>();
        Date date = new Date();
        map.put(date,"data1");

        date = null;
        System.gc();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            if(map.isEmpty()){
                System.out.println("Empty! "+i);
                break;
            }
        }

    }

    /**
     * Тест MyRULCache
     */
    public static void test5(){
        Map<Integer, String> map = new MyRULCache<>(2);
        map.put(1,"a1");
        map.put(2,"a2");
        map.put(3,"a3");

        map.get(2);

        map.put(9,"s9");
        System.out.println(map);
    }

    /**
     * Example use parameter accessOrder in LinkedHashMap.
     */
    public static void test4(){
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(5,1,true);
        filling(linkedHashMap);
        linkedHashMap.get(3);
        linkedHashMap.get(5);
        linkedHashMap.get(1);
        System.out.println(linkedHashMap);
    }

    /**
     * Примеры с HashMap и LinkedHashMap
     */
    public static void test3(){
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        filling(hashMap);
        System.out.println("hashMap = "+hashMap);
        System.out.println("linkedHashMap = "+linkedHashMap);
    }

    /**
     * Заполнение Map.
     */
    private static void filling(Map<Integer, String> map) {
        char[] chars = "0123456789".toCharArray();
        for (int i = 5; i >= 0; i--) {
            map.put(i,chars[i]+"");
        }
    }

    public static void test2(){
        NavigableSet<Integer> integers = new TreeSet<>();

        integers.add(0);
        integers.add(2);
        integers.add(4);
        integers.add(2);
        integers.add(5);
        integers.add(9);
        integers.add(1);
        integers.add(3);
        integers.add(2);

        System.out.println(integers);
        System.out.println(integers.floor(6));
        System.out.println(integers.ceiling(6));

        System.out.println(integers.lower(6));
        System.out.println(integers.higher(6));
    }

    /**
     * TreeSet сравнение через Comparator.
     */
    public static void tets1(){
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
    }

}
