package br.com.sisarq.mvc.modelo;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Empresa {

	
	public Empresa() {
		super();
	}

	public Empresa(String cdEmp, String dsEmp) {
		super();
		this.cdEmp = cdEmp;
		this.dsEmp = dsEmp;
	}

	@NotNull(message="Codigo da Empresa deve ser Informada")
    @NotBlank(message="Codigo da Empresa deve ser Informada")
	@Size(min=2,max=2,message="Codigo da Empresa deve ter duas posicoes!!!")
	private String cdEmp;
		
	@NotNull (message="Descricao da Empresa deve ser Informada")
	@Size(min=5,max=40,message="Descricao da Empresa  deve ter no min 5 caracteres!!!")
	private String dsEmp;

	public String getCdEmp() {
		return cdEmp;
	}

	public void setCdEmp(String cdEmp) {
		this.cdEmp = cdEmp;
	}

	public String getDsEmp() {
		return dsEmp;
	}

	public void setDsEmp(String dsEmp) {
		this.dsEmp = dsEmp;
	}
	
	
	
	
	
}
