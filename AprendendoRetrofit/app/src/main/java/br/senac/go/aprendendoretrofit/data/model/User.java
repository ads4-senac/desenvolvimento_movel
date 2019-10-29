package br.senac.go.aprendendoretrofit.data.model;

public class User {

	private Long id;
	private Long userId;
	private String title;
	private boolean completed;

	public User() {
	}

	public User(Long id, Long userId, String title, boolean completed) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (completed != user.completed) return false;
		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
		return title != null ? title.equals(user.title) : user.title == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (completed ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userId=" + userId +
				", title='" + title + '\'' +
				", completed=" + completed +
				'}';
	}
}
