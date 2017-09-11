package aplicacao.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import aplicacao.modelo.enumeracoes.RegiaoEstados;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome; 
	
	@NotNull
	private RegiaoEstados regiaoEstados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RegiaoEstados getRegiaoEstados() {
		return regiaoEstados;
	}

	public void setRegiaoEstados(RegiaoEstados regiaoEstados) {
		this.regiaoEstados = regiaoEstados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((regiaoEstados == null) ? 0 : regiaoEstados.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regiaoEstados != other.regiaoEstados)
			return false;
		return true;
	}

	
	
}
