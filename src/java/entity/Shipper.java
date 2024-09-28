
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Shipper {
   private int  ShipperIDint ;
   private String CompanyName ;
   private String Phone ;

    public Shipper() {
    }

    public Shipper(int ShipperIDint, String CompanyName, String Phone) {
        this.ShipperIDint = ShipperIDint;
        this.CompanyName = CompanyName;
        this.Phone = Phone;
    }

    public int getShipperIDint() {
        return ShipperIDint;
    }

    public void setShipperIDint(int ShipperIDint) {
        this.ShipperIDint = ShipperIDint;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Shipper{" + "ShipperIDint=" + ShipperIDint + ", CompanyName=" + CompanyName + ", Phone=" + Phone + '}';
    }
    
}
