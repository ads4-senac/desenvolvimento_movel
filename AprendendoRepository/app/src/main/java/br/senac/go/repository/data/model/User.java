package br.senac.go.repository.data.model;

public class User {

	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;

	public User() {
	}

	public User(Long id, String nome, String sobrenome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (nome != null ? !nome.equals(user.nome) : user.nome != null) return false;
		if (sobrenome != null ? !sobrenome.equals(user.sobrenome) : user.sobrenome != null) return false;
		return cpf != null ? cpf.equals(user.cpf) : user.cpf == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (nome != null ? nome.hashCode() : 0);
		result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
		result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", cpf='" + cpf + '\'' +
				'}';
	}
}
