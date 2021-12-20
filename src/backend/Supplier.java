/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author EA4618JO
 */
import java.util.ArrayList;
import java.sql.*;

public class Supplier {
    private int idSupplier;
    private String namaSupplier, perusahaanSupplier, alamatPerusahaan, teleponePerusahaan;

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }

    public String getPerusahaanSupplier() {
        return perusahaanSupplier;
    }

    public void setPerusahaanSupplier(String perusahaanSupplier) {
        this.perusahaanSupplier = perusahaanSupplier;
    }

    public String getAlamatPerusahaan() {
        return alamatPerusahaan;
    }

    public void setAlamatPerusahaan(String alamatPerusahaan) {
        this.alamatPerusahaan = alamatPerusahaan;
    }

    public String getTeleponePerusahaan() {
        return teleponePerusahaan;
    }

    public void setTeleponePerusahaan(String teleponePerusahaan) {
        this.teleponePerusahaan = teleponePerusahaan;
    }
    
    public Supplier(){}
    
    public Supplier(String namaSupplier, String perusahaanSupplier, String alamatPerusahaan, String teleponePerusahaan){
        this.namaSupplier = namaSupplier;
        this.perusahaanSupplier= perusahaanSupplier;
        this.alamatPerusahaan = alamatPerusahaan;
        this.teleponePerusahaan = teleponePerusahaan;
    }
    
    public Supplier getById(int id){
        Supplier sup = new Supplier();
        ResultSet rs = Helper.selectQuery("SELECT * FROM tb_supplier WHERE idsupplier = '"+ id +"'");
        
        try{
            while(rs.next()){
                sup = new Supplier();
                sup.setIdSupplier(rs.getInt("idsupplier"));
                sup.setNamaSupplier(rs.getString("namasupplier"));
                sup.setPerusahaanSupplier(rs.getString("perusahaansupplier"));
                sup.setAlamatPerusahaan(rs.getString("alamatperusahaan"));
                sup.setTeleponePerusahaan(rs.getString("teleponeperusahaan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sup;
    }
    
    public ArrayList<Supplier> getAll(){
        ArrayList<Supplier> ListSupplier = new ArrayList();
        ResultSet rs = Helper.selectQuery("SELECT * FROM tb_supplier");
        
        try{
            while(rs.next()){
                Supplier sup = new Supplier();
                sup.setIdSupplier(rs.getInt("idsupplier"));
                sup.setNamaSupplier(rs.getString("namasupplier"));
                sup.setPerusahaanSupplier(rs.getString("perusahaansupplier"));
                sup.setAlamatPerusahaan(rs.getString("alamatperusahaan"));
                sup.setTeleponePerusahaan(rs.getString("teleponeperusahaan"));
                
                ListSupplier.add(sup);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListSupplier;
    }
    
    public ArrayList<Supplier> search(String keyword){
        ArrayList<Supplier> ListSupplier = new ArrayList();
        String sql = "SELECT * FROM tb_supplier WHERE namasupplier LIKE '%"+ keyword +"%' OR perusahaansupplier LIKE '%"+keyword+"'";
        ResultSet rs = Helper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Supplier sup = new Supplier();
                sup.setIdSupplier(rs.getInt("idsupplier"));
                sup.setNamaSupplier(rs.getString("namasupplier"));
                sup.setPerusahaanSupplier(rs.getString("perusahaansupplier"));
                sup.setAlamatPerusahaan(rs.getString("alamatperusahaan"));
                sup.setTeleponePerusahaan(rs.getString("teleponeperusahaan"));
                
                ListSupplier.add(sup);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListSupplier;
    }
    
    public void save(){
        if(getById(idSupplier).getIdSupplier() == 0){
            String SQL = "INSERT INTO tb_supplier (namasupplier, perusahaansupplier, alamatperusahaan, teleponeperusahaan) VALUES("
                    +" '"+this.namaSupplier+"',"
                    +" '"+this.perusahaanSupplier+"',"
                    +" '"+this.alamatPerusahaan+"',"
                    +" '"+this.teleponePerusahaan+"')";
            this.idSupplier = Helper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tb_supplier SET"
                    +" namasupplier = '"+this.namaSupplier+"',"
                    +" perusahaansupplier = '"+this.perusahaanSupplier+"',"
                    +" perusahaansupplier = '"+this.perusahaanSupplier+"',"
                    +" alamatperusahaan = '"+this.alamatPerusahaan+"',"
                    +" teleponeperusahaan = '"+this.teleponePerusahaan+"'"
                    +" WHERE idsupplier = '"+this.idSupplier+"'";
            Helper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM tb_supplier WHERE idsupplier = '"+this.idSupplier+"'";
        Helper.executeQuery(SQL);
    }
}
