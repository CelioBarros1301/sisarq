package br.com.sisarq.mvc.modelo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Identificador {
	
	public Identificador() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Identificador(String cdEmp, String dsCampo, int idCampo) {
		super();
		this.cdEmp = cdEmp;
		this.dsCampo = dsCampo;
		this.idCampo = idCampo;
	}


	@NotNull(message="Codigo da Empresa deve ser Informada")
    @NotBlank(message="Codigo da Empresa deve ser Informada")
	@Size(min=2,max=2,message="Codigo da Empresa deve ter duas posicoes!!!")
	private String cdEmp;
		
	


	@NotNull (message="Descricao da Empresa deve ser Informada")
	@Size(min=5,max=40,message="Descricao d0 Campo do Identificador !!!")
	private String dsCampo;
	
	
	private int idCampo;
	
	
	public String getCdEmp() {
		return cdEmp;
	}


	public String getDsCampo() {
		return dsCampo;
	}


	public int getIdCampo() {
		return idCampo;
	}


	public void setCdEmp(String cdEmp) {
		this.cdEmp = cdEmp;
	}


	public void setDsCampo(String dsCampo) {
		this.dsCampo = dsCampo;
	}


	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}
	
}
