# 📬 Plataforma de Agendamento de Comunicações – Desafio Magalu

Este projeto foi desenvolvido como solução para o **desafio técnico do Magalu**, cujo objetivo é iniciar a primeira sprint de uma plataforma de comunicação, focada no **agendamento de envios**.

A API permite **criar**, **consultar** e **remover** agendamentos de comunicações (email, SMS, push e WhatsApp), persistindo os dados em banco de dados e preparando a estrutura para futuras evoluções, como o envio efetivo das mensagens.

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Data JPA**
* **Spring Validation (Bean Validation)**
* **PostgreSQL**
* **JUnit / Mockito** para testes
* **Maven**
---

## 📌 Funcionalidades Implementadas

### 1️⃣ Criar agendamento de comunicação

* Endpoint para agendar o envio de uma comunicação
* Campos obrigatórios:

  * Data e hora do envio
  * Destinatário
  * Mensagem
  * Tipo de comunicação (`EMAIL`, `SMS`, `PUSH`, `WHATSAPP`)
* O agendamento é salvo no banco com status inicial **AGENDADO**

### 2️⃣ Consultar status do agendamento

* Consulta de um agendamento pelo **ID (UUID)**
* Retorna todas as informações do agendamento, incluindo o status

### 3️⃣ Remover agendamento

* Remove um agendamento existente pelo ID

---

## 🗂️ Modelagem e Persistência

* Cada agendamento possui:

  * Identificador único (`UUID`)
  * Dados da comunicação
  * Status do agendamento
  * Data de criação automática

---

## 🌐 Endpoints da API

| Método | Endpoint                 | Descrição                    |
| ------ | ------------------------ | ---------------------------- |
| POST   | `/api/agendamentos`      | Criar um novo agendamento    |
| GET    | `/api/agendamentos/{id}` | Consultar agendamento por ID |
| DELETE | `/api/agendamentos/{id}` | Remover agendamento          |

Todas as requisições e respostas seguem o padrão **JSON**.

---

## 🧪 Testes

* Testes unitários focados na **camada de serviço**
* Uso de **JUnit** e **Mockito**
* Suíte organizada para garantir:

  * Criação correta do agendamento
  * Consulta por ID
  * Remoção de registros

