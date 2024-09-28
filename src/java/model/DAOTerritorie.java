/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Territories;
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
public class DAOTerritorie extends DBConnection {

    public int insertTerritorie(Territories other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Territories]\n"
                + "           ([TerritoryID]\n"
                + "           ,[TerritoryDescription]\n"
                + "           ,[RegionID])\n"
                + "     VALUES\n"
                + "           ('" + other.getTerritoryID() + "' ,'" + other.getTerritoryDescription() + "' ," + other.getRegionID() + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int addTerritorie(Territories other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Territories]\n"
                + "           ([TerritoryID]\n"
                + "           ,[TerritoryDescription]\n"
                + "           ,[RegionID])\n"
                + "     VALUES\n"
                + "           (?,? ,?)";
        try {
            PreparedStatement prestate = conn.prepareStatement(sql);
            prestate.setString(1, other.getTerritoryID());
            prestate.setString(2, other.getTerritoryDescription());
            prestate.setInt(3, other.getRegionID());
            n = prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritorie.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deleteTeritorie(String x) {
        int n = 0;
        String sql = "delete from Territories where TerritoryID =" + x;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateTerritorie(Territories other) {
        int n = 0;
        String sql = "UPDATE [dbo].[Territories]\n"
                + "   SET[TerritoryDescription] =?,[RegionID] = ?\n"
                + " WHERE [TerritoryID] = ?";
        try {
            PreparedStatement prestate = conn.prepareStatement(sql);
            prestate.setString(3, other.getTerritoryID());
            prestate.setString(1, other.getTerritoryDescription());
            prestate.setInt(2, other.getRegionID());
            n = prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritorie.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public Vector<Territories> getTerritories(String sql) {
    Vector<Territories> vector = new Vector<>();
    try {
        Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery(sql);

        while (rs.next()) {
            String TerritoryID = rs.getString("TerritoryID");
            String TerritoryDescription = rs.getString("TerritoryDescription");
            int RegionID = rs.getInt("RegionID");
            Territories newterri = new Territories(TerritoryID, TerritoryDescription, RegionID);
            vector.add(newterri);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAOTerritorie.class.getName()).log(Level.SEVERE, null, ex);
    }

    return vector;
}

public static void main(String[] args) {
    DAOTerritorie dt = new DAOTerritorie();
    Vector<Territories> vector = dt.getTerritories("Select * from Territories");
    for (Territories territories : vector) {
        System.out.println(territories.toString());
    }
}

    
}
