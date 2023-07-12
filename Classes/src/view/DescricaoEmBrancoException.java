package view;

public class DescricaoEmBrancoException extends Exception{
    private final String campo;
    public DescricaoEmBrancoException(String campo) {
        super("O campo '" + campo + "' é obrigatório e está em branco.");
        this.campo = campo;
    }

    public String getCampo(){
        return campo;
    }
}
