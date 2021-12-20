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

public class Barang {
    private int idBarang;
    private String namaBarang;
    private int hargaBarang;
    private int stock;
    private String keterangan;
    private Satuan satuan = new Satuan();

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
      
    public Barang(){}
    
    public Barang(String namaBarang, int hargaBarang, int stock, Satuan satuan, String keterangan){
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.stock = stock;
        this.satuan = satuan;
        this.keterangan = keterangan;
    }
    
    public Barang getById(int id){
        Barang bar = new Barang();
        ResultSet rs = Helper.selectQuery("SELECT a.idbarang AS idbarang, a.namabarang AS namabarang, a.harga AS harga, a.stock AS stock, a.idsatuan AS idsatuan, b.namasatuan AS namasatuan, a.keterangan AS keterangan FROM tb_barang a LEFT JOIN tb_satuan b ON a.idsatuan = b.idsatuan WHERE a.idbarang = '"+ id +"'");
        
        try{
            while(rs.next()){
                bar = new Barang();
                bar.setIdBarang(rs.getInt("idbarang"));
                bar.setNamaBarang(rs.getString("namabarang"));
                bar.setHargaBarang(rs.getInt("harga"));
                bar.setStock(rs.getInt("stock"));
                bar.getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                bar.getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                bar.setKeterangan(rs.getString("keterangan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bar;
    }
    
    public ArrayList<Barang> getAll(){
        ArrayList<Barang> ListBarang = new ArrayList();
        ResultSet rs = Helper.selectQuery("SELECT a.idbarang AS idbarang, a.namabarang AS namabarang, a.harga AS harga, a.stock AS stock, a.idsatuan AS idsatuan, b.namasatuan AS namasatuan, a.keterangan AS keterangan FROM tb_barang a LEFT JOIN tb_satuan b ON a.idsatuan = b.idsatuan");
        
        try{
            while(rs.next()){
                Barang bar = new Barang();
                bar.setIdBarang(rs.getInt("idbarang"));
                bar.setNamaBarang(rs.getString("namabarang"));
                bar.setHargaBarang(rs.getInt("harga"));
                bar.setStock(rs.getInt("stock"));
                bar.getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                bar.getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                bar.setKeterangan(rs.getString("keterangan"));
                
                ListBarang.add(bar);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListBarang;
    }
    
    public ArrayList<Barang> search(String keyword){
        ArrayList<Barang> ListBarang = new ArrayList();
        String sql = "SELECT a.idbarang AS idbarang, a.namabarang AS namabarang, a.harga AS harga, a.stock AS stock, a.idsatuan AS idsatuan, b.namasatuan AS namasatuan, a.keterangan AS keterangan FROM tb_barang a LEFT JOIN tb_satuan b ON a.idsatuan = b.idsatuan WHERE namabarang LIKE '%"+ keyword +"%'";
        ResultSet rs = Helper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Barang bar = new Barang();
                bar.setIdBarang(rs.getInt("idbarang"));
                bar.setNamaBarang(rs.getString("namabarang"));
                bar.setHargaBarang(rs.getInt("harga"));
                bar.setStock(rs.getInt("stock"));
                bar.getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                bar.getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                bar.setKeterangan(rs.getString("keterangan"));
                
                ListBarang.add(bar);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListBarang;
    }
    
    public void save(){
        if(getById(idBarang).getIdBarang() == 0){
            String SQL = "INSERT INTO tb_barang (idbarang, namabarang, harga, stock, idsatuan, keterangan) VALUES ("
                    +"'"+this.idBarang+"',"
                    +"'"+this.namaBarang+"',"
                    +"'"+this.hargaBarang+"',"
                    +"'"+this.stock+"',"
                    +"'"+this.getSatuan().getIdSatuan()+"',"
                    +"'"+this.keterangan+"')";
            this.idBarang = Helper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tb_barang SET "
                    +" namabarang = '"+this.namaBarang+"', "
                    +" harga = '"+this.hargaBarang+"', "
                    +" stock = '"+this.stock+"', "
                    +" idsatuan = '"+this.getSatuan().getIdSatuan()+"', "
                    +" keterangan = '"+this.keterangan+"' "
                    +" WHERE idbarang = '"+this.idBarang+"'";
            Helper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM tb_barang WHERE idbarang = '"+this.idBarang+"'";
        Helper.executeQuery(SQL);
    }
}
