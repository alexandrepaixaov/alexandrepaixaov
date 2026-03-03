package com.saboria.lanchonete.domain.model

data class Produto(
    val id: String,
    val nome: String,
    val descricao: String,
    val categoria: String,
    val preco: Double,
    val estoque: Int,
    val estoqueMinimo: Int,
    val dataVencimento: String,
    val ativo: Boolean
)

data class Venda(
    val id: String,
    val data: String,
    val vendedorId: String,
    val items: List<ItemVenda>,
    val subtotal: Double,
    val desconto: Double,
    val total: Double,
    val formaPagamento: String,
    val status: String
)

data class ItemVenda(
    val produtoId: String,
    val quantidade: Int,
    val precoUnitario: Double
)

data class Usuario(
    val id: String,
    val nome: String,
    val email: String,
    val funcao: String,
    val ativo: Boolean
)

data class Estoque(
    val produtoId: String,
    val quantidade: Int,
    val dataUltimaAtualizacao: String
)