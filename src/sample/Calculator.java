package sample;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static ArrayList<String> calculators = new ArrayList<String>();
    public static ArrayList<Double> mmm = new ArrayList<>();
    double sum =0;

    public double getSum(int i, double j) {
        sum=i*j;
        mmm.add(sum);
        return sum;
    }

    public int geSum(int i, int j){
        int sum=0;
        for (int k = 0; k < j; k++) {
            sum+=i;
        }
        return sum;
    }

    public int getMoney() {
        int sum = 0;
        for (int i = 0; i < mmm.size(); i++) {
            sum += mmm.get(i);
        }
        return sum;
    }

    public String getList(String bread){
        calculators.add(bread);
        return String.valueOf(calculators);
    }

    public String getInfo() {
        String s= "";
        for (int i = 0; i < calculators.size(); i++) {
            s+=i+1+": " + calculators.get(i);
        }
        return s;
    }

    public String getRemove(String smt){
        String s= "";
        int num = Integer.parseInt(smt);
        calculators.remove(num-1);
        for (int i = 0; i < calculators.size(); i++) {
            s+=i+1+": " + calculators.get(i);
        }
        return s;
    }

    public String geRemove(String smt){
        double sum =0;
        int num = Integer.parseInt(smt);
        mmm.remove(num-1);
        for (Double aDouble : mmm) {
            sum += aDouble;
        }
        return String.valueOf(sum);
    }
}