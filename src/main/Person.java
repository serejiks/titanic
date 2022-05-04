package main;

public class Person {
    private String name;
    private double age;
    private int survived;
    private String sex;

    public Person(String name, double age, int survived, String sex) {
        this.name = name;
        this.age = age;
        this.survived = survived;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public int getSurvived() {
        return survived;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", survived=" + survived +
                ", sex='" + sex + '\'' +
                '}';
    }
}
