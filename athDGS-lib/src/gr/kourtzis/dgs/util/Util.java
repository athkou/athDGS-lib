/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akourtzis
 */
public class Util {
    /**
     * The method generates the SHA256 hash of a password.
     * @param input A String variable containing a password in plain text.
     * @return An encrypted String.
     */
    public static String createPassword(final String input) {
        StringBuffer result = null;
       
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            result = new StringBuffer();
            for (byte byt : hash) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
            
            
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  result.toString();
    }
}
