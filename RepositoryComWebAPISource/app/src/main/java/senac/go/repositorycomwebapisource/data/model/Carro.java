package senac.go.repositorycomwebapisource.data.model;

import java.util.Objects;

public class Carro {
    private Long id;
    private String descricao;

    public Carro() {
    }

    public Carro(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id) &&
                Objects.equals(descricao, carro.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
