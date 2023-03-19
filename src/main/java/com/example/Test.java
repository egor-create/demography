package com.example;

public class Test {

    public class A {

        private int strata;
        private int age;

        private int population; // изначально не ноль, а взят из экселя, а потом перезаписываем поле

        public A() {
        }

        public A(int strata, int age, int population) {
            this.strata = strata;
            this.age = age;
            this.population = population;
        }

        public int getStrata() {
            return strata;
        }

        public void setStrata(int strata) {
            this.strata = strata;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

    }

    public class B extends A {
        public B(int strata, int age, int population) {
            super();
        }
    }

    public static void main(String[] args) {

        Test test = new Test();

        B b = test.new B(1, 2, 3);

        System.out.println(b.getStrata());
        System.out.println(b.getAge());
        System.out.println(b.getPopulation());
    }

}