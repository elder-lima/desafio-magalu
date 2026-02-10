package com.dev.magalu;

import com.dev.magalu.controller.AgendamentoController;
import com.dev.magalu.dto.request.AgendamentoRequest;
import com.dev.magalu.dto.response.AgendamentoResponse;
import com.dev.magalu.entity.enums.StatusAgendamento;
import com.dev.magalu.entity.enums.TipoComunicacao;
import com.dev.magalu.service.AgendamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AgendamentoController.class)
public class AgendamentoControllerTest {

    // Simular requisições HTTP
    @Autowired
    private MockMvc mockMvc;

    // Converte Objetos em JSON e vice-versa
    @Autowired
    private ObjectMapper objectMapper;

    // Cria um mock do service usado dentro do controller
    @MockitoBean
    private AgendamentoService service;

    @Test
    void deveAgendarComunicacao() throws Exception {

        UUID id = UUID.fromString("11111111-1111-1111-1111-111111111111");

        AgendamentoRequest requestDTO = new AgendamentoRequest(
                "cliente@gmail.com",
                "Mensagem de test",
                TipoComunicacao.EMAIL,
                LocalDateTime.now().plusMinutes(1)
        );

        AgendamentoResponse response = new AgendamentoResponse(
                id,
                requestDTO.destinatario(),
                requestDTO.mensagem(),
                requestDTO.tipoComunicacao(),
                requestDTO.dataHoraEnvio(),
                StatusAgendamento.AGENDADO,
                Instant.now()
        );

        when(service.criarAgendamento(any())).thenReturn(response);

        mockMvc.perform(post("/api/agendamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.destinatario").value("cliente@gmail.com"));

    }

    @Test
    void deveBuscarAgendamentoPorId() throws Exception {

        UUID id = UUID.fromString("11111111-1111-1111-1111-111111111111");

        AgendamentoResponse response = new AgendamentoResponse(
                id,
                "cliente@gmail.com",
                "Mensagem de test",
                TipoComunicacao.SMS,
                LocalDateTime.now().plusMinutes(2),
                StatusAgendamento.AGENDADO,
                Instant.now()
        );

        when(service.buscarPorId(id)).thenReturn(response);

        mockMvc.perform(get("/api/agendamentos/{id}", id.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.tipoComunicacao").value("SMS"));


    }

    @Test
    void devRemoverAgendamento() throws Exception {

        UUID id = UUID.fromString("11111111-1111-1111-1111-111111111111");

        doNothing().when(service).remover(id);

        mockMvc.perform(delete("/api/agendamentos/{id}", id.toString()))
                .andExpect(status().isNoContent());

    }

}
