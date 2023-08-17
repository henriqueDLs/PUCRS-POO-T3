import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEDados {
    private Scanner entrada = new Scanner(System.in);
    private Dados d1 = new Dados();

    public void executa() {
        int opcao=0;
        do {
            menu();
            try{
                opcao = entrada.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Valor invalido, diferente tipo de dado esperado!");
                return;
            }
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    carregarDados();
                    break;
                case 2:
                    classificarDadosNome();
                    break;
                case 3:
                    consultarDadosTodos();
                    break;
                case 4:
                    consultarDadosNomeIn();
                    break;
                case 5:
                    salvarDadosCon();
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
        while (opcao != 0);
    }

    private void menu() {
        System.out.println("=======================");
        System.out.println("Opcoes:");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Carregar dados abertos");
        System.out.println("[2] Classificar dados por nome");
        System.out.println("[3] Consultar todos os dados");
        System.out.println("[4] Consultar dados de um nome incompleto");
        System.out.println("[5] Salvar os dados de consulta em arquivo");
    }

    private void carregarDados(){
        System.out.println("Digite o nome do arquivo: ");
        String nome = "";
        try{
            nome = "" + entrada.nextLine() + ".csv";
        }
        catch (InputMismatchException e){
            System.out.println("Valor invalido, diferente tipo de dado esperado!");
            carregarDados();
        }
        d1.carregarDados(nome);
        if(!d1.carregarDados(nome)){
            System.out.println("Erro! Formato de dados incompativel!");
            return;
        }
        System.out.println("Dados carregados com sucesso!");
    }

    private void classificarDadosNome(){
        if(d1.getTotalDados().isEmpty()){
            System.out.println("Erro! Dados nao carregados!");
            return;
        }
        System.out.println("Deseja classificar os dados em crescente ou decrescente? [1] Crescente [2] Decrescente");
        int opcao = 0;
        try{
            opcao = entrada.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Valor invalido, diferente tipo de dado esperado!");
            System.out.println();
            classificarDadosNome();
        }
        if(opcao != 1 && opcao != 2){
            System.out.println("Opcao invalida! Tente novamente");
            System.out.println();
            classificarDadosNome();
        }
        else{d1.classificarDadosNome(opcao);
            System.out.println("Dados classificados!");}
    }

    private void consultarDadosTodos(){
        if(d1.getTotalDados().isEmpty()){
            System.out.println("Erro! Dados nao carregados!");
            return;
        }
        d1.organizarDados();
        for(Dados d:d1.getTotalDados()){
            System.out.println("==========================================");
            System.out.println("Municipio: " + d.getMunicipio());
            System.out.println("IBGE: " + d.getIbge());
            System.out.println("Latitude:" + d.getLatitude());
            System.out.println("Longitude: " + d.getLongitude());
            System.out.println("Taxa de mortalidade Materna 2010: " + d.getTaxaMortalidadeM2010());
            System.out.println("Taxa de mortalidade Materna 2011: " + d.getTaxaMortalidadeM2011());
            System.out.println("Taxa de mortalidade Materna 2012: " + d.getTaxaMortalidadeM2012());
            System.out.println("Taxa de mortalidade Materna 2013: " + d.getTaxaMortalidadeM2013());
            System.out.println("Taxa de mortalidade Materna 2014: " + d.getTaxaMortalidadeM2014());
            System.out.println("Taxa de mortalidade Materna 2015: " + d.getTaxaMortalidadeM2015());
            System.out.println("Taxa de mortalidade Materna 2016: " + d.getTaxaMortalidadeM2016());
            System.out.println("Taxa de mortalidade Materna 2017: " + d.getTaxaMortalidadeM2017());
            System.out.println("Taxa de mortalidade Materna 2018: " + d.getTaxaMortalidadeM2018());
            System.out.println("Taxa de mortalidade Materna 2019: " + d.getTaxaMortalidadeM2019());
            System.out.println("Taxa de mortalidade Materna 2020: " + d.getTaxaMortalidadeM2020());
        }
    }

    private void consultarDadosNomeIn(){
        if(d1.getTotalDados().isEmpty()){
            System.out.println("Erro! Dados nao carregados!");
            return;
        }
        System.out.println("Digite um nome incompleto para consulta: ");
        String nome = "";
        try{
            nome = entrada.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Nome invalido, diferente tipo de dado esperado!");
            System.out.println();
            consultarDadosNomeIn();
        }
        ArrayList<Dados> todosDadosNomes = d1.pesquisarDadosNomeIn(nome);
        if(todosDadosNomes.isEmpty()) {
            System.out.println("Erro! Nao foram encontrado dados com este nome!");
        }
        for(Dados d:todosDadosNomes){
            System.out.println("==========================================");
            System.out.println("Municipio: " + d.getMunicipio());
            System.out.println("IBGE: " + d.getIbge());
            System.out.println("Latitude:" + d.getLatitude());
            System.out.println("Longitude: " + d.getLongitude());
            System.out.println("Taxa de mortalidade Materna 2010: " + d.getTaxaMortalidadeM2010());
            System.out.println("Taxa de mortalidade Materna 2011: " + d.getTaxaMortalidadeM2011());
            System.out.println("Taxa de mortalidade Materna 2012: " + d.getTaxaMortalidadeM2012());
            System.out.println("Taxa de mortalidade Materna 2013: " + d.getTaxaMortalidadeM2013());
            System.out.println("Taxa de mortalidade Materna 2014: " + d.getTaxaMortalidadeM2014());
            System.out.println("Taxa de mortalidade Materna 2015: " + d.getTaxaMortalidadeM2015());
            System.out.println("Taxa de mortalidade Materna 2016: " + d.getTaxaMortalidadeM2016());
            System.out.println("Taxa de mortalidade Materna 2017: " + d.getTaxaMortalidadeM2017());
            System.out.println("Taxa de mortalidade Materna 2018: " + d.getTaxaMortalidadeM2018());
            System.out.println("Taxa de mortalidade Materna 2019: " + d.getTaxaMortalidadeM2019());
            System.out.println("Taxa de mortalidade Materna 2020: " + d.getTaxaMortalidadeM2020());
        }
    }

    private void salvarDadosCon(){
        String nomeArquivo = "";
        System.out.println("Digite o nome do arquivo para salvar a consulta: ");
        try{
            nomeArquivo = entrada.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Nome invalido, diferente tipo de dado esperado!");
            System.out.println();
            salvarDadosCon();
        }
        if(!d1.salvarConsulta(nomeArquivo)){
            System.out.println("Erro! Nao ha dados para serem salvos!");
        }
        d1.salvarConsulta(nomeArquivo);
    }
}
