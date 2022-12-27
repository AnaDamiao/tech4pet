package br.com.tech4me.tech4pet.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("petshop")
public class PetShop {
    @Id
    private String id;
    private String nome;
    private String raca;
    private int anoNascimento;
    private boolean vacinado;
    private List<String> procedmentos;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    public boolean isVacinado() {
        return vacinado;
    }
    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
    public List<String> getProcedmentos() {
        return procedmentos;
    }
    public void setProcedmentos(List<String> procedmentos) {
        this.procedmentos = procedmentos;
    }
}
