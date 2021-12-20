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

public class TestBarangKeluar {
    public static void main(String[] args){
        Pelanggan pel1 = new Pelanggan().getById(1);
        Pelanggan pel2 = new Pelanggan().getById(2);
        
        Barang brg1 = new Barang().getById(1);
        Barang brg2 = new Barang().getById(2);
        
        BarangKeluar barkel1 = new BarangKeluar(brg1, pel2, "2021-10-10", 10);
        BarangKeluar barkel2 = new BarangKeluar(brg2, pel1, "2021-10-10", 5);
        
        barkel1.save();
        barkel2.save();
        
        barkel1.setTanggal("2019-10-10");
        barkel1.save();
        
        // Test Select All
        for(BarangKeluar b : new BarangKeluar().getAll()){
            System.out.println("Id         : "+b.getIdKeluar());
            System.out.println("Id Brg     : "+b.getBarang().getIdBarang());
            System.out.println("Id Sup     : "+b.getPelanggan().getIdPelanggan());
            System.out.println("Tanggal    : "+b.getTanggal());
            System.out.println("Tanggal    : "+b.getBarang().getStock());
            System.out.println("Jml Barang : "+b.getJumlahBarang());
        }
        
        //Test Search
        for(BarangKeluar b : new BarangKeluar().search("m")){
            System.out.println("Id         : "+b.getIdKeluar());
            System.out.println("Id Brg     : "+b.getBarang().getIdBarang());
            System.out.println("Id Sup     : "+b.getPelanggan().getIdPelanggan());
            System.out.println("Tanggal    : "+b.getTanggal());
            System.out.println("Tanggal    : "+b.getBarang().getStock());
            System.out.println("Jml Barang : "+b.getJumlahBarang());
        }
    }
}
