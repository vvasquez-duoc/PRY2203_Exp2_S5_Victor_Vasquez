package com.jugueteria.utilitarios;

import java.text.NumberFormat;
import java.util.Locale;

public class Utilitarios {
    public static void limpiaPantalla(){
        for(int i=0; i<30; i++){
            System.out.println("");
        }
    }
    
    public static String formateaMonto(int monto) {
        NumberFormat formato = NumberFormat.getInstance(new Locale("es", "CL"));
        formato.setGroupingUsed(true);
        
        return formato.format(monto);
    }
}