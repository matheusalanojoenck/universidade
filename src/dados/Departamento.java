package dados;

public class Departamento {
    private int num_dep;
    private String nome;
    private String escritorio;
    private int mat_prof;

    public int getNum_dep() {
        return num_dep;
    }

    public void setNum_dep(int num_dep) {
        this.num_dep = num_dep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(String escritorio) {
        this.escritorio = escritorio;
    }

    public int getMat_prof() {
        return mat_prof;
    }

    public void setMat_prof(int mat_prof) {
        this.mat_prof = mat_prof;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "num_dep=" + num_dep +
                ", nome='" + nome + '\'' +
                ", escritorio='" + escritorio + '\'' +
                ", mat_prof=" + mat_prof +
                '}';
    }
}
