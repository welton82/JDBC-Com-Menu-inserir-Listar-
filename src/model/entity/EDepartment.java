package model.entity;

public class EDepartment {
    private int id;
    private String nome;

    public EDepartment() {
    }

    public EDepartment(String nome) {

        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
