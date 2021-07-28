package dados;

public class EstudantePos {

    private int mat_est;
    private String nome;
    private int idade;
    private int num_dep;
    private int mat_est_aconselhador;

    public int getMat_est() {
        return mat_est;
    }

    public void setMat_est(int mat_est) {
        this.mat_est = mat_est;
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

    public int getNum_dep() {
        return num_dep;
    }

    public void setNum_dep(int num_dep) {
        this.num_dep = num_dep;
    }

    public int getMat_est_aconselhador() {
        return mat_est_aconselhador;
    }

    public void setMat_est_aconselhador(int mat_est_aconselhador) {
        this.mat_est_aconselhador = mat_est_aconselhador;
    }

    @Override
    public String toString() {
        return "EstudantePos{" +
                "mat_est=" + mat_est +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", num_dep=" + num_dep +
                ", mat_est_aconselhador=" + mat_est_aconselhador +
                '}';
    }
}
