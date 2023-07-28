package br.com.leonhartdelivery.models;

public record CepJson(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
                      String ibge, String ddd, String siafi) {
}
