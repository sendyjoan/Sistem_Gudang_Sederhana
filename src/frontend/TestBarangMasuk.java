/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author EA4618JO
 */
import backend.*;

public class TestBarangMasuk {
    public static void main(String[] args){
        Barang brg1 = new Barang().getById(1);
        Barang brg2 = new Barang().getById(2);

        Supplier sup1 = new Supplier().getById(1);
        Supplier sup2 = new Supplier().getById(2);

        BarangMasuk bar1 = new BarangMasuk(brg1, sup2, "2021-12-18", 10);
        BarangMasuk bar2 = new BarangMasuk(brg2, sup1, "2021-12-18", 15);
       
        bar1.save();
        bar2.save();
        
        bar2.setTanggal("2019-10-10");
        bar2.save();
        
        bar2.setTanggal("2020-1-1");
        int idbrg = bar2.getBarang().getIdBarang();
        Barang brgedit = new Barang().getById(idbrg);
        brgedit.setStock(brgedit.getStock() + bar1.getJumlahBarang());
        brgedit.save();
        bar2.save();
      
        // Test Select All
        for(BarangMasuk b : new BarangMasuk().getAll()){
            System.out.println("Id         : "+b.getIdBarangMasuk());
            System.out.println("Id Brg     : "+b.getBarang().getIdBarang());
            System.out.println("Id Sup     : "+b.getSupplier().getIdSupplier());
            System.out.println("Tanggal    : "+b.getTanggal());
            System.out.println("Tanggal    : "+b.getBarang().getStock());
            System.out.println("Jml Barang : "+b.getJumlahBarang());
        }
        
        //Test Search
        for(BarangMasuk b : new BarangMasuk().search("m")){
            System.out.println("Id         : "+b.getIdBarangMasuk());
            System.out.println("Id Brg     : "+b.getBarang().getIdBarang());
            System.out.println("Id Sup     : "+b.getSupplier().getIdSupplier());
            System.out.println("Tanggal    : "+b.getTanggal());
            System.out.println("Jml Barang : "+b.getJumlahBarang());
        }
    }   
}
