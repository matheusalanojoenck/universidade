package dados;

public class Professor {
    private int mat_prof;
    private String nome;
    private int idade;
    private String sala;
    private String especialidade;

    public int getMat_prof() {
        return mat_prof;
    }

    public void setMat_prof(int mat_prof) {
        this.mat_prof = mat_prof;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "mat_prof=" + mat_prof +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sala='" + sala + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
