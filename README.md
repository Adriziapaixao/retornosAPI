# CRUD de Produtos com Validações

Este projeto implementa um sistema CRUD para gerenciar produtos, com validações nos campos obrigatórios.

## Requisitos do Produto
- **Nome**: Obrigatório, entre 3 e 100 caracteres.
- **Descrição**: Opcional, máximo de 500 caracteres.
- **Preço**: Obrigatório, número maior que 0.
- **Quantidade em Estoque**: Obrigatório, número inteiro maior ou igual a 0.
- **Categoria**: Obrigatório, deve ser uma das opções pré-definidas (Eletrônicos, Roupas, Alimentos).

# Endpoints da API

## Criar Produto
- **POST** `/api/products`
- **Descrição**: Cria um novo produto.
- **Body (JSON)**:
  ```json
  {
    "name": "Produto Exemplo",
    "description": "Descrição do produto",
    "price": 100.0,
    "quantity": 10,
    "category": "Eletrônicos"
  }
### Buscar Produto por ID ###
**GET /api/products/{id}**:
- Descrição: Retorna os detalhes de um produto específico.

Parâmetros:
- id (Path Variable): ID do produto a ser buscado.
- Resposta (200 OK):

    ```json
  {
    "id": 1
    "name": "Produto Exemplo",
    "description": "Descrição do produto",
    "price": 100.0,
    "quantity": 10,
    "category": "Eletrônicos"
  }
  

- Resposta (404 Not Found):

  {
  "error": "Produto não encontrado"
  }

### Atualizar Produto ### 
**PUT /api/products/{id}**:
- Descrição: Atualiza os dados de um produto existente.
Parâmetros:
- id (Path Variable): ID do produto a ser atualizado.
  - Resposta (200 OK):

   ```json
  {
    "name": "Produto Atualizado",
    "description": "Nova descrição",
    "price": 150.0,
    "quantity": 5,
    "category": "Roupas"
    }

- Resposta (404 Not Found):
    
  ```json
  {
    "id": 1,
    "name": "Produto Atualizado",
    "description": "Nova descrição",
    "price": 150.0,
    "quantity": 5,
    "category": "Roupas"
    }

- Resposta (404 Not Found):

    ```json
  {
    "error": "Produto não encontrado"
  }

### Excluir Produto ###
**DELETE /api/products/{id}**:
- Descrição: Remove um produto do sistema.

Parâmetros:
- id (Path Variable): ID do produto a ser excluído.
- Resposta (204 No Content): Sem conteúdo no corpo da resposta.
- Resposta (404 Not Found):

    ```json
  {
    "error": "Produto não encontrado"
  }
