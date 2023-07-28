package br.com.leonhartdelivery.methods;

public class AnalisadorCep {
    public String analisaCep(String cepDigitado) {
        String cepVerificado = cepDigitado.replaceAll("[^0-9]+","");
        if (cepVerificado.length() != 8) {
            return "00000000";
        } else {
            return cepVerificado;
        }
    };
}
