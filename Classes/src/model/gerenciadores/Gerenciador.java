package model.gerenciadores;

import view.DescricaoEmBrancoException;
import view.ObjetoNaoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public abstract class Gerenciador<T> {
    protected Map<String, T> registros = new HashMap<>();

    public abstract void criar(T t);
    public T pesquisar(String campo){
        T objeto = registros.get(campo);
        if (objeto == null) {
            throw new ObjetoNaoEncontradoException("Objeto não encontrado");
        }
        return objeto;
    }
    public abstract void alterar(T t);
    public boolean excluir(String campo) {
        T objeto = registros.get(campo);
        if (objeto == null) {
            throw new ObjetoNaoEncontradoException("Objeto não encontrado");
        }
        return registros.remove(campo, objeto);
    }
}
