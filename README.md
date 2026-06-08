# AstroRail API

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

O projeto AstroRail API foi desenvolvido inspirado nos sistemas de logística utilizados em missões espaciais.

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
| GET    | http://localhost:8080/regioes      |
| GET    | http://localhost:8080/regioes/{id} |
| POST   | http://localhost:8080/regioes      |
| PUT    | http://localhost:8080/regioes/{id} |
| DELETE | http://localhost:8080/regioes/{id} |

---

## Drone

| Método | Endpoint     |
| ------ | ------------ |
| GET    | http://localhost:8080/drones      |
| GET    | http://localhost:8080/drones/{id} |
| POST   | http://localhost:8080/drones      |
| PUT    | http://localhost:8080/drones/{id} |
| DELETE | http://localhost:8080/drones/{id} |

---

## Missão

| Método | Endpoint      |
| ------ | ------------- |
| GET    | http://localhost:8080/missoes      |
| GET    | http://localhost:8080/missoes/{id} |
| POST   | http://localhost:8080/missoes      |
| PUT    | http://localhost:8080/missoes/{id} |
| DELETE | http://localhost:8080/missoes/{id} |

---

# Evidências de Testes

## Testes de Região

### POST

```http
POST http://localhost:8080/regioes
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
<img width="1103" height="483" alt="image" src="https://github.com/user-attachments/assets/828ee106-cf78-4cbb-ac28-51b626ac5288" />


### GET

```http
GET http://localhost:8080/regioes
```
<img width="1068" height="478" alt="image" src="https://github.com/user-attachments/assets/3a993617-6535-4e27-9d86-83fff9934ce8" />


### GET POR ID

```http
GET http://localhost:8080/regioes/1
```
<img width="1041" height="505" alt="image" src="https://github.com/user-attachments/assets/2341a0e4-9743-4ab1-aa84-a569e711b264" />


### PUT

```http
PUT http://localhost:8080/regioes/1
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
<img width="1121" height="501" alt="image" src="https://github.com/user-attachments/assets/70ad75e7-3e68-4349-9317-95fcc9d6e67f" />


### DELETE

```http
DELETE http://localhost:8080/regioes/1
```
<img width="1017" height="518" alt="image" src="https://github.com/user-attachments/assets/159b9bfd-8cfd-4c64-a785-46ce76965cd6" />


---

## Testes de Drone

### POST

```http
POST http://localhost:8080/drones
```

```json
{
  "nome": "Drone Alpha",
  "capacidadeCarga": 50,
  "status": "DISPONIVEL",
  "bateria": 90
}
```
<img width="1045" height="467" alt="image" src="https://github.com/user-attachments/assets/0cc5589b-d623-4ee5-bdae-4a6d89f2c406" />


### GET

```http
GET http://localhost:8080/drones
```
<img width="1023" height="470" alt="image" src="https://github.com/user-attachments/assets/8d3c2329-c5d0-4eed-a26a-c8e9ff705861" />


### GET POR ID

```http
GET http://localhost:8080/drones/1
```
<img width="1012" height="450" alt="image" src="https://github.com/user-attachments/assets/3692b9e9-d523-4013-9753-59c7f24adc35" />


### PUT

```http
PUT http://localhost:8080/drones/1
```

```json
{
  "nome": "Drone Beta",
  "capacidadeCarga": 70,
  "status": "EM_ROTA",
  "bateria": 100
}
```
<img width="1002" height="441" alt="image" src="https://github.com/user-attachments/assets/13e6f82e-a200-4b2c-a612-26628506d4a8" />


### DELETE

```http
DELETE http://localhost:8080/drones/1
```
<img width="992" height="440" alt="image" src="https://github.com/user-attachments/assets/acb8f74e-a8fd-4fdc-83b4-7cba3c5f4345" />


---

## Testes de Missão

### POST

```http
POST http://localhost:8080/missoes
```

```json
{
  "regiaoId": 1,
  "droneId": 1,
  "dataPrevistaEntrega": "2026-06-10T14:00:00"
}
```
<img width="1110" height="707" alt="image" src="https://github.com/user-attachments/assets/9e175a8b-a99b-4eac-9261-f560faa2cb94" />


### GET

```http
GET http://localhost:8080/missoes
```
<img width="1103" height="755" alt="image" src="https://github.com/user-attachments/assets/91edb467-f953-48cc-87c6-98a28ca3cc1a" />


### GET POR ID

```http
GET http://localhost:8080/missoes/1
```
<img width="1090" height="721" alt="image" src="https://github.com/user-attachments/assets/c9983bea-a2c5-4afc-ad93-721a15a947f4" />


### PUT

```http
PUT http://localhost:8080/missoes/1
```

```json
{
  "status": "EM_ANDAMENTO",
  "dataPrevistaEntrega": "2026-06-15T09:00:00"
}
```
<img width="1113" height="666" alt="image" src="https://github.com/user-attachments/assets/d3b9a6a7-f676-4cb7-b8b7-694b2302875d" />


### DELETE

```http
DELETE http://localhost:8080/missoes/1
```
<img width="1012" height="437" alt="image" src="https://github.com/user-attachments/assets/1de465b5-f3d7-4268-8463-a8bc446f1ed6" />


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
<img width="988" height="366" alt="image" src="https://github.com/user-attachments/assets/d023ea95-7224-4c97-bfbe-58fba52117cf" />


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
<img width="1071" height="400" alt="image" src="https://github.com/user-attachments/assets/88e463a5-3a56-4781-9791-089cdcfedffb" />


---

# Conclusão

O projeto AstroRail API apresenta uma solução inspirada na logística espacial para auxiliar o transporte de suprimentos em regiões isoladas. A aplicação utiliza conceitos de Programação Orientada a Objetos, arquitetura em camadas, persistência de dados e APIs REST para fornecer uma solução organizada, escalável e alinhada com os requisitos da GS.
