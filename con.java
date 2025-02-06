package bank.management.system;

import java.sql.*;

public class con
{
    Connection connection;
    Statement statement;
    public con()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","root");
            statement = connection.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
