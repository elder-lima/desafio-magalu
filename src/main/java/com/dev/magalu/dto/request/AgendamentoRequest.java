package com.dev.magalu.dto.request;

import com.dev.magalu.entity.enums.TipoComunicacao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequest(

        @NotBlank(message = "Destinatario é obrigatório!")
        String destinatario,
        @NotBlank(message = "A mensagem é obrigatoria!")
        String mensagem,
        @NotNull(message = "O tipo de Comunicação é obrigatorio!")
        TipoComunicacao tipoComunicacao,
        @NotNull(message = "Data e Hora de envio é obrigatório!")
        @Future(message = "A data e hora deve ser futura!")
        LocalDateTime dataHoraEnvio

) {}
