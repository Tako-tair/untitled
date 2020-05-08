package sample;

import java.sql.*;
import java.util.ArrayList;


    public class DBManager extends Config {

        Connection connection;

        public Connection getConnection() throws ClassNotFoundException, SQLException {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
            return connection;
        }

        public void SetOrd(Order order) {
            String insert = "INSERT INTO  " + ConstOrder.ORDER_TABLE + "(" + ConstOrder.ORDER_ID + "," + ConstOrder.ORDER_EAT + ")" + "VALUES(?,?)";
            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
                preparedStatement.setString(1,order.getEat());
                preparedStatement.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public ArrayList<Order> getOrder(){
            ArrayList<Order> orders=new ArrayList<>();
            DBManager dbOrder =new DBManager();
            String queryD="SELECT * FROM " + ConstOrder.ORDER_TABLE + " WHERE " + ConstOrder.ORDER_EAT + "=?";
            try {
                Statement statement=dbOrder.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(queryD);
                while (resultSet.next()){
                    if(resultSet.getString("eat")!=null) {
                        orders.add(new Order(resultSet.getString("eat")));
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return orders;
        }
    }
