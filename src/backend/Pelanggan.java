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

public class Pelanggan {
    private int idPelanggan;
    private String namaPelanggan, noTelepone, alamat;

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNoTelepone() {
        return noTelepone;
    }

    public void setNoTelepone(String noTelepone) {
        this.noTelepone = noTelepone;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public Pelanggan(){}
    
    public Pelanggan(String namaPelanggan, String noTelepone, String alamat){
        this.namaPelanggan = namaPelanggan;
        this.noTelepone = noTelepone;
        this.alamat = alamat;
    }
    
    public Pelanggan getById(int id){
        Pelanggan pel = new Pelanggan();
        ResultSet rs = Helper.selectQuery("SELECT * FROM tb_pelanggan WHERE idpelanggan = '"+ id +"'");
        
        try{
            while(rs.next()){
                pel = new Pelanggan();
                pel.setIdPelanggan(rs.getInt("idpelanggan"));
                pel.setNamaPelanggan(rs.getString("namapelanggan"));
                pel.setNoTelepone(rs.getString("notelepone"));
                pel.setAlamat(rs.getString("alamat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pel;
    }
    
    public ArrayList<Pelanggan> getAll(){
        ArrayList<Pelanggan> ListPelanggan = new ArrayList();
        ResultSet rs = Helper.selectQuery("SELECT * FROM tb_pelanggan");
        
        try{
            while(rs.next()){
                Pelanggan pel = new Pelanggan();
                pel.setIdPelanggan(rs.getInt("idpelanggan"));
                pel.setNamaPelanggan(rs.getString("namapelanggan"));
                pel.setNoTelepone(rs.getString("notelepone"));
                pel.setAlamat(rs.getString("alamat"));
                
                ListPelanggan.add(pel);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListPelanggan;
    }
    
    public ArrayList<Pelanggan> search(String keyword){
        ArrayList<Pelanggan> ListPelanggan = new ArrayList();
        String sql = "SELECT * FROM tb_pelanggan WHERE namapelanggan LIKE '%"+ keyword +"%' OR alamat LIKE '%"+keyword+"'";
        ResultSet rs = Helper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Pelanggan pel = new Pelanggan();
                pel.setIdPelanggan(rs.getInt("idpelanggan"));
                pel.setNamaPelanggan(rs.getString("namapelanggan"));
                pel.setNoTelepone(rs.getString("notelepone"));
                pel.setAlamat(rs.getString("alamat"));
                
                ListPelanggan.add(pel);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListPelanggan;
    }
    
    public void save(){
        if(getById(idPelanggan).getIdPelanggan() == 0){
            String SQL = "INSERT INTO tb_pelanggan (namapelanggan, notelepone, alamat) VALUES("
                    +" '"+this.namaPelanggan+"',"
                    +" '"+this.noTelepone+"',"
                    +" '"+this.alamat+"')";
            this.idPelanggan = Helper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tb_pelanggan SET"
                    +" namapelanggan = '"+this.namaPelanggan+"',"
                    +" notelepone = '"+this.noTelepone+"',"
                    +" alamat = '"+this.alamat+"'"
                    +" WHERE idpelanggan = '"+this.idPelanggan+"'";
            Helper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM tb_pelanggan WHERE idpelanggan = '"+this.idPelanggan+"'";
        Helper.executeQuery(SQL);
    }
}
