# Considerações sobre atribuições, Generics e outras coisinhas...

<details>
<summary><strong>Atribuição e referência em Java</strong></summary>

- Atribuições em Java são **sempre** feitas por cópias de valor. Quando trata-se dos tipos primitivos, o valor em
  memória é copiado. Por outro lado, no caso de Objetos, o valor da referência deste em memória é copiado; e, sendo
  assim, o Objeto não é duplicado.
</details>

<details>
<summary><strong>Generics</strong></summary>

- Evita uso excessivo de casting e redundância de código
- Encontrar erros em tempo de compilação
- introduzido deste o Java SE 5.0
</details>

<details>

<summary><strong>Wildcards</strong></summary>

> Lorem ispum

### Unknown Wildcard (Unbounded)

- Tipo mais genérico possível.

```java

// função genérica que imprime uma lista de "qualquer coisa"
public void imprimeLista(List<?> lista){
        for(Object obj:lista){
        System.out.println(obj);
        }
        }

        List<Aluno> minhaLista=new List<Aluno>();
        imprimeLista(minhaLista);
```

## Bounded Wildcard

### Upper Bounded

- "Coringas limitados por cima". Em outras palavras, a generalização funciona apenas para um tipo ``T`` específico e
  seus descendentes (herdeiros).

```java

// função genérica que imprime uma lista de objetos
// do tipo Pessoa ou de seus herdeiros 
public void imprimeLista(List<?extends Pessoa> listaPessoas){
        for(Pessoa p:listaPessoas){
        System.out.println(p);
        }
        }

        List<Aluno> minhaLista=new List<Aluno>();
        imprimeLista(minhaLista);
```

### Lower Bounded

- "Coringas limitados por baixo". Em outras palavras, a generalização funciona apenas para um tipo ``T`` específico e
  seus
  ascendentes.

```java

// função genérica que imprime uma lista de objetos
// do tipo Pessoa ou antecessores
public void imprimeLista(List<? super Pessoa>listaPessoas){
        for(Pessoa p:listaPessoas){
        System.out.println(p);
        }
        }

        List<Aluno> minhaLista=new List<Aluno>();
// como Aluno seria um herdeiro de Pessoa, esse método não irá funcionar e apresentará erro
// em tempo de compilação: 
        imprimeLista(minhaLista);

        List<Humano> minhaListaDeHumanos=new List<Humano>();
// como Humano é um super tipo (classe mãe) de Pessoa, esse método irá funcionar normalmente,
// pois Pessoa estende de Humano:: 
        imprimeLista(minhaListaDeHumanos); 
```

## Convenções para utilização de Generics

- **K** para "Key". Exemplo: ``Map<K,V>``
- **V** para "Value". Exemplo: ``Map<K,V>``
- **E** para "Element". Exemplo: ``List<E>``
- **T** para "Type". Exemplo: ``Collection#addAll``
- **?** é o tipo mais genérico possível, portanto, usado para representar qualquer tipo.

</details>

----

# Estruturas de Dados

> Lorem ipsum

<details>
<summary><strong>Nó e encadeamento de Nó</strong></summary>

> Antes de abordamos as estruturas de dados em si, é necessário entender o conceito de Nó e encadeamento de Nó:

- Um Nó é um espaço em memória, responsável por armazenar tanto o dado que se deseja armezenar quanto uma referência
  para um próximo Nó;
- Portanto, a partir da referência para um próximo Nó que está armazenada dentro de um Nó anterior, é possível criar o
  que chamamos de **encadeamento de Nós**. Em outras palavras, criar uma sequência de Nós onde estão "amarrados" uns aos
  outros;
- Seguindo esta lógica, num encadeamento simples, o último Nó aponta para uma referência nula! Isso significa que não há
  um outro Nó depois dele, indicando assim que a lista chegou ao fim;
- Esse tipo de ligação nos permite criar o que chamados de estruturas de dados, sendo as mais conhecidas: Pilha, Fila,
  Listas (Simplesmente Encadeada, Duplamente Encadeadas, e Circulares), Árvores.

Abaixo, estarão breves explicações sobre algumas dessas estruturas.

</details>

<details>
<summary><strong>Pilha (LIFO)</strong></summary>

## Conceito:

- O conceito de pilha enquanto estrutura de dados assemelha-se a uma pilha de livros, por exemplo. A rigor, uma pilha
  precisa se comportar de algumas formas:
    - A inserção de um novo elemento sempre se dá no topo da pilha;
    - O último elemento a ser inserido na pilha é o primeiro a sair. Daí, essa estrutura também é considerada do tipo 
    **LIFO**, isto é, _**Last In, First Out**_;
    - Dentro de uma pilha, um Nó que está mais ao topo aponta para o Nó anterior a si mesmo;
    - O primeiro Nó (isto é, o primeiro Nó a ter sido inserido) deve apontar para `null`;
    - O elemento que está no topo da pilha deve conter uma referência que aponta para si.

## Métodos da pilha:

### .top()

Esse método serve para acessar o primeiro Nó da pilha, mas sem removê-lo da estrutura. o exemplo de código abaixo
demostra que a variiável ``meuNo`` guarda o valor de referência do No que está no topo da pilha.

```java 
No meuNo=pilha.top();
```

A partir desta referência, é possível acessar o valor contido no No e, então, poder atribuí-lo a alguma variável. O
código abaixo demonstra esse exemplo.

```java 
int numero=meuNo.getInt();
```

### .pop()

Semelhante ao método ``.top()``, o `.pop()` também tem a intenção de acessar a referência do topo da pilha. Porém, ao
fazer isto, este método remove o No do topo da pilha. Neste caso, a referência do topo é realocada para que seja
apontada para o No anterior àquele que foi removido.

### .push()

Ao contrário do método ``.pop()``, este método tem o objetivo de inserior um novo No à pilha. Neste cenário, a
referência de próximo Nó do Nó que foi inserido deve apontar não para ``null``, mas sim para o Nó abaixo.
Consequentemente, a referência de topo deve passar a apontar para o Nó que fora inserido.

### .isEmpty()

Verifica se a referência de entrada para pilha está nula. O valor retornado deve ser um ``booleano``.

</details>


<details>
<summary><strong>Fila (FIFO)</strong></summary>

## Conceito:

- O conceito de fila enquanto estrutura de dados assemelha-se a uma fila de pessoas para serem atendidas num balcão de
  vendas de ingressos, por exemplo. A rigor, uma fila precisa se comportar de algumas formas:
  - A inserção de um novo elemento sempre se dá no final da fila;
  - O primeiro elemento a ser inserido na fila é o primeiro a sair. Daí, essa estrutura também é considerada do tipo *
    *FIFO**, isto é, _**First In, First Out**_
  - O primeiro Nó sempre deve apontar para `null`;
  - O Nó que sucede o primeiro deve apontar para um outro Nó que é também seu sucessor;
  - O último Nó da fila deve possuir uma referência de entrada da fila;

## Métodos da fila:

### .enqueue()

Método responsável por enfileirar (isto é, inserir) um novo Nó na fila. Neste caso, o novo Nó deve ser colocado no final
da fila. Neste caso, este Nó deve possuir uma referência de próximo para o antigo Nó que estava no final da fila, e a
referência de entrada da fila deve passar a apontar para este Nó que foi inserido.

### .dequeue()

Método responsável por desenfileirar (isto é, remover) o Nó que está na primeira posição da fila. Neste caso, o Nó
imediatamente anterior àquele que foi removido passa a ser o primeiro elemento da fila e, portanto, passa a apontar para
``null``.

### .isEmpty()

Verifica se a referência de entrada para fila está nula. O valor retornado deve ser um ``booleano``.

</details>


<details>
<summary><strong>Lista Encadeada Simples</strong></summary>

## Conceito:

- Assemalha-se à estrutura de fila, porém suas regras de inserção e remoção são um pouco diferentes.

## Métodos da lista encadeada simples:

### .add()

Método responsável por inserir um novo Nó na fila. Entretanto, ao contrário das outras estruturas abordadas acima, na
qual existe uma regra pré-definida no que se refere a inserção ou remoção de um novo item, nas listas encadeadas simples
devemos informar em qual índice queremos inserir esse novo elemento. Em outras palavras, podemos dizer que a inserção é
dinâmica.

### .remove()

Método responsável por remover um Nó da estrutura. Semelhante ao método ``.add()``, a remoção pode ocorrer
dinamicamente, isto é, devemos informar qual índice será removido.

### .get()

Obtem uma "cópia" (ou seja, obtem-se a referência) de um Nó que está num determinado índice informado. Neste caso, esse
método deve receber como parâmetro um número inteiro referente ao índice do Nó que se deseja obter as informações.

### .size()

Retorna o tamanho da lista.

### .isEmpty()

Verifica se a referência de entrada para fila está nula. O valor retornado deve ser um ``booleano``.

</details>

<details>
  <summary><strong>Lista Duplamente Encadeada</strong></summary>

## Conceito:

- A principal diferença enttre a lista encadema e a duplamente encadeda, é que na dupla encadeada, cada Nó possui duas
  refs: uma referência o Nó anterior e uma outra para um segundo Nó posterior
- Assim, dado um Nó, sua ref de anterior deve apontar para a ref. de Próximo
- No último Nó da lista, a referência de próximo deve apontar para ``null``, e da mesma forma, a ref. de anterior do
  primeiro Nó precisa apontar para ``null``
- É imporante notar que, nesta estrutura, há duas referências de entrada na lista: um no início desta e uma outra no
  final;

</details>

----


