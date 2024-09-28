/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import entity.Orders;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DAOOrders extends DBConnection {

    public int insertOrder(Orders other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([CustomerID]\n"
                + "           ,[EmployeeID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[RequiredDate]\n"
                + "           ,[ShippedDate]\n"
                + "           ,[ShipVia]\n"
                + "           ,[Freight]\n"
                + "           ,[ShipName]\n"
                + "           ,[ShipAddress]\n"
                + "           ,[ShipCity]\n"
                + "           ,[ShipRegion]\n"
                + "           ,[ShipPostalCode]\n"
                + "           ,[ShipCountry])\n"
                + "     VALUES\n"
                + "           ('" + other.getCustomerID() + "' ," + other.getEmployeeID() + " ,'" + other.getOrderDate() + "' ,'" + other.getRequiredDate() + "',"
                + "'" + other.getShippedDate() + "'," + other.getShipVia() + " ," + other.getFreight() + " ,'" + other.getShipName() + "' ,"
                + "'" + other.getShipAddress() + "' ,'" + other.getShipCity() + "','" + other.getShipRegion() + "' ,"
                + "'" + other.getShipPostalCode() + "' ,'" + other.getShipCountry() + "')";

        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int addOrder(Orders other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([CustomerID]\n"
                + "           ,[EmployeeID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[RequiredDate]\n"
                + "           ,[ShippedDate]\n"
                + "           ,[ShipVia]\n"
                + "           ,[Freight]\n"
                + "           ,[ShipName]\n"
                + "           ,[ShipAddress]\n"
                + "           ,[ShipCity]\n"
                + "           ,[ShipRegion]\n"
                + "           ,[ShipPostalCode]\n"
                + "           ,[ShipCountry])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prestate = conn.prepareStatement(sql);
            prestate.setString(1, other.getCustomerID());
            prestate.setInt(2, other.getEmployeeID());
            prestate.setString(3, other.getOrderDate());
            prestate.setString(4, other.getRequiredDate());
            prestate.setString(5, other.getShippedDate());
            prestate.setInt(6, other.getShipVia());
            prestate.setDouble(7, other.getFreight());
            prestate.setString(8, other.getShipName());
            prestate.setString(9, other.getShipAddress());
            prestate.setString(10, other.getShipCity());
            prestate.setString(11, other.getShipRegion());
            prestate.setString(12, other.getShipPostalCode());
            prestate.setString(13, other.getShipCountry());
            n = prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteOrder(int orderID) {
        int n = 0;
        String sql = "Delete from Orders where OrderID =" + orderID;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateOrder(Orders other) {
        int n = 0;
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[EmployeeID] = ?\n"
                + "      ,[OrderDate] = ?\n"
                + "      ,[RequiredDate] = ?\n"
                + "      ,[ShippedDate] = ?\n"
                + "      ,[ShipVia] = ?\n"
                + "      ,[Freight] = ?\n"
                + "      ,[ShipName] = ?\n"
                + "      ,[ShipAddress] = ?\n"
                + "      ,[ShipCity] = ?\n"
                + "      ,[ShipRegion] = ?\n"
                + "      ,[ShipPostalCode] = ?\n"
                + "      ,[ShipCountry] = ?\n"
                + " WHERE OrderID = ?";

        try {
            PreparedStatement prestate = conn.prepareStatement(sql);
            prestate.setString(1, other.getCustomerID());
            prestate.setInt(2, other.getEmployeeID());
            prestate.setString(3, other.getOrderDate());
            prestate.setString(4, other.getRequiredDate());
            prestate.setString(5, other.getShippedDate());
            prestate.setInt(6, other.getShipVia());
            prestate.setDouble(7, other.getFreight());
            prestate.setString(8, other.getShipName());
            prestate.setString(9, other.getShipAddress());
            prestate.setString(10, other.getShipCity());
            prestate.setString(11, other.getShipRegion());
            prestate.setString(12, other.getShipPostalCode());
            prestate.setString(13, other.getShipCountry());
            prestate.setInt(14, other.getOrderID());
            n = prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Orders> getOrder(String sql) {
        Vector< Orders> vector = new Vector<>();
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                String OrderDate = rs.getString("OrderDate"),
                        RequiredDate = rs.getString("RequiredDate"),
                        ShippedDate = rs.getString("ShippedDate");
                int ShipVia = rs.getInt("ShipVia");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName"),
                        ShipAddress = rs.getString("ShipAddress"),
                        ShipCity = rs.getString("ShipCity"),
                        ShipRegion = rs.getString("ShipRegion"),
                        ShipPostalCode = rs.getString("ShipPostalCode"),
                        ShipCountry = rs.getString("ShipCountry");
                Orders newOrder = new Orders(OrderID, EmployeeID, ShipVia, CustomerID, OrderDate, RequiredDate, ShippedDate, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry, Freight) ;
        vector.add(newOrder);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOOrders dod = new DAOOrders();
        Vector<Orders> vector = dod.getOrder("Select * from Orders");
        for (Orders orders : vector) {
            System.out.println(orders.toString());
        }
    }
}