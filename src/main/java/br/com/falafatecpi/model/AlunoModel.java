package br.com.falafatecpi.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "aluno")
public class AlunoModel {

    @Id
    Integer ra;

    String email;

    String senha;

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoModel that = (AlunoModel) o;
        return Objects.equals(ra, that.ra) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ra, email, senha);
    }

    @Override
    public String toString() {
        return "AlunoModel{" +
                "ra=" + ra +
                ", email='" + email + '\'' +
                '}';
    }
}
