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

public class TestStock {
    public static void main(String[] args){
//        Barang brg1 = new Barang().getById(1);
//        Barang brg2 = new Barang().getById(2);
//        
//        Stock stc1 = new Stock(brg1, 10);
//        Stock stc2 = new Stock(brg2, 10);
//        
//        stc1.save();
//        stc2.save();
//        
//        stc2.setJumlahStock(15);
//        stc2.save();
        
        // Test Select All
        for(Stock s : new Stock().getAll()){
            System.out.println("Id Stock     : "+s.getIdStock());
            System.out.println("Id Barang    : "+s.getBarang().getIdBarang());
            System.out.println("Jumlah Stock : "+s.getJumlahStock());
            System.out.println("Nama Barang  : "+s.getBarang().getNamaBarang());
        }
        
        //Test Search
        for(Stock s : new Stock().search("m")){
            System.out.println("Id Stock     : "+s.getIdStock());
            System.out.println("Id Barang    : "+s.getBarang().getIdBarang());
            System.out.println("Jumlah Stock : "+s.getJumlahStock());
        }
    }
}
