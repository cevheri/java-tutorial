package com.cevher.java.polymorphism;

public class JavaPolymorphism {
    public static void main(String[] args) {
        // Substitution: Reference to SuperType can accept instance of SuperType and its subclasses
        SuperType c1Ref = new SubType();  // substituted with SuperType subclass' instance
        c1Ref.methodSuperType();     //SuperType runs methodSuperType()
        //c1Ref.methodSubType();   // CANNOT reference subclass method
        //error: cannot find symbol

        // Polymorphism: run the overridden version
        c1Ref.sayHello();    //SubType runs overridden sayHello()

        // Up-casting is type-safe, does not require explicit type cast operator
        SuperType c1Ref2 = new SubType();
        // Down-casting is NOT type-safe, require explicit type cast operator
        SubType c2Ref = (SubType)c1Ref2;
        c2Ref.methodSubType();
        //SubType c2Ref = c1Ref2;
        //error: incompatible types: SuperType cannot be converted to SubType
    }
}
class SuperType {
    public void sayHello() { System.out.println("SuperType runs sayHello()"); }
    public void methodSuperType() { System.out.println("SuperType runs methodSuperType()"); }
}
class SubType extends SuperType {  // SubType is a subclass of SuperType
    @Override public void sayHello() { System.out.println("SubType runs overridden sayHello()"); }
    public void methodSubType() { System.out.println("SubType runs methodSubType()"); }
}