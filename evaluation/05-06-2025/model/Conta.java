package sistema.bancario.prova.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    private String numeroConta;
    private BigDecimal saldo;
    private boolean status;
    private LocalDateTime dataAbertura;

    public Conta() {
        this.saldo = BigDecimal.ZERO;
        this.status = true;
        this.dataAbertura = LocalDateTime.now();
    }

    public Conta(String numeroConta, BigDecimal saldo, boolean status, LocalDateTime dataAbertura) {
        this.numeroConta = numeroConta;

        /*
        A expressão abaixo é a mesma que:
        if (saldo == null) {
            this.saldo = BigDecimal.ZERO;
        } else {
            this.saldo = saldo;
        }
        */
        this.saldo = saldo == null ? BigDecimal.ZERO : saldo;
        this.status = status;
        this.dataAbertura = dataAbertura == null ? LocalDateTime.now() : dataAbertura;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void depositar(BigDecimal quantia) {
        if (!status) throw new IllegalStateException("Conta desativada.");
        if (quantia == null || quantia.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Quantia inválida.");
        }
        saldo = saldo.add(quantia);
    }

    public void sacar(BigDecimal quantia) {
        if (!status) throw new IllegalStateException("Conta desativada.");
        if (quantia == null || quantia.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Quantia inválida.");
        }
        if (saldo.compareTo(quantia) < 0) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        saldo = saldo.subtract(quantia);
    }

    public void transferir(Conta destino, BigDecimal quantia) {
        if (!this.status || !destino.isStatus()) {
            throw new IllegalStateException("Conta desativada.");
        }
        this.sacar(quantia);
        destino.depositar(quantia);
    }

    public void ativarConta() {
        this.status = true;
    }

    public void desativarConta() {
        this.status = false;
    }

    @Override
    public String toString() {
        return "Conta [numeroConta=" + numeroConta + ", saldo=" + saldo + ", status=" + status + ", dataAbertura=" + dataAbertura + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return Objects.equals(numeroConta, conta.numeroConta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroConta);
    }
}
