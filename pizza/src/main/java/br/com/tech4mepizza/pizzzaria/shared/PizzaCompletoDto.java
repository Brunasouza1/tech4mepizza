package br.com.tech4mepizza.pizzzaria.shared;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("pizzascompleto")
public class PizzaCompletoDto {
    private String id;
    private String sabor;
    private List<String> ingredientes;
    private String tamanho;
    private double valor;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSabor() {
        return sabor;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public List<String> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
