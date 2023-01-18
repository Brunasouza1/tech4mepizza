package br.com.tech4mepizza.pizzzaria.shared;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



public class PizzaCompletoDto {
    private String id;
    @NotEmpty(message="informe esté compo está em branco")
    @NotBlank(message="tem que informar os caracteres")
    private String sabor;
    private List<String> ingredientes;
    @Size(min=3,max =3,message = "infirme peg,mde,grd ou gig")
    private String tamanho;
    @Positive(message="valor deve ser informado")
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
