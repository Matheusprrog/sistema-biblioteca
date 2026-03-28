# 📚 Sistema de Biblioteca
 
Sistema de gerenciamento de biblioteca desenvolvido em Java, aplicando conceitos de Programação Orientada a Objetos (POO). O projeto foi desenvolvido como exercício prático de POO, resultando em um sistema funcional com autenticação, controle de acesso por perfil e gerenciamento completo de livros e usuários.
 
---
 
## 🚀 Funcionalidades
 
### Perfil Administrador
- Login com validação de credenciais
- Adicionar e remover livros do acervo
- Adicionar e remover usuários do sistema
- Visualizar lista completa de livros e usuários
 
### Perfil Cliente
- Login com validação de credenciais
- Navegar pelo acervo por categoria
- Visualizar detalhes do livro
- Realizar empréstimo com data de devolução
- Livro fica indisponível após empréstimo
 
---
 
## 🗂️ Estrutura do Projeto
 
```
src/biblioteca/
├── enums/
│   ├── Cargo.java         # Perfis: ADMINISTRADOR, COMUM
│   └── Categoria.java     # Categorias: COMEDIA, DRAMA, FICCAO_CIENTIFICA, ROMANCE, TERROR
├── model/
│   ├── Livro.java         # Entidade Livro
│   └── Usuario.java       # Entidade Usuario
├── service/
│   ├── Biblioteca.java    # Gerenciamento do acervo e usuários
│   ├── loginService.java  # Autenticação e controle de acesso
│   ├── MenuAdmin.java     # Menu e ações do administrador
│   └── MenuCliente.java   # Menu e ações do cliente
└── Main.java              # Ponto de entrada da aplicação
```
 
---
 
## 🧠 Conceitos aplicados
 
- Classes e Objetos
- Construtores e palavra-chave `this`
- Enums e constantes
- Organização em pacotes
- ArrayList e coleções
- Modificadores de acesso `public` e `private`
- Composição entre classes
- Princípio de responsabilidade única
- Estruturas de controle: `if/else`, `switch/case`, `while`, `for-each`
- Operador ternário
- Diferença entre `static` e instância
 
---
 
## 🔐 Credenciais padrão
 
| Usuário | Senha | Perfil        |
|---------|-------|---------------|
| admin   | 1234  | Administrador |
| ellen   | 1234  | Comum         |
 
---
 
## ▶️ Como executar
 
**Pré-requisitos:** Java 21+ e IntelliJ IDEA (ou outra IDE de sua preferência)
 
1. Clone o repositório:
```bash
git clone https://github.com/Matheusprrog/sistema-biblioteca.git
```
 
2. Abra o projeto na sua IDE
 
3. Execute o arquivo `Main.java`
 
---
 
## 📖 Acervo inicial
 
O sistema já inicia com 10 livros cadastrados nas categorias: Romance, Terror, Comédia, Ficção Científica e Drama.
 
---
 
## 👨‍💻 Autor
 
**Matheus Araujo Santos**  
Estudante de Análise e Desenvolvimento de Sistemas  
[LinkedIn](https://www.linkedin.com/in/matheusaraujossantos) • [GitHub](https://github.com/Matheusprrog)
 
---
 
## 📌 Próximos passos
 
- [ ] Implementar herança com classe base `Pessoa`
- [ ] Adicionar persistência de dados com arquivo ou banco de dados
- [ ] Aplicar interfaces e classes abstratas
- [ ] Implementar getters e setters com encapsulamento
