# Chat RMI

Aplicação de chat em tempo real utilizando **Java RMI (Remote Method Invocation)**, com interface gráfica Swing. Permite que múltiplos usuários se conectem a um servidor central e troquem mensagens em tempo real.

## Como funciona

A arquitetura segue o padrão cliente-servidor via RMI:

- O **Servidor** expõe um objeto remoto (`Chat`) no registro RMI na porta `1099`
- O **Cliente** localiza esse objeto remoto e se registra, expondo também seu próprio objeto remoto (`ICliente`)
- Quando uma mensagem é enviada, o servidor itera sobre todos os clientes registrados e chama o método remoto `atualizarMensagens()` em cada um — atualizando a interface de todos em tempo real

```
[Cliente A] ──registra──▶ [Servidor RMI :1099]
[Cliente B] ──registra──▶ [Servidor RMI :1099]

[Cliente A] ──enviarMensagem()──▶ [Servidor]
                                      │
                    ┌─────────────────┴──────────────────┐
                    ▼                                     ▼
             atualizarMensagens()              atualizarMensagens()
             [Cliente A]                       [Cliente B]
```

## Estrutura do projeto

```
chat-rmi/
├── chat/
│   ├── Chat.java        # Interface remota do servidor
│   ├── ICliente.java    # Interface remota do cliente
│   ├── Servidor.java    # Implementação do servidor RMI
│   ├── Cliente.java     # Implementação do cliente RMI
│   └── rmiregistry.exe  # Executável do registro RMI (Windows)
└── view/
    ├── Entrar.java      # Tela de login
    ├── Mensagem.java    # Tela principal do chat
    └── Historico.java   # Tela de histórico de mensagens
```

## Interfaces RMI

**`Chat` (Servidor)**
| Método | Descrição |
|---|---|
| `registrarCliente(ICliente)` | Registra um novo cliente no servidor |
| `entrarChat(ICliente, String)` | Notifica todos que o usuário entrou |
| `sairChat(ICliente, String)` | Remove o cliente e notifica os demais |
| `enviarMensagem(String, String)` | Envia mensagem para todos os clientes |
| `obterMensagens()` | Retorna o histórico completo de mensagens |

**`ICliente` (Cliente)**
| Método | Descrição |
|---|---|
| `atualizarMensagens(String)` | Recebe uma nova mensagem em tempo real |
| `atualizarConexoes(List<String>)` | Atualiza a lista de usuários conectados |

## Pré-requisitos

- Java JDK 8 ou superior
- IDE com suporte a Swing (NetBeans recomendado, pois os `.form` foram gerados nele)

## Como executar

### 1. Compilar o projeto

```bash
javac chat/*.java view/*.java
```

### 2. Iniciar o Servidor

Execute a classe `Servidor`:

```bash
java chat.Servidor
```

Saída esperada:
```
Servidor de Chat pronto...
```

O servidor cria o registro RMI na porta `1099` e fica aguardando conexões.

### 3. Iniciar o(s) Cliente(s)

Em outro terminal (ou outra máquina na mesma rede), execute:

```bash
java chat.Cliente
```

A tela de login será aberta. Repita esse passo para cada usuário que quiser entrar no chat.

> **Obs:** por padrão o cliente conecta em `localhost:1099`. Para conectar em outro host, altere o endereço em `Cliente.registrarCliente()`.

## Fluxo de uso

1. O usuário abre o cliente e insere seu nome na tela **Entrar**
2. Ao clicar em **Entrar** (ou pressionar `Enter`), o cliente é registrado no servidor e entra no chat
3. Na tela **Mensagem**, o usuário pode:
   - Ver as mensagens em tempo real
   - Ver a lista de usuários conectados
   - Digitar e enviar mensagens (botão **Enviar** ou `Enter`)
   - Acessar o **Histórico de Mensagens** completo da sessão
   - Clicar em **Sair** para se desconectar
4. Ao sair, todos os outros usuários são notificados

## Tecnologias utilizadas

- **Java RMI** — comunicação remota entre processos
- **Java Swing** — interface gráfica
- **UnicastRemoteObject** — exportação dos objetos remotos
- **RMI Registry** — serviço de nomes para localizar o servidor
