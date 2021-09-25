import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMain {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        FilaDeAtendimento fl = new FilaDeAtendimento();
        byte escolha;

        do{
            System.out.println("Digite a sua Opção: ");
            System.out.println("1 - Adicionar um cliente na fila");
            System.out.println("2 - Ver Cliente da fila");
            System.out.println("3 - Ver quantidade de clientes que estão na fila");
            System.out.println("4 - Atender um cliente pelo CPF");
            System.out.println("5 - Pesquisar um cliente pelo CPF");
            System.out.println("6 - Pesquisar clientes pelo interesse");
            System.out.println("7 - Retirar todos os clientes da fila");
            System.out.println("0 - Sair");
            escolha = ler.nextByte();

            switch(escolha){
                case 1:
                    Pessoa pl = new Pessoa();
                    System.out.println("Informe o nome do cliente: ");
                    pl.setNome(ler.next());
                    do{
                        System.out.println("Informe o CPF do cliente");
                        pl.setCpf(ler.next());
                        if(pl.getCpf().length() != 11) {
                            System.out.println("Erro, CPF Inválido");
                        }
                    }while(pl.getCpf(). length() !=11);
                    do{
                        System.out.println("Informe o interesse do cliente");
                        System.out.println("1 - Pagaento de Conta");
                        System.out.println("2 - Recebimento de Salário");
                        System.out.println("3 - Outra Operação");
                        pl.setInteresse(ler.nextByte());
                        if(pl.getInteresse() < 1 | pl.getInteresse() > 3){
                            System.out.println("Erro, Inválido");
                        }
                    }while(pl.getInteresse() < 1 | pl.getInteresse() > 3);
                    fl.adicionarPessoa(pl);
                    System.out.println("Pessoa adicionada na fila com sucesso");
                    break;
                case 2:
                        if(fl.getFila().isEmpty()) {
                            System.out.println("Não há cliente na fila");
                    }else{
                        System.out.println(fl);
                    }
                    break;
                case 3:
                    System.out.println("Total de clientes na fila: " + fl.obterQuantidadeDePessoas());
                        break;
                case 4:
                    if(fl.getFila().isEmpty()) {
                        System.out.println("Não há clientes para atender");
                    }else{
                        System.out.println("Cliente" + fl.atenderPessoa());
                    }
                    break;
                case 5:
                    System.out.println("Informe o CPF do cliente para efetuar a pesquisa");
                    String nome = ler.next();
                    Pessoa resultado = fl.pesquisarPeloCPF(nome);
                    if(resultado == null) {
                        System.out.println("Não há cliente na fila");
                    }else{
                        System.out.println(resultado);
                    }
                    break;
                case 6:
                    System.out.println("Informe o interesse para listar os clientes");
                    System.out.println("1 - Pagamento de Conta");
                    System.out.println("2 - Recebimento de Salário");
                    System.out.println("3 - Outras Operações");
                    byte pesquisa = ler.nextByte();
                    ArrayList<Pessoa> lista = fl.pesquisarPessoasPeloInteresse(pesquisa);
                    if(lista.isEmpty()) {
                        System.out.println("Não há clientes com esse interesse");
                    }else{
                        System.out.println(lista);
                    }
                    break;
                case 7:
                    if(fl.getFila().isEmpty()) {
                        System.out.println("Não há clientes na fila");
                    }else{
                        fl.apagarTodos();
                        System.out.println("Clientes removidos da fila");
                    }
                    break;
                case 0:
                    System.out.println("Sistema Encerrado");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(escolha != 0);
    }
}