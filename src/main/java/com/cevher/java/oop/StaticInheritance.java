package com.cevher.java.oop;


class A {
    public static void foo() {
        System.out.println("A runs foo()");
    }

    public static void bar() {
        System.out.println("A runs bar()");
    }
}

// This subclass inherits both static methods foo() and bar()
class B extends A {
    //@Override  //compilation error: static methods cannot be annotated with @Override
    public static void foo() {
        System.out.println("B runs foo()");
    }
    //public void bar() {}  // non-static
    //compilation error: bar() in B cannot override bar() in A

    public void hello() {  // non-static instance
        foo();
        bar();
    }

    public static void helloStatic() {
        foo();
        bar();
    }
}

public class StaticInheritance {
    public static void main(String[] args) {
        A a = new A();
        a.foo();  //A runs foo()
        A.foo();  //A runs foo()
        a.bar();  //A runs bar()
        A.bar();  //A runs bar()

        B b = new B();
        b.foo();  //B runs foo() (hide the superclass version)
        B.foo();  //B runs foo()
        b.bar();  //A runs bar() (inherited from superclass)
        B.bar();  //A runs bar()
        b.hello();  //B runs foo()
        //A runs bar() (inherited from superclass)
        b.helloStatic();  //B runs foo()
        //A runs bar()
        B.helloStatic();  //B runs foo()
        //A runs bar()

        // Test Polymorphism
        A a1 = new B();
        a1.foo();  //A runs bar() (non-polymorphic!!!)
        a1.bar();  //A runs bar()
    }
}

