package org.black.lotus.kata;

import com.google.common.hash.*;

import java.nio.charset.StandardCharsets;

public class ConsistentHashDemo {

    public static void main(String... args) {
        HashFunction murMurHash = Hashing.murmur3_32((int) System.currentTimeMillis());
        Person guochen = new Person("guochen", 36);
        Person huimei = new Person("huimei", 36);
        HashCode guochenHash = murMurHash.newHasher()
                .putInt(guochen.getAge())
                .putString(guochen.getName(), StandardCharsets.UTF_8)
                .hash();

        HashCode huimeiHash = murMurHash.newHasher()
                .putInt(huimei.getAge())
                .putString(huimei.getName(), StandardCharsets.UTF_8)
                .hash();

        System.out.println(guochenHash.toString());
        System.out.println(huimeiHash.toString());
    }

    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }
}
