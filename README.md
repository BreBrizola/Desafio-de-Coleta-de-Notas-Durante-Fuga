# Desafio de Circuitos: Fuga de Assaltantes

## Introdução
O trabalho proposto consiste em implementar um pequeno desafio envolvendo circuitos que representam a fuga de assaltantes, onde a polícia deve coletar cédulas perdidas durante o percurso. Essa atividade visa estimular o raciocínio lógico dos estudantes e aplicar os conteúdos aprendidos em sala de aula, promovendo também o desenvolvimento de habilidades de análise e síntese.

## Problema
O desafio proposto consiste em analisar os mapas fornecidos pela equipe de perícia após um assalto a banco, onde os bandidos durante sua fuga deixaram uma trilha de notas pelo caminho. A polícia precisa seguir essa trilha e recolher o dinheiro deixado para trás pelos criminosos. Para resolver o problema, é necessário identificar a quantidade de dinheiro recuperada pela polícia, considerando as informações contidas nos mapas, como a trilha deixada pelos bandidos, os locais onde o dinheiro foi encontrado e o ponto de captura dos criminosos. Ao final, será contabilizado os valores recolhidos pelo caminho e apresentada a quantia total recuperada.

## Processo de Solução
O trabalho foi desenvolvido em Java, linguagem padrão utilizada em sala de aula. Para fazer o mapeamento do circuito, foi desenvolvido o método `analisarMapa`, que possui dois principais loops:

1. O primeiro encontra a primeira linha do mapa, que é a linha que possui o caractere `-`, indicando o início do mapa.
2. O segundo loop, que é o loop principal, percorre o mapa, começando da linha de início encontrada no mapa. Foi utilizado o loop `while` que vai percorrer o mapa até o caractere `#` ser encontrado, indicando o fim do mapa.

Para cada caractere no mapa, fazemos uma validação:
- Verificamos se o caractere encontrado é um `-`, `|`, um dígito (valor) ou um caractere que indica algum movimento do circuito (`/` ou `\`). A direção do movimento é ajustada conforme esses caracteres de movimentação são encontrados no circuito.

Foi utilizado `StringBuilder` para auxiliar na construção do caminho percorrido. Esse caminho é convertido em uma string, e os números encontrados pelo caminho são empilhados em uma pilha. Essa pilha é percorrida e soma todos os valores; por fim, o valor e o mapa são impressos na tela.

## Conclusão
Inicialmente, tivemos problemas para definir uma estrutura adequada para o projeto. A falta de um plano claro e uma visão abrangente do escopo do projeto dificultaram a criação de um caminho a seguir, resultando em um pequeno atraso na implementação. 

Além disso, tivemos que lidar com bugs e erros que surgiam durante o desenvolvimento. A complexidade do código resultou em tempo considerável em depuração e resolução de problemas.

Em resumo, as dificuldades enfrentadas ao longo do trabalho incluíram problemas de lidar com bugs e erros técnicos.
