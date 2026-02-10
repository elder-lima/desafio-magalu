package com.dev.magalu.controller;

import com.dev.magalu.dto.request.AgendamentoRequest;
import com.dev.magalu.dto.response.AgendamentoResponse;
import com.dev.magalu.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criarAgendamento(@RequestBody @Valid AgendamentoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.criarAgendamento(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(agendamentoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAgendamento(@PathVariable UUID id) {
        agendamentoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
