package br.com.sisarq.mvc.modelo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.sisarq.util.Util;

public class Caixa {
	
	@NotNull(message="Codigo da Empresa deve ser Informada!")
    @NotBlank(message="Codigo da Empresa deve ser Informada!")
	@Size(min=2,max=2,message="Codigo da Empresa deve ter duas posicoes!")
	private String cdEmp;
	
	@NotNull (message="Codigo da Caixa deve ser Informada!")
	@NotBlank (message="Codigo da Caixa deve ser Informada!")
	@Size(min=5,max=5,message="Codigo da Caixa deve ter duas posicoes!")
	private String cdCaixa;
	
	@NotBlank (message="Descricao da Caixa deve ser Informada!")
	@Size(min=5,max=40,message="Descricao da Caixa  deve ter no min 5 caracteres e no Maximo 40 caractetes!")
	private String dsCaixa;
	
	public String getCdEmp() {
		return cdEmp;
	}
	public void setCdEmp(String cdEmp) {
		//cdEmp=Util.right("0000"+cdEmp.trim(),2);
		this.cdEmp = cdEmp;
	}
	public String getCdCaixa() {
		return cdCaixa;
	} 
	public void setCdCaixa(String cdCaixa) {
		//cdCaixa=Util.right("00000"+cdCaixa.trim(),5);
		this.cdCaixa = cdCaixa;
	}
	public String getDsCaixa() {
		return dsCaixa;
	}
	public void setDsCaixa(String dsCaixa) {
		this.dsCaixa = dsCaixa;
	}
	public Caixa(String cdEmp, String cdCaixa, String dsCaixa) {
		super();
		this.cdEmp =cdEmp ;//Util.right("0000"+cdEmp.trim(),2);
		this.cdCaixa =cdCaixa;// Util.right("00000"+cdCaixa.trim(),5);
		this.dsCaixa = dsCaixa;
	}
	public Caixa() {
		//super();
		System.out.println("inicializando classe");
	}
	
}
