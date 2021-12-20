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

public class TestSupplier {
    public static void main(String[] args){
        Supplier sup1 = new Supplier("Andiyanto", "PT. Gelora", "Surabaya", "089675456987");
        Supplier sup2 = new Supplier("Lukman Arif", "PT. Sinramas", "Jakarta", "089123653123");
        Supplier sup3 = new Supplier("Intan Pra", "PT. Indah Jara", "Bandung", "086345876286");
        
        sup1.save();
        sup2.save();
        sup3.save();
        
        sup1.setPerusahaanSupplier("Diedit");
        sup1.save();
        
        sup2.delete();
        
        // Test Select All
        for(Supplier s : new Supplier().getAll()){
            System.out.println("Id = "+s.getIdSupplier());
            System.out.println("Nama = "+s.getNamaSupplier());            
            System.out.println("Perusahaan = "+s.getPerusahaanSupplier());        
            System.out.println("Alamat = "+s.getAlamatPerusahaan());        
            System.out.println("Telephone = "+s.getTeleponePerusahaan());            
            System.out.println();            
        }
        
        //Test Search
        for(Supplier s : new Supplier().search("o")){
            System.out.println("Id = "+s.getIdSupplier());
            System.out.println("Nama = "+s.getNamaSupplier());            
            System.out.println("Perusahaan = "+s.getPerusahaanSupplier());        
            System.out.println("Alamat = "+s.getAlamatPerusahaan());        
            System.out.println("Telephone = "+s.getTeleponePerusahaan());            
            System.out.println(); 
        }
    }
}
