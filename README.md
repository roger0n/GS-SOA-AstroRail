# Space Logistics API

## Integrantes

- Augusto Rogel / RM 557709
- Heitor Prestes / RM 554823
- Lucca Ribeiro / RM 556668

---

# Problema

Regiões isoladas frequentemente enfrentam dificuldades para receber suprimentos essenciais devido a limitações logísticas, condições geográficas adversas e eventos climáticos extremos.

Entre os principais problemas observados estão:

* Demora no transporte de suprimentos;
* Falta de medicamentos em áreas remotas;
* Dificuldade de acesso durante enchentes;
* Distribuição limitada de alimentos e água;
* Alto custo logístico;
* Falta de monitoramento das operações de entrega.

Exemplos de locais afetados:

* Amazônia;
* Áreas rurais;
* Regiões montanhosas;
* Cidades alagadas;
* Locais atingidos por desastres naturais.

---

# Solução Proposta

O projeto Space Logistics API foi desenvolvido inspirado nos sistemas de logística utilizados em missões espaciais.

A proposta consiste em uma plataforma capaz de gerenciar entregas de suprimentos para regiões isoladas utilizando drones autônomos e planejamento inteligente de rotas.

A solução permite:

* Cadastro de regiões de difícil acesso;
* Cadastro de drones responsáveis pelas entregas;
* Criação de missões de transporte;
* Planejamento de rotas;
* Monitoramento do status das missões;
* Controle das entregas realizadas.

---

# Objetivo

Desenvolver uma API REST utilizando Java e Spring Boot para auxiliar no gerenciamento logístico de entregas em regiões isoladas, aplicando conceitos de Programação Orientada a Objetos, persistência de dados e arquitetura em camadas.

---

# Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Lombok

---

# Arquitetura do Projeto

O sistema foi desenvolvido utilizando arquitetura em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Banco de Dados
```

Estrutura principal:

```text
src/main/java

controller
dto
enums
exception
model
repository
service
```

---

# Conceitos Aplicados

## Programação Orientada a Objetos

### Encapsulamento

Utilização de atributos privados e métodos de acesso.

### Herança

A classe Drone herda características da classe abstrata Veiculo.

```java
public class Drone extends Veiculo
```

### Polimorfismo

Implementação do método:

```java
calcularAutonomia()
```

sobrescrito pela classe Drone.

### Abstração

Utilização da classe abstrata:

```java
Veiculo
```

---

# Interfaces e Injeção de Dependência

Interface utilizada:

```java
PlanejadorRota
```

Implementação:

```java
PlanejadorRotaEspacial
```

Injeção de dependência aplicada no serviço de missões.

---

# DTO

Para criação de missões foi utilizado:

```java
MissaoDTO
```

Permitindo desacoplamento entre a API e as entidades persistidas.

---

# Tratamento de Exceções

Classe customizada:

```java
RecursoNaoEncontradoException
```

Handler global:

```java
GlobalExceptionHandler
```

Responsável por retornar mensagens amigáveis para erros da aplicação.

---

# Banco de Dados

Foi utilizado o banco de dados H2 em memória para simplificar a execução do projeto.

Tabelas principais:

* regiao
* veiculo
* drone
* missao

---

# Entidades

## Região

Representa uma área que necessita de suprimentos.

Atributos:

* id
* nome
* tipoRegiao
* nivelRisco
* latitude
* longitude

---

## Veículo

Classe abstrata responsável por representar veículos de transporte.

Atributos:

* id
* nome
* capacidadeCarga
* status

---

## Drone

Especialização da classe Veiculo.

Atributos:

* bateria

---

## Missão

Representa uma operação logística.

Atributos:

* id
* dataCriacao
* dataPrevistaEntrega
* status
* regiao
* drone

---

# Fluxo do Sistema

```text
Cadastro da Região
        ↓
Cadastro do Drone
        ↓
Planejamento da Rota
        ↓
Criação da Missão
        ↓
Execução da Entrega
        ↓
Atualização do Status
        ↓
Conclusão da Missão
```

---

# Endpoints

## Região

| Método | Endpoint      |
| ------ | ------------- |
| GET    | /regioes      |
| GET    | /regioes/{id} |
| POST   | /regioes      |
| PUT    | /regioes/{id} |
| DELETE | /regioes/{id} |

---

## Drone

| Método | Endpoint     |
| ------ | ------------ |
| GET    | /drones      |
| GET    | /drones/{id} |
| POST   | /drones      |
| PUT    | /drones/{id} |
| DELETE | /drones/{id} |

---

## Missão

| Método | Endpoint      |
| ------ | ------------- |
| GET    | /missoes      |
| GET    | /missoes/{id} |
| POST   | /missoes      |
| PUT    | /missoes/{id} |
| DELETE | /missoes/{id} |

---

# Evidências de Testes

## Testes de Região

### POST

```http
POST /regioes
```

```json
{
  "nome": "Amazonia Norte",
  "tipoRegiao": "Floresta",
  "nivelRisco": 8,
  "latitude": -3.1,
  "longitude": -60.0
}
```

### GET

```http
GET /regioes
```

### GET POR ID

```http
GET /regioes/1
```

### PUT

```http
PUT /regioes/1
```

```json
{
  "nome": "Amazonia Sul",
  "tipoRegiao": "Floresta",
  "nivelRisco": 10,
  "latitude": -5.2,
  "longitude": -62.0
}
```

### DELETE

```http
DELETE /regioes/1
```

---

## Testes de Drone

### POST

```http
POST /drones
```

```json
{
  "nome": "Drone Alpha",
  "capacidadeCarga": 50,
  "status": "DISPONIVEL",
  "bateria": 90
}
```

### GET

```http
GET /drones
```

### GET POR ID

```http
GET /drones/1
```

### PUT

```http
PUT /drones/1
```

```json
{
  "nome": "Drone Beta",
  "capacidadeCarga": 70,
  "status": "EM_ROTA",
  "bateria": 100
}
```

### DELETE

```http
DELETE /drones/1
```

---

## Testes de Missão

### POST

```http
POST /missoes
```

```json
{
  "regiaoId": 1,
  "droneId": 1,
  "dataPrevistaEntrega": "2026-06-10T14:00:00"
}
```

### GET

```http
GET /missoes
```

### GET POR ID

```http
GET /missoes/1
```

### PUT

```http
PUT /missoes/1
```

```json
{
  "status": "EM_ANDAMENTO",
  "dataPrevistaEntrega": "2026-06-15T09:00:00"
}
```

### DELETE

```http
DELETE /missoes/1
```

---

# Testes de Exceção

## Drone inexistente

```json
{
  "regiaoId": 1,
  "droneId": 999,
  "dataPrevistaEntrega": "2026-06-10T14:00:00"
}
```

Retorno esperado:

```text
Drone não encontrado
```

Status:

```http
404 NOT FOUND
```

---

## Região inexistente

```json
{
  "regiaoId": 999,
  "droneId": 1,
  "dataPrevistaEntrega": "2026-06-10T14:00:00"
}
```

Retorno esperado:

```text
Região não encontrada
```

Status:

```http
404 NOT FOUND
```

---

# Conclusão

O projeto Space Logistics API apresenta uma solução inspirada na logística espacial para auxiliar o transporte de suprimentos em regiões isoladas. A aplicação utiliza conceitos de Programação Orientada a Objetos, arquitetura em camadas, persistência de dados e APIs REST para fornecer uma solução organizada, escalável e alinhada aos objetivos da Global Solution.
