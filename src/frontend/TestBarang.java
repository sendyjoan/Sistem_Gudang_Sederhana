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

public class TestBarang {
    public static void main(String[] args){
        Satuan kode1 = new Satuan().getById(1);
        Satuan kode2 = new Satuan().getById(2);
        
        Barang bar1 = new Barang("Shampo", 20000, 10, kode1, "Shampo untuk keramas");
        Barang bar2 = new Barang("Sabun", 5000, 11, kode2, "Sabun untuk mandi");
        Barang bar3 = new Barang("Odol", 7000, 12, kode2, "Odol untuk gosok gigi");
        
        // Test Insert
        bar1.save();
        bar2.save();
//        bar3.save();
        
        // Test Update
        bar2.setKeterangan("Sabun ini digunakan untuk mandi");
        bar2.setStock(15);
        bar2.save();
        
        // Test Select All
        for(Barang b : new Barang().getAll()){
            System.out.println("Id      : "+b.getIdBarang());
            System.out.println("Nama    : "+b.getNamaBarang());
            System.out.println("Harga   : "+b.getHargaBarang());
            System.out.println("Ket     : "+b.getKeterangan());
        }
        
        //Test Search
        for(Barang b : new Barang().search("m")){
            System.out.println("Id      : "+b.getIdBarang());
            System.out.println("Nama    : "+b.getNamaBarang());
            System.out.println("Harga   : "+b.getHargaBarang());
            System.out.println("Ket     : "+b.getKeterangan());
        }
    }
}
