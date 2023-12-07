package Model;

public class Vendas {

    private String data;
    private double precoTotal;
    private String comprador;
    private String colaborador;
    private int numVenda;
    
    
    public Vendas(String data, double precoTotal, String comprador, String colaborador, int numVenda) {
        this.data = data;
        this.precoTotal = precoTotal;
        this.comprador = comprador;
        this.colaborador = colaborador;
        this.numVenda = numVenda;
    }


    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }


    public double getPrecoTotal() {
        return precoTotal;
    }


    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }


    public String getComprador() {
        return comprador;
    }


    public void setComprador(String comprador) {
        this.comprador = comprador;
    }


    public String getColaborador() {
        return colaborador;
    }


    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }


    public int getNumVenda() {
        return numVenda;
    }


    public void setNumVenda(int numVenda) {
        this.numVenda = numVenda;
    }

    
    



    



    
}
