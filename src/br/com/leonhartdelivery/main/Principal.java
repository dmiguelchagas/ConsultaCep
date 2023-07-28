package br.com.leonhartdelivery.main;

import br.com.leonhartdelivery.methods.AnalisadorCep;
import br.com.leonhartdelivery.methods.EscritorDeConsultas;
import br.com.leonhartdelivery.methods.HttpCommunication;
import br.com.leonhartdelivery.models.Cep;
import br.com.leonhartdelivery.models.CepJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main (String[] args) throws IOException, InterruptedException {

        //Criação de Objetos para execução de Métodos
        AnalisadorCep testaCep = new AnalisadorCep();
        HttpCommunication conectaApi = new HttpCommunication();
        EscritorDeConsultas geraLista = new EscritorDeConsultas();

        //Criação de Variáveis da Aplicação
        String json = "";
        int menuOpcao = 0;

        //Criação do Objeto Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Criação da Lista de CEPs consultados
        List cepsConsultados = new ArrayList<>();

        //Criação do loop de execução da aplicação
        while (menuOpcao != 2) {

            System.out.println("Digite 1 para Pesquisar um CEP, ou 2 para SAIR:");
            Scanner menu = new Scanner(System.in);

            //Criação da validação da opção digitada
            while (!menu.hasNextInt()) {
                System.out.println("Opção inválida. Verifique as opções novamente.\nDigite 1 para Pesquisar um CEP, ou 2 para SAIR:");
                menu = new Scanner(System.in);
            }
            menuOpcao = menu.nextInt();

            //Criação do menu da aplicação
            switch (menuOpcao) {
                case 1:
                    System.out.println("Digite o número do CEP que deseja pesquisar:");
                    Scanner cepCapture = new Scanner(System.in);
                    String cepSearch = testaCep.analisaCep(cepCapture.nextLine());

                    json = conectaApi.geraConteudoJson(cepSearch);

                    CepJson meuCepJson = gson.fromJson(json, CepJson.class);
                    Cep meuCep = new Cep(meuCepJson);

                    System.out.println(meuCep);

                    cepsConsultados.add(meuCep);

                    break;

                case 2:
                    break;

                default:
                    System.out.println("Opção inválida. Digite uma das opções conforme o MENU:");
                    break;
            }
        }
        geraLista.escreveListaConsultada(cepsConsultados);
    }
}
