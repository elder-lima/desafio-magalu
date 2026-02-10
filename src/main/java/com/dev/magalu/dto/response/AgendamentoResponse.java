package com.dev.magalu.dto.response;

import com.dev.magalu.entity.enums.StatusAgendamento;
import com.dev.magalu.entity.enums.TipoComunicacao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponse(

        UUID id,
        String destinatario,
        String mensagem,
        TipoComunicacao tipoComunicacao,
        LocalDateTime dataHoraEnvio,
        StatusAgendamento statusAgendamento,
        Instant criadoEm

) {}
