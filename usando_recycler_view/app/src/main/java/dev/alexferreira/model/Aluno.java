package dev.alexferreira.model;

public class Aluno {
    private String disciplina;

    public Aluno() {
    }

    public Aluno(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        return disciplina != null ? disciplina.equals(aluno.disciplina) : aluno.disciplina == null;
    }

    @Override
    public int hashCode() {
        return disciplina != null ? disciplina.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "disciplina='" + disciplina + '\'' +
                '}';
    }
}
