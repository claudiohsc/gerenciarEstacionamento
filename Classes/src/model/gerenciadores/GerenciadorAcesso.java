package model.gerenciadores;

import model.dominio.Acesso;
import view.DescricaoEmBrancoException;

public class GerenciadorAcesso extends Gerenciador<Acesso>{
    @Override
    public void criar(Acesso acesso) throws DescricaoEmBrancoException {

        if (acesso.getPlaca() == null || acesso.getDataEntrada() == null || acesso.getDataSaida() == null
            || acesso.getHoraEntrada() == null || acesso.getHoraSaida() == null ){
            throw new DescricaoEmBrancoException("Campos obrigatórios não foram informados.");
        }
        registros.put(acesso.getPlaca(), acesso);
    }

    @Override
    public Acesso pesquisar(String placa) {
        return registros.get(placa);
    }

    @Override
    public void alterar(Acesso acesso) {
        registros.put(acesso.getPlaca(), acesso);
    }

    @Override
    public void excluir(String placa) {
        registros.remove(placa);
    }
}
