package com.saboria.lanchonete.data.repository

import com.saboria.lanchonete.data.local.ProdutoDao
import com.saboria.lanchonete.data.local.VendaDao
import com.saboria.lanchonete.data.local.UsuarioDao
import com.saboria.lanchonete.data.local.entity.ProdutoEntity
import com.saboria.lanchonete.data.local.entity.VendaEntity
import com.saboria.lanchonete.data.local.entity.UsuarioEntity
import com.saboria.lanchonete.domain.model.Produto
import com.saboria.lanchonete.domain.model.Venda
import com.saboria.lanchonete.domain.model.Usuario
import com.saboria.lanchonete.domain.repository.ProdutoRepository
import com.saboria.lanchonete.domain.repository.VendaRepository
import com.saboria.lanchonete.domain.repository.UsuarioRepository

class ProdutoRepositoryImpl(private val dao: ProdutoDao) : ProdutoRepository {
    override suspend fun obterTodos(): List<Produto> {
        return dao.obterTodos().map { it.toDomainModel() }
    }

    override suspend fun obterPorId(id: String): Produto? {
        return dao.obterPorId(id)?.toDomainModel()
    }

    override suspend fun obterPorCategoria(categoria: String): List<Produto> {
        return dao.obterPorCategoria(categoria).map { it.toDomainModel() }
    }

    override suspend fun inserir(produto: Produto) {
        dao.inserir(produto.toEntity())
    }

    override suspend fun atualizar(produto: Produto) {
        dao.atualizar(produto.toEntity())
    }

    override suspend fun deletar(id: String) {
        dao.deletar(id)
    }

    override suspend fun obterEstoqueBaixo(): List<Produto> {
        return dao.obterEstoqueBaixo().map { it.toDomainModel() }
    }

    private fun ProdutoEntity.toDomainModel() = Produto(
        id = id,
        nome = nome,
        descricao = descricao,
        categoria = categoria,
        preco = preco,
        estoque = estoque,
        estoqueMinimo = estoqueMinimo,
        dataVencimento = dataVencimento,
        ativo = ativo
    )

    private fun Produto.toEntity() = ProdutoEntity(
        id = id,
        nome = nome,
        descricao = descricao,
        categoria = categoria,
        preco = preco,
        estoque = estoque,
        estoqueMinimo = estoqueMinimo,
        dataVencimento = dataVencimento,
        ativo = ativo
    )
}