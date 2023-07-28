package br.com.leonhartdelivery.methods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorDeConsultas {
    public void escreveListaConsultada (List cepsConsultados) throws IOException {
        FileWriter escrita = new FileWriter("CEPs.json");
        escrita.write(cepsConsultados.toString());
        escrita.close();
    }
}
