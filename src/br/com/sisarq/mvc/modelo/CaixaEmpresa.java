package br.com.sisarq.mvc.modelo;



public class CaixaEmpresa {
	
	public void setCdEmp(String cdEmp) {
		this.cdEmp = cdEmp;
	}
	public void setDsEmp(String dsEmp) {
		this.dsEmp = dsEmp;
	}
	public void setCdCaixa(String cdCaixa) {
		this.cdCaixa = cdCaixa;
	}
	public void setDsCaixa(String dsCaixa) {
		this.dsCaixa = dsCaixa;
	}
	public CaixaEmpresa() {
		super();
	}
	private String cdEmp;
	private String dsEmp;
    private String cdCaixa;
	private String dsCaixa;
	
	public String getCdEmp() {
		return cdEmp;
	}
	public String getDsEmp() {
		return dsEmp;
	}
	public String getCdCaixa() {
		return cdCaixa;
	}
	public String getDsCaixa() {
		return dsCaixa;
	}
	

}
