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

public class BarangMasuk {
    private int idBarangMasuk;
    private Barang barang = new Barang();
    private Supplier supplier = new Supplier();
    private String tanggal;
    private int jumlahBarang;

    public int getIdBarangMasuk() {
        return idBarangMasuk;
    }

    public void setIdBarangMasuk(int idBarangMasuk) {
        this.idBarangMasuk = idBarangMasuk;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    
    public BarangMasuk(){}
    
    public BarangMasuk(Barang barang, Supplier supplier, String tanggal, int jumlahBarang){
        this.barang = barang;
        this.supplier = supplier;
        this.tanggal = tanggal;
        this.jumlahBarang = jumlahBarang;
    }
    
    public BarangMasuk getById(int id){
        BarangMasuk barmas = new BarangMasuk();
        ResultSet rs = Helper.selectQuery("SELECT a.idmasuk AS idmasuk, a.idbarang AS idbarang, b.stock AS stock, a.idsupplier AS idsupplier, b.idsatuan AS idsatuan, a.tanggal AS tanggal, a.jumlahbarang AS jumlahbarang, b.namabarang AS namabarang, b.harga AS harga, b.keterangan AS keterangan, d.namasupplier AS namasupplier, d.perusahaansupplier AS perusahaansupplier, d.alamatperusahaan AS alamatperusahaan, d.teleponeperusahaan AS teleponeperusahaan, c.namasatuan AS namasatuan FROM tb_barangmasuk a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan LEFT JOIN tb_supplier d ON a.idsupplier = d.idsupplier WHERE a.idmasuk = '"+ id +"'");
        
        try{
            while(rs.next()){
                barmas = new BarangMasuk();
                barmas.setIdBarangMasuk(rs.getInt("idmasuk"));
                barmas.setTanggal(rs.getString("tanggal"));
                barmas.setJumlahBarang(rs.getInt("jumlahbarang"));
                barmas.getBarang().setIdBarang(rs.getInt("idbarang"));
                barmas.getBarang().setNamaBarang(rs.getString("namabarang"));
                barmas.getBarang().setKeterangan("keterangan");
                barmas.getBarang().setHargaBarang(rs.getInt("harga"));
                barmas.getBarang().setStock(rs.getInt("stock"));
                barmas.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                barmas.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                barmas.getSupplier().setIdSupplier(rs.getInt("idsupplier"));
                barmas.getSupplier().setNamaSupplier(rs.getString("namasupplier"));
                barmas.getSupplier().setPerusahaanSupplier(rs.getString("perusahaansupplier"));
                barmas.getSupplier().setAlamatPerusahaan(rs.getString("alamatperusahaan"));
                barmas.getSupplier().setTeleponePerusahaan(rs.getString("teleponeperusahaan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barmas;
    }
    
    public ArrayList<BarangMasuk> getAll(){
        ArrayList<BarangMasuk> ListBarangMasuk = new ArrayList();
        ResultSet rs = Helper.selectQuery("SELECT a.idmasuk AS idmasuk, a.idbarang AS idbarang, b.stock AS stock, a.idsupplier AS idsupplier, b.idsatuan AS idsatuan, a.tanggal AS tanggal, a.jumlahbarang AS jumlahbarang, b.namabarang AS namabarang, b.harga AS harga, b.keterangan AS keterangan, d.namasupplier AS namasupplier, d.perusahaansupplier AS perusahaansupplier, d.alamatperusahaan AS alamatperusahaan, d.teleponeperusahaan AS teleponeperusahaan, c.namasatuan AS namasatuan FROM tb_barangmasuk a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan LEFT JOIN tb_supplier d ON a.idsupplier = d.idsupplier ");
        
        try{
            while(rs.next()){
                BarangMasuk barmas = new BarangMasuk();
                barmas.setIdBarangMasuk(rs.getInt("idmasuk"));
                barmas.setTanggal(rs.getString("tanggal"));
                barmas.setJumlahBarang(rs.getInt("jumlahbarang"));
                barmas.getBarang().setIdBarang(rs.getInt("idbarang"));
                barmas.getBarang().setNamaBarang(rs.getString("namabarang"));
                barmas.getBarang().setKeterangan("keterangan");
                barmas.getBarang().setHargaBarang(rs.getInt("harga"));
                barmas.getBarang().setStock(rs.getInt("stock"));
                barmas.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                barmas.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                barmas.getSupplier().setIdSupplier(rs.getInt("idsupplier"));
                barmas.getSupplier().setNamaSupplier(rs.getString("namasupplier"));
                barmas.getSupplier().setPerusahaanSupplier(rs.getString("perusahaansupplier"));
                barmas.getSupplier().setAlamatPerusahaan(rs.getString("alamatperusahaan"));
                barmas.getSupplier().setTeleponePerusahaan(rs.getString("teleponeperusahaan"));
                
                ListBarangMasuk.add(barmas);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListBarangMasuk;
    }
    
    public ArrayList<BarangMasuk> search(String keyword){
        ArrayList<BarangMasuk> ListBarangMasuk = new ArrayList();
        String sql = "SELECT a.idmasuk AS idmasuk, a.idbarang AS idbarang, a.idsupplier AS idsupplier, b.stock AS stock, b.idsatuan AS idsatuan, a.tanggal AS tanggal, a.jumlahbarang AS jumlahbarang, b.namabarang AS namabarang, b.harga AS harga, b.keterangan AS keterangan, d.namasupplier AS namasupplier, d.perusahaansupplier AS perusahaansupplier, d.alamatperusahaan AS alamatperusahaan, d.teleponeperusahaan AS teleponeperusahaan, c.namasatuan AS namasatuan FROM tb_barangmasuk a LEFT JOIN tb_barang b ON a.idbarang = b.idbarang LEFT JOIN tb_satuan c ON b.idsatuan = c.idsatuan LEFT JOIN tb_supplier d ON a.idsupplier = d.idsupplier WHERE namabarang LIKE '%"+ keyword +"%'";
        ResultSet rs = Helper.selectQuery(sql);
        
        try{
            while(rs.next()){
                BarangMasuk barmas = new BarangMasuk();
                barmas.setIdBarangMasuk(rs.getInt("idmasuk"));
                barmas.setTanggal(rs.getString("tanggal"));
                barmas.setJumlahBarang(rs.getInt("jumlahbarang"));
                barmas.getBarang().setIdBarang(rs.getInt("idbarang"));
                barmas.getBarang().setNamaBarang(rs.getString("namabarang"));
                barmas.getBarang().setKeterangan("keterangan");
                barmas.getBarang().setHargaBarang(rs.getInt("harga"));
                barmas.getBarang().setStock(rs.getInt("stock"));
                barmas.getBarang().getSatuan().setIdSatuan(rs.getInt("idsatuan"));
                barmas.getBarang().getSatuan().setNamaSatuan(rs.getString("namasatuan"));
                barmas.getSupplier().setIdSupplier(rs.getInt("idsupplier"));
                barmas.getSupplier().setNamaSupplier(rs.getString("namasupplier"));
                barmas.getSupplier().setPerusahaanSupplier(rs.getString("perusahaansupplier"));
                barmas.getSupplier().setAlamatPerusahaan(rs.getString("alamatperusahaan"));
                barmas.getSupplier().setTeleponePerusahaan(rs.getString("teleponeperusahaan"));
                
                ListBarangMasuk.add(barmas);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListBarangMasuk;
    }
    
    public void save(){
        if(getById(idBarangMasuk).getIdBarangMasuk() == 0){
            String SQL = "INSERT INTO tb_barangmasuk (idbarang, idsupplier, tanggal, jumlahbarang) VALUES ("
                    +"'"+this.getBarang().getIdBarang()+"',"
                    +"'"+this.getSupplier().getIdSupplier()+"',"
                    +"'"+this.tanggal+"',"
                    +"'"+this.jumlahBarang+"')";
            this.idBarangMasuk = Helper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE tb_barangmasuk SET "
                    +" idbarang = '"+this.getBarang().getIdBarang()+"', "
                    +" idsupplier = '"+this.getSupplier().getIdSupplier()+"', "
                    +" tanggal = '"+this.tanggal+"', "
                    +" jumlahbarang = '"+this.jumlahBarang+"' "
                    +" WHERE idmasuk = '"+this.idBarangMasuk+"'";
            Helper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM tb_barangmasuk WHERE idmasuk = '"+this.idBarangMasuk+"'";
        Helper.executeQuery(SQL);
    }
}
