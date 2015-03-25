/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Drazzull
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable
{

    @Id
    @Column(name = "id_pessoa", nullable = false)
    private Long idPessoa;

    @Column(name = "estado_civil", length = 100, nullable = false)
    private String estadoCivil;

    @Column(name = "grau_instrucao", nullable = false)
    private String grauInstrucao;

    @Column(name = "numero_filhos", nullable = true)
    private Integer numeroFilhos;

    @Column(name = "salario", nullable = true)
    private Double salario;

    @Column(name = "idade_anos", nullable = true)
    private Integer idadeAnos;

    @Column(name = "idade_meses", nullable = true)
    private Integer idadeMeses;

    public Pessoa()
    {
    }

    public Pessoa(long idPessoa, String estadoCivil, String grauInstrucao, int numeroFilhos, double salario, int idadeAnos, int idadeMeses)
    {
        this.idPessoa = idPessoa;
        this.estadoCivil = estadoCivil;
        this.grauInstrucao = grauInstrucao;
        this.numeroFilhos = numeroFilhos;
        this.salario = salario;
        this.idadeAnos = idadeAnos;
        this.idadeMeses = idadeMeses;
    }

    public Long getIdPessoa()
    {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa)
    {
        this.idPessoa = idPessoa;
    }

    public String getEstadoCivil()
    {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil)
    {
        this.estadoCivil = estadoCivil;
    }

    public String getGrauInstrucao()
    {
        return grauInstrucao;
    }

    public void setGrauInstrucao(String grauInstrucao)
    {
        this.grauInstrucao = grauInstrucao;
    }

    public Integer getNumeroFilhos()
    {
        return numeroFilhos;
    }

    public void setNumeroFilhos(Integer numeroFilhos)
    {
        this.numeroFilhos = numeroFilhos;
    }

    public Double getSalario()
    {
        return salario;
    }

    public void setSalario(Double salario)
    {
        this.salario = salario;
    }

    public Integer getIdadeAnos()
    {
        return idadeAnos;
    }

    public void setIdadeAnos(Integer idadeAnos)
    {
        this.idadeAnos = idadeAnos;
    }

    public Integer getIdadeMeses()
    {
        return idadeMeses;
    }

    public void setIdadeMeses(Integer idadeMeses)
    {
        this.idadeMeses = idadeMeses;
    }


    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + (int) (this.idPessoa ^ (this.idPessoa >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;

        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.idPessoa, other.idPessoa);
    }
}
