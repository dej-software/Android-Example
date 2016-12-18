package com.jikexueyuan.usinglayoutdirectory;

/**
 * Created by dej on 2016/10/15.
 */
public class People {
    private String name;
    private int age;

    private static People people;

    public static People getPeople() {
        if (people == null) {
            people = new People();
        }
        return people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
