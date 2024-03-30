package org.example.ZAChallenge30March;

public class Main {
    public static void main(String[] args) {
        var obj = new MyClass();
        obj.printMyName();

        AbClass abObj = new MyClass();
        abObj.printMyName();

        Interface1 ifObj = new MyClass();
        ifObj.printMyName();

        Interface2 if2Obj = new MyClass();
        ifObj.printMyName();
    }
}
