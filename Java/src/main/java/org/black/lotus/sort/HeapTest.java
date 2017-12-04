package org.black.lotus.sort;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.IntStream;

public class HeapTest {

    public static void main(String... args) {
        PriorityQueue<QueueItem> priorityQueue = new PriorityQueue<>(10);

        QueueItem item1 = new QueueItem();
        item1.value = 20;

        QueueItem item2 = new QueueItem();
        item2.value = 30;

        QueueItem item3 = new QueueItem();
        item3.value = 15;

        QueueItem item4 = new QueueItem();
        item4.value = 25;


        priorityQueue.add(item2);
        priorityQueue.add(item1);
        priorityQueue.add(item3);
        priorityQueue.add(item4);

        QueueItem k1 = priorityQueue.poll();
        QueueItem k2 = priorityQueue.poll();
        System.out.println(k1.value + " " + k2.value);



        Person[] team = new Person[3];
        team[0] = new Person(1, "guochen");
        team[1] = new Person(2, "huimei");
        team[2] = new Person(3, "guoxiaoyi");

        Person[] guests = new Person[team.length];
        System.arraycopy(team, 0, guests, 0, team.length);
        guests[0].name = "huimei";
        guests[1].name = "guochen";

        for (int i = 0; i < team.length; ++i) {
            System.out.println(team[i].name + " " + guests[i].name);
        }
    }

    static class QueueItem implements Comparable<QueueItem> {

        public int value;

        @Override
        public int compareTo(QueueItem o) {
            return this.value - o.value;
        }
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private int age;
        private String name;
    }
}
