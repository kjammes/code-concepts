package org.example.ZAChallenge30March;

public class MyClass extends AbClass implements Interface1, Interface2{
    @Override
    public void printMyName() {
        System.out.println("My name is abomination");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.printMyName();
    }
}
