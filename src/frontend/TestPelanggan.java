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

public class TestPelanggan {
    public static void main(String[] args){
        Pelanggan pel1 = new Pelanggan("Antonio", "082244767431", "Malang");
        Pelanggan pel2 = new Pelanggan("Guterez", "086754546788", "Surabaya");
        Pelanggan pel3 = new Pelanggan("Imam Gho", "085700633029", "Bondowoso");
        
        pel1.save();
        pel2.save();
        pel3.save();
        
        pel1.setNoTelepone("Terganti");
        pel1.save();
        
        pel2.delete();
        
        // Test Select All
        for(Pelanggan p : new Pelanggan().getAll()){
            System.out.println("Id = "+p.getIdPelanggan());
            System.out.println("Nama = "+p.getNamaPelanggan());            
            System.out.println("Nomor = "+p.getNoTelepone());            
            System.out.println("Alamat = "+p.getAlamat());            
            System.out.println();            
        }
        
        //Test Search
        for(Pelanggan p : new Pelanggan().search("o")){
            System.out.println("Id = "+p.getIdPelanggan());
            System.out.println("Nama = "+p.getNamaPelanggan());            
            System.out.println("Nomor = "+p.getNoTelepone());            
            System.out.println("Alamat = "+p.getAlamat());            
            System.out.println();
        }
    }
}
