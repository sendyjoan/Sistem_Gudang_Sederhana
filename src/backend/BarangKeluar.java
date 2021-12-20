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

public class BarangKeluar {
    private int idKeluar, jumlahBarang;
    private Barang barang = new Barang();
    private Pelanggan pelanggan = new Pelanggan();
    private String tanggal;

    public int getIdKeluar() {
        return idKeluar;
    }

    public void setIdKeluar(int idKeluar) {
        this.idKeluar = idKeluar;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public BarangKeluar(){}
    
    public BarangKeluar(Barang barang, Pelanggan pelanggan, String tanggal, int jumlahBarang){
        this.barang =  barang;
        this.pelanggan = pelanggan;
        this.tanggal = tanggal;
        this.jumlahBarang = jumlahBarang;
    }
    
    public BarangKeluar getById(int id){
        BarangKeluar barkel = new BarangKeluar();
        ResultSet rs = Helper.selectQuery("SELECT a.idkeluar AS idkeluar, a.idbarang AS idbarang, a.idpelanggan AS idpelanggan, a.tanggal AS tanggal, a.jumlahbarang AS jumlahbarang, b.namabarang AS namabarang, b.harga AS harga, b.stock AS stock, c.idsatuan AS idsatuan, c.namasatuan AS namasatuan, b.keterangan AS keterangan, d.namapelanggan AS namapelanggan, d.notelepone AS notelepone, d.alamat AS alamat  FROM tb_barangkeluar a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan LEFT JOIN tb_pelanggan d ON a.idpelanggan = d.idpelanggan WHERE a.idkeluar = '"+ id +"'");
        
        try{
            while(rs.next()){
                barkel = new BarangKeluar();
                barkel.setIdKeluar(rs.getInt("idkeluar"));
                barkel.setTanggal(rs.getString("tanggal"));
                barkel.setJumlahBarang(rs.getInt("jumlahbarang"));
                barkel.getBarang().setIdBarang(rs.getInt("idbarang"));
                barkel.getBarang().setNamaBarang(rs.getString("namabarang"));
                barkel.getBarang().setHargaBarang(rs.getInt("harga"));
                barkel.getBarang().setStock(rs.getInt("stock"));
                barkel.getBarang().setKeterangan(rs.getString("keterangan"));
                barkel.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                barkel.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                barkel.getPelanggan().setIdPelanggan(rs.getInt("idpelanggan"));
                barkel.getPelanggan().setNamaPelanggan(rs.getString("namapelanggan"));
                barkel.getPelanggan().setNoTelepone(rs.getString("notelepone"));
                barkel.getPelanggan().setAlamat(rs.getString("alamat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barkel;
    }
    
    public ArrayList<BarangKeluar> getAll(){
        ArrayList<BarangKeluar> ListBarangKeluar = new ArrayList();
        ResultSet rs = Helper.selectQuery("SELECT a.idkeluar AS idkeluar, a.idbarang AS idbarang, a.idpelanggan AS idpelanggan, a.tanggal AS tanggal, a.jumlahbarang AS jumlahbarang, b.namabarang AS namabarang, b.harga AS harga, b.stock AS stock, c.idsatuan AS idsatuan, c.namasatuan AS namasatuan, b.keterangan AS keterangan, d.namapelanggan AS namapelanggan, d.notelepone AS notelepone, d.alamat AS alamat FROM tb_barangkeluar a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan LEFT JOIN tb_pelanggan d ON a.idpelanggan = d.idpelanggan");
        
        try{
            while(rs.next()){
                BarangKeluar barkel = new BarangKeluar();
                barkel.setIdKeluar(rs.getInt("idkeluar"));
                barkel.setTanggal(rs.getString("tanggal"));
                barkel.setJumlahBarang(rs.getInt("jumlahbarang"));
                barkel.getBarang().setIdBarang(rs.getInt("idbarang"));
                barkel.getBarang().setNamaBarang(rs.getString("namabarang"));
                barkel.getBarang().setHargaBarang(rs.getInt("harga"));
                barkel.getBarang().setStock(rs.getInt("stock"));
                barkel.getBarang().setKeterangan(rs.getString("keterangan"));
                barkel.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                barkel.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                barkel.getPelanggan().setIdPelanggan(rs.getInt("idpelanggan"));
                barkel.getPelanggan().setNamaPelanggan(rs.getString("namapelanggan"));
                barkel.getPelanggan().setNoTelepone(rs.getString("notelepone"));
                barkel.getPelanggan().setAlamat(rs.getString("alamat"));
                
                ListBarangKeluar.add(barkel);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListBarangKeluar;
    }
    
    public ArrayList<BarangKeluar> search(String keyword){
        ArrayList<BarangKeluar> ListBarangKeluar = new ArrayList();
        String sql = "SELECT a.idkeluar AS idkeluar, a.idbarang AS idbarang, a.idpelanggan AS idpelanggan, a.tanggal AS tanggal, a.jumlahbarang AS jumlahbarang, b.namabarang AS namabarang, b.harga AS harga, b.stock AS stock, c.idsatuan AS idsatuan, c.namasatuan AS namasatuan, b.keterangan AS keterangan, d.namapelanggan AS namapelanggan, d.notelepone AS notelepone, d.alamat AS alamat FROM tb_barangkeluar a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan LEFT JOIN tb_pelanggan d ON a.idpelanggan = d.idpelanggan WHERE namabarang LIKE '%"+ keyword +"%'";
        ResultSet rs = Helper.selectQuery(sql);
        
        try{
            while(rs.next()){
                BarangKeluar barkel = new BarangKeluar();
                barkel.setIdKeluar(rs.getInt("idkeluar"));
                barkel.setTanggal(rs.getString("tanggal"));
                barkel.setJumlahBarang(rs.getInt("jumlahbarang"));
                barkel.getBarang().setIdBarang(rs.getInt("idbarang"));
                barkel.getBarang().setNamaBarang(rs.getString("namabarang"));
                barkel.getBarang().setHargaBarang(rs.getInt("harga"));
                barkel.getBarang().setStock(rs.getInt("stock"));
                barkel.getBarang().setKeterangan(rs.getString("keterangan"));
                barkel.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                barkel.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                barkel.getPelanggan().setIdPelanggan(rs.getInt("idpelanggan"));
                barkel.getPelanggan().setNamaPelanggan(rs.getString("namapelanggan"));
                barkel.getPelanggan().setNoTelepone(rs.getString("notelepone"));
                barkel.getPelanggan().setAlamat(rs.getString("alamat"));
                
                ListBarangKeluar.add(barkel);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListBarangKeluar;
    }
    
    public void save(){
        if(getById(idKeluar).getIdKeluar() == 0){
            String SQL = "INSERT INTO tb_barangkeluar (idbarang, idpelanggan, tanggal, jumlahbarang) VALUES ("
                    +"'"+this.getBarang().getIdBarang()+"',"
                    +"'"+this.getPelanggan().getIdPelanggan()+"',"
                    +"'"+this.tanggal+"',"
                    +"'"+this.jumlahBarang+"')";
            this.idKeluar = Helper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tb_barangkeluar SET "
                    +" idbarang = '"+this.getBarang().getIdBarang()+"', "
                    +" idpelanggan = '"+this.getPelanggan().getIdPelanggan()+"', "
                    +" tanggal = '"+this.tanggal+"', "
                    +" jumlahbarang = '"+this.jumlahBarang+"' "
                    +" WHERE idkeluar = '"+this.getIdKeluar()+"'";
            Helper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM tb_barangkeluar WHERE idkeluar = '"+this.idKeluar+"'";
        Helper.executeQuery(SQL);
    }
}
