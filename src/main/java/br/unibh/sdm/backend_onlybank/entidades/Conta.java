package br.unibh.sdm.backend_onlybank.entidades;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Conta")
public class Conta {


	private String id;
	private Long agencia;
	private Long contaNumero;
	private Float contaSaldo;
	private String tipoConta;

	
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute
	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	@DynamoDBAttribute
	public Long getContaNumero() {
		return contaNumero;
	}

	public void setContaNumero(Long contaNumero) {
		this.contaNumero = contaNumero;
	}

	@DynamoDBAttribute
	public Float getContaSaldo() {
		return contaSaldo;
	}

	public void setContaSaldo(Float contaSaldo) {
		this.contaSaldo = contaSaldo;
	}

	@DynamoDBAttribute
	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public String toString() {
		return "Conta{" +
				"id='" + id + '\'' +
				", agencia=" + agencia +
				", contaNumero=" + contaNumero +
				", contaSaldo=" + contaSaldo +
				", tipoConta='" + tipoConta + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Conta conta = (Conta) o;
		return Objects.equals(id, conta.id) && Objects.equals(agencia, conta.agencia) && Objects.equals(contaNumero, conta.contaNumero) && Objects.equals(contaSaldo, conta.contaSaldo) && Objects.equals(tipoConta, conta.tipoConta);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, agencia, contaNumero, contaSaldo, tipoConta);
	}

	public Conta() {
	}

	public Conta(String id, Long agencia, Long contaNumero, Float contaSaldo, String tipoConta) {
		this.id = id;
		this.agencia = agencia;
		this.contaNumero = contaNumero;
		this.contaSaldo = contaSaldo;
		this.tipoConta = tipoConta;
	}
}
