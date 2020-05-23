package sample;

import java.util.ArrayList;

public class CalculatorSale extends Calculator implements Interface,Interface2 {

    public static ArrayList<Double> sale = new ArrayList<>();

    public double getSumm(double i, double j) {
        double sum = 0;
        double sam = 0;
        sum = i * j;
        sam = sum / 10;
        sum=sum - sam;
        sale.add(sam);
        mmm.add(sum);
        return sum;
    }

    @Override
    public int geSum(int i, int j) {
        int sum=0;
        for (int k = 0; k < j; k++) {
            sum+=i;
        }
        return sum;
    }

    @Override
    public int getMoney() {
        return super.getMoney();
    }

    @Override
    public String getList(String bread) {
        return super.getList(bread);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }



    @Override
    public void info() {
        System.out.println("Interface from >>>>>> Everything ok, your order was taken!!!");
    }

    @Override
    public void info2() {
        System.out.println("Hello world!");
    }

    @Override
    public void all() {
        System.out.println("Total many with sale is - 1 000 000" + " >>>>>>>>>Interface here");
    }


}
