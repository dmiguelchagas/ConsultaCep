package br.com.leonhartdelivery.models;

public class Cep {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private int ibge;
    private int ddd;
    private int siaf;

    public Cep () {

    }

    public Cep (CepJson meuCepJson) {
        if (meuCepJson.cep() != null) {
            this.cep = meuCepJson.cep();
        } else {
            this.cep = "Não Localizado.";
        }
        if (meuCepJson.logradouro() != null) {
            this.logradouro = meuCepJson.logradouro();
        } else {
            this.logradouro = "Não localizado.";
        }
        if (meuCepJson.complemento() != null) {
            this.complemento = meuCepJson.complemento();
        } else {
            this.complemento = "Não localizado.";
        }
        if (meuCepJson.bairro() != null) {
            this.bairro = meuCepJson.bairro();
        } else {
            this.bairro = "Não localizado";
        }
        if (meuCepJson.localidade() != null) {
            this.localidade = meuCepJson.localidade();
        } else {
            this.localidade = "Não localizada.";
        }
        if (meuCepJson.uf() != null) {
            this.uf = meuCepJson.uf();
        } else {
            this.uf = "Não localizada.";
        }
        if (meuCepJson.ibge() != null) {
            this.ibge = Integer.valueOf(meuCepJson.ibge());
        } else {
            this.ibge = 0;
        }
        if (meuCepJson.ddd() != null) {
            this.ddd = Integer.valueOf(meuCepJson.ddd());
        } else {
            this.ddd = 00;
        }
        if (meuCepJson.siafi() != null) {
            this.siaf = Integer.valueOf(meuCepJson.siafi());
        } else {
            this.siaf = 0;
        }

    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public int getIbge() {
        return ibge;
    }

    public int getDdd() {
        return ddd;
    }

    public int getSiaf() {
        return siaf;
    }

    @Override
    public String toString() {
        return """
                CEP: %s
                Logradouro: %s
                Complemento: %s
                Bairro: %s
                Localidade: %s
                UF: %s
                IBGE: %d
                DDD: %d
                SIAF: %d
                """.formatted(cep, logradouro, complemento, bairro, localidade, uf, ibge, ddd, siaf);
    }
}