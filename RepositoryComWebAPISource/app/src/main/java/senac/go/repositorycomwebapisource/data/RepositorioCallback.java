package senac.go.repositorycomwebapisource.data;

public interface RepositorioCallback<T> {

    void onResult(T model);
    void onEmpty();
}
