package academy.springboot2.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//informa que o ID vai ser uma chave primária
    private Integer id;

    @NotEmpty(message = "Campo NOME é mandatório")
    @Length(min = 3, max = 100, message = "O nome deve ter de 3 à 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo LOGIN é mandatório")
    @Length(min = 3, max = 100, message = "O login deve ter de 3 à 100 caracteres")
    private String login;

    @NotEmpty(message = "Campo SENHA é mandatório")
    @Length(min = 3, max = 100, message = "A senha deve ter de 3 à 100 caracteres")
    private String senha;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
