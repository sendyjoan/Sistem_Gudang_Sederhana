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

public class Stock {
    private int idStock, jumlahStock;
    private Barang barang = new Barang();

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getJumlahStock() {
        return jumlahStock;
    }

    public void setJumlahStock(int jumlahStock) {
        this.jumlahStock = jumlahStock;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Stock(){}
    
    public Stock(Barang barang, int jumlahStock){
        this.barang = barang;
        this.jumlahStock = jumlahStock;
    }
    
    public Stock getById(int id){
        Stock stc = new Stock();
        ResultSet rs = Helper.selectQuery("SELECT a.idstock AS idstock, a.idbarang AS idbarang, b.namabarang AS namabarang, b.harga AS harga, b.keterangan AS keterangan, a.jumlahstock AS jumlahstock, c.namasatuan AS namasatuan, b.idsatuan AS idsatuan FROM tb_stock a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan WHERE a.idstock = '"+id+"'");
        
        try{
            while(rs.next()){
                stc = new Stock();
                stc.setIdStock(rs.getInt("idstock"));
                stc.setJumlahStock(rs.getInt("jumlahstock"));
                stc.getBarang().setIdBarang(rs.getInt("idbarang"));
                stc.getBarang().setNamaBarang(rs.getString("namabarang"));
                stc.getBarang().setHargaBarang(rs.getInt("harga"));
                stc.getBarang().setKeterangan(rs.getString("keterangan"));
                stc.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                stc.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stc;
    }
    
    public ArrayList<Stock> getAll(){
        ArrayList<Stock> ListStock = new ArrayList();
        ResultSet rs = Helper.selectQuery("SELECT a.idstock AS idstock, a.idbarang AS idbarang, b.namabarang AS namabarang, b.harga AS harga, b.keterangan AS keterangan, a.jumlahstock AS jumlahstock, c.namasatuan AS namasatuan, b.idsatuan AS idsatuan FROM tb_stock a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan");
        
        try{
            while(rs.next()){
                Stock stc = new Stock();
                stc.setIdStock(rs.getInt("idstock"));
                stc.setJumlahStock(rs.getInt("jumlahstock"));
                stc.getBarang().setIdBarang(rs.getInt("idbarang"));
                stc.getBarang().setNamaBarang(rs.getString("namabarang"));
                stc.getBarang().setHargaBarang(rs.getInt("harga"));
                stc.getBarang().setKeterangan(rs.getString("keterangan"));
                stc.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                stc.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                
                ListStock.add(stc);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListStock;
    }
    
    public ArrayList<Stock> search(String keyword){
        ArrayList<Stock> ListStock = new ArrayList();
        String sql = "SELECT a.idstock AS idstock, a.idbarang AS idbarang, b.namabarang AS namabarang, b.harga AS harga, b.keterangan AS keterangan, a.jumlahstock AS jumlahstock, c.namasatuan AS namasatuan, b.idsatuan AS idsatuan FROM tb_stock a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan WHERE b.namabarang LIKE '%"+ keyword +"%'";
        ResultSet rs = Helper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Stock stc = new Stock();
                stc.setIdStock(rs.getInt("idstock"));
                stc.setJumlahStock(rs.getInt("jumlahstock"));
                stc.getBarang().setIdBarang(rs.getInt("idbarang"));
                stc.getBarang().setNamaBarang(rs.getString("namabarang"));
                stc.getBarang().setHargaBarang(rs.getInt("harga"));
                stc.getBarang().setKeterangan(rs.getString("keterangan"));
                stc.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                stc.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                
                ListStock.add(stc);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListStock;
    }
    
    public void save(){
        if(getById(idStock).getIdStock()== 0){
            String SQL = "INSERT INTO tb_stock (idstock, idbarang, jumlahstock) VALUES ("
                    +"'"+this.idStock+"',"
                    +"'"+this.getBarang().getIdBarang()+"',"
                    +"'"+this.jumlahStock+"')";
            this.idStock = Helper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tb_stock SET "
                    +" idstock = '"+this.idStock+"', "
                    +" idbarang = '"+this.getBarang().getIdBarang()+"', "
                    +" jumlahstock = '"+this.jumlahStock+"' "
                    +" WHERE idbarang = '"+this.idStock+"'";
            Helper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM tb_stock WHERE idstock = '"+this.idStock+"'";
        Helper.executeQuery(SQL);
    }
}
