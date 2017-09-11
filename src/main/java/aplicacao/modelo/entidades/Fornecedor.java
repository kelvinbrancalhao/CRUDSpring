package aplicacao.modelo.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Fornecedor {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String telefone;
	
	@NotNull
	private int CPF;
	
	private String endereco;
	private int Nrua;
	private String Bairro;
	
	@ManyToOne
	private int COD_Cidade;
	@ManyToOne
	private int COD_Estado;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		CPF = cPF;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNrua() {
		return Nrua;
	}
	public void setNrua(int nrua) {
		Nrua = nrua;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public int getCOD_Cidade() {
		return COD_Cidade;
	}
	public void setCOD_Cidade(int cOD_Cidade) {
		COD_Cidade = cOD_Cidade;
	}
	public int getCOD_Estado() {
		return COD_Estado;
	}
	public void setCOD_Estado(int cOD_Estado) {
		COD_Estado = cOD_Estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + COD_Estado;
		result = prime * result + ID;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (COD_Estado != other.COD_Estado)
			return false;
		if (ID != other.ID)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}