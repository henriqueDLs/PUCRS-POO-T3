import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;

public class Dados implements Comparable<Dados>{
    private ArrayList<Dados> totalDados;
    private String conteudo;
    private String municipio;
    private String ibge;
    private String latitude;
    private String longitude;
    private String taxaMortalidadeM2010,taxaMortalidadeM2011,taxaMortalidadeM2012,taxaMortalidadeM2013,taxaMortalidadeM2014,taxaMortalidadeM2015,taxaMortalidadeM2016,taxaMortalidadeM2017,taxaMortalidadeM2018,taxaMortalidadeM2019,taxaMortalidadeM2020;

    public Dados(){
        totalDados = new ArrayList<>();
    }

    public Dados(String conteudo){
        this.conteudo = conteudo;
    }

    public boolean carregarDados(String nomeArquivo){
        try{
            totalDados.clear();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo),"ISO-8859-1"));
            String linha = "";
            br.readLine();
            while((linha = br.readLine()) != null){
                linha = Normalizer.normalize(linha, Normalizer.Form.NFKD);
                linha = linha.replaceAll("[^\\p{ASCII}]", "");
                Dados d1 = new Dados(linha);
                totalDados.add(d1);
            }
            br.close();
        }
        catch(IOException e){
            return false;
        }
        return true;
    }

    public void classificarDadosNome(int opcao){
        Collections.sort(totalDados);
        if(opcao == 2){
            Collections.reverse(totalDados);
        }
    }

    public void organizarDados(){
        String[] conteudoDados;
        for(Dados d:totalDados){
            conteudoDados = d.getConteudo().split(",",0);
            d.setMunicipio(conteudoDados[0]);
            d.setIbge(conteudoDados[1]);
            d.setLatitude(conteudoDados[2]);
            d.setLongitude(conteudoDados[3]);
            d.setTaxaMortalidadeM2010(conteudoDados[4]);
            d.setTaxaMortalidadeM2011(conteudoDados[5]);
            d.setTaxaMortalidadeM2012(conteudoDados[6]);
            d.setTaxaMortalidadeM2013(conteudoDados[7]);
            d.setTaxaMortalidadeM2014(conteudoDados[8]);
            d.setTaxaMortalidadeM2015(conteudoDados[9]);
            d.setTaxaMortalidadeM2016(conteudoDados[10]);
            d.setTaxaMortalidadeM2017(conteudoDados[11]);
            d.setTaxaMortalidadeM2018(conteudoDados[12]);
            d.setTaxaMortalidadeM2019(conteudoDados[13]);
            d.setTaxaMortalidadeM2020(conteudoDados[14]);
        }
    }

    public ArrayList<Dados> pesquisarDadosNomeIn(String nome){
        organizarDados();
        ArrayList<Dados> todosDadosNome = new ArrayList<>();
        for (Dados d1 : totalDados) {
            if (d1.getMunicipio().contains(nome)) {
                todosDadosNome.add(d1);
            }
        }
        if(!todosDadosNome.isEmpty()){
            totalDados = todosDadosNome;
        }
        return todosDadosNome;
    }

    public boolean salvarConsulta(String nomeArquivo){
        String linha = "";
        if(totalDados.isEmpty()){
            return false;
        }
        try {
            FileWriter fw = new FileWriter("" + nomeArquivo + ".csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Dados d : totalDados) {
                linha = d.conteudo;
                bw.write(linha);
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e){
            System.err.println("Erro: " + e);
            return false;
        }
        return true;
    }

    public int compareTo(Dados d) {
        if (!this.conteudo.equalsIgnoreCase(d.conteudo))
            return this.conteudo.compareTo(d.conteudo);
        return 0;
    }
    
    public ArrayList<Dados> getTotalDados(){
        return totalDados;
    }

    public String getConteudo(){
        return conteudo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getIbge() {
        return ibge;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getTaxaMortalidadeM2010() {
        return taxaMortalidadeM2010;
    }

    public String getTaxaMortalidadeM2011() {
        return taxaMortalidadeM2011;
    }

    public String getTaxaMortalidadeM2012() {
        return taxaMortalidadeM2012;
    }

    public String getTaxaMortalidadeM2013() {
        return taxaMortalidadeM2013;
    }

    public String getTaxaMortalidadeM2014() {
        return taxaMortalidadeM2014;
    }

    public String getTaxaMortalidadeM2015() {
        return taxaMortalidadeM2015;
    }

    public String getTaxaMortalidadeM2016() {
        return taxaMortalidadeM2016;
    }

    public String getTaxaMortalidadeM2017() {
        return taxaMortalidadeM2017;
    }

    public String getTaxaMortalidadeM2018() {
        return taxaMortalidadeM2018;
    }

    public String getTaxaMortalidadeM2019() {
        return taxaMortalidadeM2019;
    }

    public String getTaxaMortalidadeM2020() {
        return taxaMortalidadeM2020;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setTaxaMortalidadeM2010(String taxaMortalidadeM2010) {
        this.taxaMortalidadeM2010 = taxaMortalidadeM2010;
    }

    public void setTaxaMortalidadeM2011(String taxaMortalidadeM2011) {
        this.taxaMortalidadeM2011 = taxaMortalidadeM2011;
    }

    public void setTaxaMortalidadeM2012(String taxaMortalidadeM2012) {
        this.taxaMortalidadeM2012 = taxaMortalidadeM2012;
    }

    public void setTaxaMortalidadeM2013(String taxaMortalidadeM2013) {
        this.taxaMortalidadeM2013 = taxaMortalidadeM2013;
    }

    public void setTaxaMortalidadeM2014(String taxaMortalidadeM2014) {
        this.taxaMortalidadeM2014 = taxaMortalidadeM2014;
    }

    public void setTaxaMortalidadeM2015(String taxaMortalidadeM2015) {
        this.taxaMortalidadeM2015 = taxaMortalidadeM2015;
    }

    public void setTaxaMortalidadeM2016(String taxaMortalidadeM2016) {
        this.taxaMortalidadeM2016 = taxaMortalidadeM2016;
    }

    public void setTaxaMortalidadeM2017(String taxaMortalidadeM2017) {
        this.taxaMortalidadeM2017 = taxaMortalidadeM2017;
    }

    public void setTaxaMortalidadeM2018(String taxaMortalidadeM2018) {
        this.taxaMortalidadeM2018 = taxaMortalidadeM2018;
    }

    public void setTaxaMortalidadeM2019(String taxaMortalidadeM2019) {
        this.taxaMortalidadeM2019 = taxaMortalidadeM2019;
    }

    public void setTaxaMortalidadeM2020(String taxaMortalidadeM2020) {
        this.taxaMortalidadeM2020 = taxaMortalidadeM2020;
    }
}
