package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Calculator {
    private int sum =0;
    private int sam = 0;
    private ArrayList<String> calculators = new ArrayList<>();

    public int getSum(int i, int j) {
        sum+=i;
        sum=sum*j;
        sam = sum;
        return sum;
    }

    public String getList(String bread,String count){
        calculators.add(bread);
        calculators.add(count);
        Order order = new Order(bread,count);
        PackageData pd = new PackageData("ADD", order);
        Main.connect(pd);
        return String.valueOf(calculators);
    }
    public String getMoney(){
        ArrayList<Order> message=new ArrayList<>();
        DBManager dbOrder =new DBManager();
        String queryD="select * from orders where number='" + "'";
        try {
            Statement statement=dbOrder.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(queryD);
            while (resultSet.next()){
                if(resultSet.getString("accepted")!=null) {
                    message.add(new Order(resultSet.getString("accepted") +"\n"+" Your order has been accepted"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        MenuList menuList = new MenuList();
        menuList.ddd(message);
        return String.valueOf(sam);
    }
}