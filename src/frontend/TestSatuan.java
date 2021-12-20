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

public class TestSatuan {
    public static void main(String[] args){
        Satuan sat1 = new Satuan("Karton");
        Satuan sat2 = new Satuan("Kardus");
        Satuan sat3 = new Satuan("Galon");
        
        // Test Insert
        sat1.save();
        sat2.save();
        sat3.save();
        
        // Test Update
        sat1.setNamaSatuan("Butir");
        sat1.save();
        
        //Test Download
        sat2.delete();
        
        // Test Select All
        for(Satuan s : new Satuan().getAll()){
            System.out.println("Id = "+s.getIdSatuan()+" Nama = "+s.getNamaSatuan());
        }
        
        //Test Search
        for(Satuan s : new Satuan().search("n")){
            System.out.println("Id = "+s.getIdSatuan()+" Nama = "+s.getNamaSatuan());
        }
    }
}
