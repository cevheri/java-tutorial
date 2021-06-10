package com.cevher.java.polymorphism;

// ref: https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGeneric.html

import java.util.ArrayList;

public class JavaPolymorphism {
    public static void main(String[] args) {
        // Substitution: Reference to SuperType can accept instance of SuperType and its subclasses
        SuperType masterReference = new SubType();  // substituted with SuperType subclass' instance
        masterReference.methodSuperType();     //SuperType runs methodSuperType()
        //masterReference.methodSubType();   // CANNOT reference subclass method
        //error: cannot find symbol

        // Polymorphism: run the overridden version
        masterReference.sayHello();    //SubType runs overridden sayHello()

        // Up-casting is type-safe, does not require explicit type cast operator
        SuperType masterReference2 = new SubType();
        // Down-casting is NOT type-safe, require explicit type cast operator
        SubType subClassReference = (SubType) masterReference2;
        subClassReference.methodSubType();
        //SubType subClassReference = masterReference2;
        //error: incompatible types: SuperType cannot be converted to SubType

        ISuperType iSuperType = new SubType();
        // cannot access: iSuperType.methodSubType();

    }
}

interface ISuperType{

}

class SuperType {
    public void sayHello() {
        System.out.println("SuperType runs sayHello()");
    }

    public void methodSuperType() {
        System.out.println("SuperType runs methodSuperType()");
    }
}

class SubType extends SuperType implements ISuperType{  // SubType is a subclass of SuperType
    @Override
    public void sayHello() {
        System.out.println("SubType runs overridden sayHello()");
    }

    public void methodSubType() {
        System.out.println("SubType runs methodSubType()");
    }
}