package com.dev.magalu.entity;

import com.dev.magalu.entity.enums.StatusAgendamento;
import com.dev.magalu.entity.enums.TipoComunicacao;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime dataHoraEnvio;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComunicacao tipoComunicacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento statusAgendamento;

    @CreationTimestamp
    @Column(
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP WITH TIME ZONE"
    )
    private Instant criadoEm;

    public Agendamento() {
    }

    public Agendamento(UUID id, LocalDateTime dataHoraEnvio, String destinatario, String mensagem, TipoComunicacao tipoComunicacao, StatusAgendamento statusAgendamento, Instant criadoEm) {
        this.id = id;
        this.dataHoraEnvio = dataHoraEnvio;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.tipoComunicacao = tipoComunicacao;
        this.statusAgendamento = statusAgendamento;
        this.criadoEm = criadoEm;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(LocalDateTime dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public TipoComunicacao getTipoComunicacao() {
        return tipoComunicacao;
    }

    public void setTipoComunicacao(TipoComunicacao tipoComunicacao) {
        this.tipoComunicacao = tipoComunicacao;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Instant getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Instant criadoEm) {
        this.criadoEm = criadoEm;
    }
}
