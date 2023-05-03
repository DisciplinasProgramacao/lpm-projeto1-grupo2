[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10064412)
# Gestão de Estoque 
O projeto tem como objetivo criar um sistema de gestão de estoque em uma mercearia.


## Nota base do grupo: 8,25

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários

	- Acabaram fragmentando muito o que a priori não teria grandes problemas, porém não conseguiram finalizar o projeto, acabaram complicando um pouco mais do que o necessário

### Diagrama + aderência das classes ao diagrama: 1/2 pontos 
	- incondizencias do diagrama com código.
	Ex: Mercearia uso dos tipos List e ArrayList, addProdutos()
	Venda tipos List e ArrayList, addItemVenda() e addItemVendido() ...


### Requisitos corretamente implementados: 3/6 pontos 
	- produto (preço, estoque) - 1,75 / 2
	Não acredito que seja a melhor estratégia utilizar métodos como por exemplos validarCaracteresProduto() e validaMargemLucro() como forma de apenas lançar exceções
	Não acredito que a forma de cálculo do getValorImposto() esteja correto

	- estoque (valor, abaixo do estoque) - 0,75 / 2
	incompleto


	- sistema (vender, comprar, consultas) - 0,5/2
	Opções: 4. Verificar quantidade de produtos no estoque, 5. Imprimir relatório de produto e 6. Verificar valor total do estoque não implementadas/funcionais


### Documentação de código: 2 pontos 
	Documentação realizada de forma superficial e incompleta. (Alguns métodos sem documentação e sem informar o retorno, ...)
	
### Testes (quantidade e qualidade): 2,25/4 pontos 
	Não documentaram o plano de testes
	Poderiam testar situações de insucesso
	- produto: 1,5/2 pontos
	Interagiram outras classes no produto test
	- estoque: 0,75/2 pontos
	Apenas 3 casos de teste

	Observação:
	O recomendado seria criar uma classe para cada elementos testado, assim como em um source folder diferente
	
## Alunos integrantes da equipe

* Ana Flávia de Souza Ribeiro
* Lucas Alves Rossi Figueira
* Miguel Martins Fonseca da Cruz
* Roberto Lafeta Mendonça 
* Rúbia Coelho de Matos

## Professores responsáveis

* Cleiton Silva Tavares

