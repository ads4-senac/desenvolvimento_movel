package br.senac.go.repository.data.repository.source;

public interface CrudSource<ModelType, IdentificadorType> {

	ModelType crie(ModelType model);

	ModelType delete(ModelType model);

	ModelType recupere(IdentificadorType identificador);

	ModelType atualize(ModelType model);
}
