/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5P1;

/**
 *
 * @author Asus
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class MailListReader {
    
    public List<String> read(String fileName) {
        List<String> mails = new ArrayList<>();
        String cadena;
        
        try (FileReader f = new FileReader(fileName);
                BufferedReader b = new BufferedReader(f)) {
            while((cadena = b.readLine())!=null) {
                int arroba = cadena.indexOf('@');
                if ( arroba != -1){
                    mails.add(cadena);
                }
                
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return mails;
    }
    
}