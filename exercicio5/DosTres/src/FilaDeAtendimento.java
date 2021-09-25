import java.util.ArrayList;

public class FilaDeAtendimento {
    private ArrayList<Pessoa> fila;

    public FilaDeAtendimento() {
        this.fila = new ArrayList<>();
    }

    public void setFila(ArrayList<Pessoa> fila) {
        this.fila = fila;
    }
    public ArrayList<Pessoa> getFila() {
        return fila;
    }

    public Pessoa atenderPessoa() {
        Pessoa p1 = this.fila.get(0);
        this.fila.remove(0);
        return p1;
    }

    public void adicionarPessoa(Pessoa p) {
        this.fila.add(p);
    }

    public int obterQuantidadeDePessoas() {
        return this.fila.size();
    }

    public void apagarTodos() {
        this.fila.clear();
    }

    public Pessoa pesquisarPeloCPF(String cpf) {
        Pessoa p2 = null;
        for(int i = 0; i <this.fila.size(); i++) {
            if(this.fila.get(i).getCpf().equals(cpf)) {
                p2 = this.fila.get(i);
            }
        }
        return p2;
    }

    public ArrayList<Pessoa> pesquisarPessoasPeloInteresse(byte interesse) {
        ArrayList<Pessoa> listaInteresse = new ArrayList<> ();
        for(int i = 0; i < this.fila.size(); i++) {
            if(this.fila.get(i).getInteresse() == interesse) {
                listaInteresse.add(this.fila.get(i));
            }
        }
        return listaInteresse;
    }
    @Override
    public String toString() {
        return "Fila de Atendimento\n;" + fila;
    }
}