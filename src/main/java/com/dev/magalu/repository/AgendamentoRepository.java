    package com.dev.magalu.repository;

    import com.dev.magalu.entity.Agendamento;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.UUID;

    public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
    }
