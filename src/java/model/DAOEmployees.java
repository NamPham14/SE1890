package model;

import entity.Employees;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmployees extends DBConnection {

    public int insertEmployee(Employees employee) {
        String sql = "INSERT INTO [dbo].[Employees] " +
                "([LastName], [FirstName], [Title], [TitleOfCourtesy], [BirthDate], [HireDate], " +
                "[Address], [City], [Region], [PostalCode], [Country], [HomePhone], " +
                "[Extension], [Photo], [Notes], [ReportsTo], [PhotoPath]) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement prestate = conn.prepareStatement(sql)) {
            prestate.setString(1, employee.getLastName());
            prestate.setString(2, employee.getFirstName());
            prestate.setString(3, employee.getTitle());
            prestate.setString(4, employee.getTitleOfCourtesy());
            prestate.setString(5, employee.getBirthDate());
            prestate.setString(6, employee.getHireDate());
            prestate.setString(7, employee.getAddress());
            prestate.setString(8, employee.getCity());
            prestate.setString(9, employee.getRegion());
            prestate.setString(10, employee.getPostalCode());
            prestate.setString(11, employee.getCountry());
            prestate.setString(12, employee.getHomePhone());
            prestate.setString(13, employee.getExtension());
            prestate.setString(14, employee.getPhoto());
            prestate.setString(15, employee.getNotes());
            prestate.setInt(16, employee.getReportsTo());
            prestate.setString(17, employee.getPhotoPath());
            return prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int deleteEmployee(int employeeID) {
        String sql = "DELETE FROM Employees WHERE EmployeeID = ?";
        try (PreparedStatement prestate = conn.prepareStatement(sql)) {
            prestate.setInt(1, employeeID);
            return prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int updateEmployee(Employees employee) {
        String sql = "UPDATE [dbo].[Employees] SET " +
                "[LastName] = ?, [FirstName] = ?, [Title] = ?, [TitleOfCourtesy] = ?, " +
                "[BirthDate] = ?, [HireDate] = ?, [Address] = ?, [City] = ?, " +
                "[Region] = ?, [PostalCode] = ?, [Country] = ?, [HomePhone] = ?, " +
                "[Extension] = ?, [Photo] = ?, [Notes] = ?, [ReportsTo] = ?, " +
                "[PhotoPath] = ? WHERE [EmployeeID] = ?";

        try (PreparedStatement prestate = conn.prepareStatement(sql)) {
            prestate.setString(1, employee.getLastName());
            prestate.setString(2, employee.getFirstName());
            prestate.setString(3, employee.getTitle());
            prestate.setString(4, employee.getTitleOfCourtesy());
            prestate.setString(5, employee.getBirthDate());
            prestate.setString(6, employee.getHireDate());
            prestate.setString(7, employee.getAddress());
            prestate.setString(8, employee.getCity());
            prestate.setString(9, employee.getRegion());
            prestate.setString(10, employee.getPostalCode());
            prestate.setString(11, employee.getCountry());
            prestate.setString(12, employee.getHomePhone());
            prestate.setString(13, employee.getExtension());
            prestate.setString(14, employee.getPhoto());
            prestate.setString(15, employee.getNotes());
            prestate.setInt(16, employee.getReportsTo());
            prestate.setString(17, employee.getPhotoPath());
            prestate.setInt(18, employee.getEmployeeID());
            return prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public Vector<Employees> getEmployee(String sql) {
        Vector<Employees> vector = new Vector<>();
        try (Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = state.executeQuery(sql)) {
            while (rs.next()) {
                int employeeID = rs.getInt("EmployeeID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String title = rs.getString("Title");
                String titleOfCourtesy = rs.getString("TitleOfCourtesy");
                String birthDate = rs.getString("BirthDate");
                String hireDate = rs.getString("HireDate");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String region = rs.getString("Region");
                String postalCode = rs.getString("PostalCode");
                String country = rs.getString("Country");
                String homePhone = rs.getString("HomePhone");
                String extension = rs.getString("Extension");
                String photo = rs.getString("Photo");
                String notes = rs.getString("Notes");
                int reportsTo = rs.getInt("ReportsTo");
                String photoPath = rs.getString("PhotoPath");

                Employees newEmployee = new Employees(employeeID, reportsTo,lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, address, city, region, 
                        postalCode, country, homePhone, extension, photo, notes, photoPath);
                vector.add(newEmployee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOEmployees daoEmp = new DAOEmployees();
        Vector<Employees> vector = daoEmp.getEmployee("SELECT * FROM Employees");
        for (Employees employee : vector) {
            System.out.println(employee);
        }
    }
}
