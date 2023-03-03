# Atribuição e referência em Java

- Atribuições em Java são sempre feitas por cópias de valor. Quando trata-se dos tipos primitivos, o valor em memória é
  copiado. Por outro lado, no caso de objetos, o valor da referência deste em memória é copiado; e, sendo assim, o
  objeto não é duplicado.

# Conceito de Nó e encadeamento de nó

- Um Nó é um espaço em memória, responsável por armazenar tanto o dado que se deseja armezenar quanto uma referência
  para um próximo Nó.
- Portanto, a partir da referência para um próximo Nó que está armazenada dentro de um Nó anterior, permite criar o que
  chamamos de encadeamento de Nós.
- Seguindo esta lógica, num encadeamento simples, o último Nó aponta para uma referência nula!
-

# Generics

- Evita uso excessivo de casting e redundância de código
- Encontrar erros em tempo de compilação
- introduzido deste o Java SE 5.0

## Wildcards

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

### Bounded Wildcard (Upper Bounded / Lower Bounded)

#### Upper Bounded

- "Coringas limitados por cima". Em outras palavras, a generalização funciona apenas para um tipo T específico e seus
  descendentes (herdeiros).

```java

// função genérica que imprime uma lista de objetos
// do tipo Pessoa ou de seus herdeiros 
public void imprimeLista(List<? extends Pessoa> listaPessoas){
        for(Pessoa p : listaPessoas){
            System.out.println(p);
        }
}

List<Aluno> minhaLista=new List<Aluno>();
imprimeLista(minhaLista);
```

#### Lower Bounded

- "Coringas limitados por baixo". Em outras palavras, a generalização funciona apenas para um tipo T específico e seus
  ascendentes.

```java

// função genérica que imprime uma lista de objetos
// do tipo Pessoa ou antecessores
public void imprimeLista(List<? super Pessoa> listaPessoas){
        for(Pessoa p : listaPessoas){
            System.out.println(p);
        }
}

List<Aluno> minhaLista = new List<Aluno>();
// como Aluno seria um herdeiro de Pessoa, esse método não irá funcionar e apresentará erro
// em tempo de compilação: 
imprimeLista(minhaLista);

List<Humano> minhaListaDeHumanos = new List<Humano>();
// como Humano é um super tipo (classe mãe) de Pessoa, esse método irá funcionar normalmente,
// pois Pessoa estende de Humano:: 
imprimeLista(minhaListaDeHumanos); 
```

### Convenções para utilização de Generics

- **K** para "Key". Exemplo: ``Map<K,V>``
- **V** para "Value". Exemplo: ``Map<K,V>``
- **E** para "Element". Exemplo: ``List<E>``
- **T** para "Type". Exemplo: ``Collection#addAll``
- **?** é o tipo mais genérico possível, portanto, usado para representar qualquer tipo.
