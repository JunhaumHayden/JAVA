package com.github.hayden.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class AssumptionsTeste {

    @Test
    void deveExecutarApenasNoUsuarioRoot() {
        Assumptions.assumeFalse("root".equals(System.getenv("USER")));
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    void deveExecutarApenasNoWindows() {
        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Windows"), 
            "Teste ignorado: não está rodando no Windows.");

        // Código específico para Windows
        System.out.println("Executando no Windows!");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void deveExecutarApenasNoMac() {

        // Código específico para Linux
        Assertions.assertEquals(10, 5 + 5);
        System.out.println("Executando no Mac OS!");
    }

    //Utilizando arrey
    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void deveExecutarApenasNosItensDaLista() {

        // Código específico para Linux
        Assertions.assertEquals(10, 5 + 5);
        System.out.println("Executando no Linux!");
    }

    
}
