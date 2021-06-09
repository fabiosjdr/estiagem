# Desafio JAVA 
Desafio estiagem

# Desfio estiagem

Devido às constantes estiagens que aconteceram nos últimos tempos em algumas regiões do Brasil, o
governo federal criou um órgão para a avaliação do consumo destas regiões com finalidade de verificar o
comportamento da população na época de racionamento. Este órgão responsável irá pegar algumas
cidades (por amostragem) e verificará como está sendo o consumo de cada uma das pessoas da cidade e o
consumo médio de cada cidade por habitante.<br><br>
Entrada<br>
A entrada contém vários casos de teste. A primeira linha de cada caso de teste contém um inteiro N (1 ≤ N
≤ 1*106), indicando a quantidade de imóveis. As N linhas contém um par de valores X (1 ≤ X ≤ 10) e Y (1 ≤
Y ≤ 200), indicando a quantidade de moradores de cada imóvel e o respectivo consumo total de cada
imóvel (em m3). Com certeza, nenhuma residência consome mais do que 200 m3 por mês. O final da
entrada é representado pelo número zero.<br><br>
Saída<br>
Para cada entrada, deve-se apresentar a mensagem “Cidade# n:”, onde n é o número da cidade seguindo a
sequência (1, 2, 3, ...) e em seguida deve-se listar, por ordem ascendente de consumo, a quantidade de
pessoas seguido de um hífen e o consumo destas pessoas, arredondando o valor para baixo. Na terceira
linha da saída deve-se mostrar o consumo médio por pessoa da cidade, com 2 casas decimais sem
arredondamento, considerando o consumo real total. Imprimir uma linha em branco entre dois casos de
teste consecutivos. No fim da saída não deve haver uma linha em branco.<br><br>
Exemplo de Entrada<br>
3<br>
3 22<br>
2 11<br>
3 39<br>
5<br>
1 25<br>
2 20<br>
3 31<br>
2 40<br>
6 70<br>
2<br>
1 1<br>
3 2<br>
0<br>
<br>
Exemplo de Saída<br>
Cidade# 1:<br>
2-5 3-7 3-13<br>
Consumo medio: 9.00 m3.<br>
Cidade# 2:<br>
5-10 6-11 2-20 1-25<br>
Consumo medio: 13.28 m3.<br>
Cidade# 3:<br>
3-0 1-1<br>
Consumo medio: 0.75 m3.<br>
