package sample;

public abstract class Abstract {

    abstract String getName();
    abstract String getSurname();

    void getInfo(){
        System.out.println("Abstract class here >>>> and name is " + getName());
    }
    void getInfo2(){
        System.out.println(">>>>and also surname is " + getSurname());
    }
}
