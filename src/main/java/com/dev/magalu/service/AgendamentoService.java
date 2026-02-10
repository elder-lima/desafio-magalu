package com.dev.magalu.service;

import com.dev.magalu.dto.request.AgendamentoRequest;
import com.dev.magalu.dto.response.AgendamentoResponse;
import com.dev.magalu.entity.Agendamento;
import com.dev.magalu.entity.enums.StatusAgendamento;
import com.dev.magalu.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
public class AgendamentoService {

    private AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Transactional
    public AgendamentoResponse criarAgendamento(AgendamentoRequest dto) {
        Agendamento agendamento = new Agendamento();
        agendamento.setDestinatario(dto.destinatario());
        agendamento.setMensagem(dto.mensagem());
        agendamento.setTipoComunicacao(dto.tipoComunicacao());
        agendamento.setDataHoraEnvio(dto.dataHoraEnvio());
        agendamento.setStatusAgendamento(StatusAgendamento.AGENDADO);

        Agendamento agendametoSalvo = agendamentoRepository.save(agendamento);
        return toResponse(agendametoSalvo);
    }

    public AgendamentoResponse toResponse(Agendamento agendamento) {
        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getDestinatario(),
                agendamento.getMensagem(),
                agendamento.getTipoComunicacao(),
                agendamento.getDataHoraEnvio(),
                agendamento.getStatusAgendamento(),
                agendamento.getCriadoEm()
        );
    }

    @Transactional(readOnly = true)
    public AgendamentoResponse buscarPorId(UUID id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        return toResponse(agendamento);
    }

    @Transactional
    public void remover(UUID id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }

}
