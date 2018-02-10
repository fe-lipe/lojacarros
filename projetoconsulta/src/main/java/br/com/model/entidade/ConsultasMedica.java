package br.com.model.entidade;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ConsultasMedica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="nomePaciente")
	private String nomePaciente;
	
	@Column(name="especialidadeMedica")
	private String especialidadeMedica;
	
	@Column(name="nomeMedico")
	private String nomeMedico;
	
	@Column(name="crm")
	private Integer crm;
	
	
	@Column(name="data")
	private Date data;
	
	@Column(name="horario")
	private  Date   horario;
	
	
	@Column(name="numeroConsultorio")
	private Integer numeroConsultorio;


	public String getNomePaciente() {
		return nomePaciente;
	}


	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}


	public String getEspecialidadeMedica() {
		return especialidadeMedica;
	}


	public void setEspecialidadeMedica(String especialidadeMedica) {
		this.especialidadeMedica = especialidadeMedica;
	}


	public String getNomeMedico() {
		return nomeMedico;
	}


	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}


	public Integer getCrm() {
		return crm;
	}


	public void setCrm(Integer crm) {
		this.crm = crm;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Integer getNumeroConsultorio() {
		return numeroConsultorio;
	}


	public void setNumeroConsultorio(Integer numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	
	
	public Date getHorario() {
		return horario;
	}


	public void setHorario(Date horario) {
		this.horario = horario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		ConsultasMedica other = (ConsultasMedica) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
