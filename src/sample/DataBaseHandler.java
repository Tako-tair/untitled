package sample;
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import java.sql.ResultSet;
    import java.util.ArrayList;

public class DataBaseHandler extends  Configs {
            Connection dbConnection;

            public Connection getDbConnection() throws ClassNotFoundException, SQLException {

                String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift-true&useLegacyDatetimeCode=false&serverTimezone=UTC";

                Class.forName("com.mysql.jdbc.Driver");

                dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

                return dbConnection;
            }

            public void singUpUser(User user) {
                String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_SURNAME + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," +
                        Const.USER_LOCATION + "," + Const.USER_BANKCARD + "," + Const.USER_PHONENUMBER + ")" + "VALUES(?,?,?,?,?,?,?)";

                try {
                    PreparedStatement PrSt = getDbConnection().prepareStatement(insert);
                    PrSt.setString(1, user.getName());
                    PrSt.setString(2, user.getSurname());
                    PrSt.setString(3, user.getLogin());
                    PrSt.setString(4, user.getPassword());
                    PrSt.setString(5, user.getLocation());
                    PrSt.setString(6, user.getBankCard());
                    PrSt.setString(7, user.getPhoneNumber());

                    PrSt.executeUpdate();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            public  static  User user = new User();
            public ResultSet getUser(User user){
                ResultSet resultSet = null;
                String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_NAME + "=? AND " + Const.USER_PASSWORD +"=?";
                try {
                    PreparedStatement PrSt = getDbConnection().prepareStatement(select);
                    PrSt.setString(1, user.getLogin());
                    PrSt.setString(2, user.getPassword());
                    user.setLogin(user.getLogin());
                    user.setPassword(user.getPassword());
                    resultSet = PrSt.executeQuery();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return resultSet;
            }
}
