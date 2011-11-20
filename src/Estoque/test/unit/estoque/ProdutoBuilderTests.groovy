package estoque
import estoque.builder.ProdutoBuilder
import grails.test.*

class ProdutoBuilderTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCriarProduto() {
		def builder = new ProdutoBuilder()
		def resultado = builder.produto(nome:"Produto de teste") {
			categoria(nome:"Categoria de teste")
			fornecedor(nome:"Fornecedor quente", email:"email@email.com")
		}
		
		
		assertNotNull "N�o retornou resultado algum", resultado
		assertTrue "N�o retornou um produto", (resultado instanceof Produto)
		assertNotNull "N�o foi definida a categoria", resultado.categoria
		assertEquals "Nome inesperado para categoria", "Categoria de teste", resultado.categoria.nome
		assertNotNull "N�o foi definido o fornecedor do produto", resultado.fornecedor
		assertEquals "N�o foi definido o nome esperado", "Fornecedor quente", resultado.fornecedor.nome
		assertEquals "N�o foi definido o email do fornecedor", "email@email.com", resultado.fornecedor.email
    }
}
