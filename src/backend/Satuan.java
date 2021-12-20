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

public class Satuan {
    private int idSatuan;
    private String namaSatuan;
    
    public String toString(){
        return namaSatuan;
    }

    public int getIdSatuan() {
        return idSatuan;
    }

    public void setIdSatuan(int idSatuan) {
        this.idSatuan = idSatuan;
    }

    public String getNamaSatuan() {
        return namaSatuan;
    }

    public void setNamaSatuan(String namaSatuan) {
        this.namaSatuan = namaSatuan;
    }
    
    public Satuan(){}
    
    public Satuan(String namaSatuan){
        this.namaSatuan = namaSatuan;
    }
    
    public Satuan getById(int id){
        Satuan sat = new Satuan();
        ResultSet rs = Helper.selectQuery("SELECT * FROM tb_satuan WHERE idsatuan = '"+ id +"'");
        
        try{
            while(rs.next()){
                sat = new Satuan();
                sat.setIdSatuan(rs.getInt("idsatuan"));
                sat.setNamaSatuan(rs.getString("namasatuan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sat;
    }
    
    public ArrayList<Satuan> getAll(){
        ArrayList<Satuan> ListSatuan = new ArrayList();
        ResultSet rs = Helper.selectQuery("SELECT * FROM tb_satuan");
        
        try{
            while(rs.next()){
                Satuan sat = new Satuan();
                sat.setIdSatuan(rs.getInt("idsatuan"));
                sat.setNamaSatuan(rs.getString("namasatuan"));
                
                ListSatuan.add(sat);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListSatuan;
    }
    
    public ArrayList<Satuan> search(String keyword){
        ArrayList<Satuan> ListSatuan = new ArrayList();
        String sql = "SELECT * FROM tb_satuan WHERE namasatuan LIKE '%"+ keyword +"%'";
        ResultSet rs = Helper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Satuan sat = new Satuan();
                sat.setIdSatuan(rs.getInt("idsatuan"));
                sat.setNamaSatuan(rs.getString("namasatuan"));
                
                ListSatuan.add(sat);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListSatuan;
    }
    
    public void save(){
        if(getById(idSatuan).getIdSatuan() == 0){
            String SQL = "INSERT INTO tb_satuan (namasatuan) VALUES("
                    +" '"+this.namaSatuan+"')";
            this.idSatuan = Helper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tb_satuan SET"
                    +" namasatuan = '"+this.namaSatuan+"' WHERE idsatuan = '"+this.idSatuan+"'";
            Helper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM tb_satuan WHERE idsatuan = '"+this.idSatuan+"'";
        Helper.executeQuery(SQL);
    }
}
