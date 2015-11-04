/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author boleto verde 02
 */
@Entity
@Table(name = "profissao", catalog = "db_pessoa", schema = "")
public class Profissao implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofisao")
    private Integer idprofisao;
    @Column(name = "nome")
    private String nome;
    @Column(name = "codigo")
    private String codigo;
    
    @OneToMany(mappedBy = "profissao")
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public Profissao() {
    }

    public Profissao(Integer idprofisao) {
        this.idprofisao = idprofisao;
    }

    public Integer getIdprofisao() {
        return idprofisao;
    }

    public void setIdprofisao(Integer idprofisao) {
        Integer oldIdprofisao = this.idprofisao;
        this.idprofisao = idprofisao;
        changeSupport.firePropertyChange("idprofisao", oldIdprofisao, idprofisao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofisao != null ? idprofisao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissao)) {
            return false;
        }
        Profissao other = (Profissao) object;
        if ((this.idprofisao == null && other.idprofisao != null) || (this.idprofisao != null && !this.idprofisao.equals(other.idprofisao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    
    
}
