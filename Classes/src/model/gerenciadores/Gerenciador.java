package model.gerenciadores;

import view.DescricaoEmBrancoException;

import java.util.HashMap;
import java.util.Map;

public abstract class Gerenciador<T> {
    protected Map<String, T> registros = new HashMap<>();

    public abstract void criar(T t) throws DescricaoEmBrancoException;
    public abstract T pesquisar(String campo);
    public abstract void alterar(T t);
    public abstract void excluir(String campo);
}
