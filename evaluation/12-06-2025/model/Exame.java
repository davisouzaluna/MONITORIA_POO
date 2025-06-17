package sistema.prontuario.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Exame implements Serializable {

	//pra serializar
    private static final long serialVersionUID = 1L;

    private String idExame;
    private String resultado;
    private boolean status;
    private LocalDateTime dataExame;

    public Exame() {
        this.resultado = "";
        this.status = true;
        this.dataExame = LocalDateTime.now();
    }

    public Exame(String idExame, String resultado, boolean status, LocalDateTime dataExame) {
        setIdExame(idExame);

        if (resultado == null) {
            this.resultado = "";
        } else {
            this.resultado = resultado;
        }

        this.status = status;

        if (dataExame == null) {
            this.dataExame = LocalDateTime.now();
        } else {
            this.dataExame = dataExame;
        }
    }

    public String getIdExame() {
        return idExame;
    }

    public void setIdExame(String idExame) {
        if (idExame == null || idExame.trim().isEmpty()) {
            throw new IllegalArgumentException("idExame não pode ser nulo ou vazio.");
        }
        this.idExame = idExame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        if (resultado == null) {
            this.resultado = "";
        } else {
            this.resultado = resultado;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDateTime dataExame) {
        if (dataExame == null) {
            this.dataExame = LocalDateTime.now();
        } else {
            this.dataExame = dataExame;
        }
    }

    public void registrarResultado(String resultado) {
        if (!status) {
            throw new IllegalStateException("Não é possível registrar resultado em exame inativo.");
        }
        if (resultado == null || resultado.trim().isEmpty()) {
            throw new IllegalArgumentException("Resultado inválido.");
        }
        this.resultado = resultado;
    }

    public void validarExame() {
        this.status = true;
    }

    public void invalidarExame() {
        this.status = false;
    }

    @Override
    public String toString() {
        return "Exame [idExame=" + idExame + ", resultado=" + resultado + ", status=" + status + ", dataExame="
                + dataExame + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exame)) return false;
        Exame exame = (Exame) o;
        return Objects.equals(idExame, exame.idExame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExame);
    }
}
