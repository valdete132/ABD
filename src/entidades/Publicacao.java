package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publicacao {
    @Id
    private int codigoPub;
    private String titulo;
    private int ano;
    private String autor;
    private String tipo;

    public Publicacao() { }

    public Publicacao(int codigoPub, String titulo, int ano, String autor, String tipo) {
        this.codigoPub = codigoPub;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.tipo = tipo;
    }

    public int getCodigoPub() {
        return codigoPub;
    }

    public void setCodigoPub(int codigoPub) {
        this.codigoPub = codigoPub;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
