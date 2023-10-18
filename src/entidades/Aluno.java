package entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
    @Id
    private int matriculaAluno;
    private String nome;
    @OneToMany
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Aluno() { }

    public Aluno(int matriculaAluno, String nome) {
        this.matriculaAluno = matriculaAluno;
        this.nome = nome;
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    
}
