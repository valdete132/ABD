# BibliotecaJPA

* _Projeto em desenvolvimento_

## Pacote dao

Pacote contendo as classes utilizadas para acesso aos dados do banco.

### Classe DAO

Interface com métodos básicos para acesso aos dados armazenados no banco. Todas as classes que fazem acesso ao banco devem implementar esta interface.

```java
public interface DAO<T> {
    default public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence
                        .createEntityManagerFactory("biblioteca");
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }

    T findById(int id);
    List<T> findAll();
    void insert(T t);
    void update(T t);
    void delete(T t);
}
```

### Classes AlunoDAO, EmprestimoDAO e PublicacaoDAO

As classes `AlunoDAO`, `EmprestimoDAO` e `PublicacaoDAO` acessam as tabelas Aluno, Emprestimo e Publicacao, respectivamente, utilizando JPA.


Este método busca um aluno por meio de sua chave primária.

```java
    @Override
    public Aluno findById(int id) {
        return entityManager.find(Aluno.class, id);
    }
```

Retorna uma lista com todas as entradas da tabela Aluno.

```java
    @Override
    public List<Aluno> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Aluno.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
```

Adiciona um novo aluno ao banco de dados.

```java
    @Override
    public void insert(Aluno t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(t);
        transaction.commit();
    }
```

Atualiza uma linha da tabela Aluno.

```java
    @Override
    public void update(Aluno t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(t);
        transaction.commit();
    }
```

Remove um aluno do banco.

```java
    @Override
    public void delete(Aluno t) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Aluno a = entityManager.find(Aluno.class, t.getMatriculaAluno());
        entityManager.remove(a);
        transaction.commit();
    }
```

## Pacote entidades

Aqui temos as classes, cujas instâncias guardam os dados extraídos do banco.

### Classe Aluno

Atributos e construtores.

```java
    @Id
    private int matriculaAluno;
    private String nome;
    @OneToMany
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Aluno() { }

    public Aluno(int matriculaAluno, String nome) {
        this.matriculaAluno = matriculaAluno;
        this.nome = nome;
    }
```

### Classe Emprestimo

Atributos e construtores

```java
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmprestimo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucao;
    
    @ManyToOne
    private Aluno aluno;

    public Emprestimo() { }

    public Emprestimo(Date dataEmprestimo, Date dataDevolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
```

### Classe Publicacao

Atributos e construtores.


```java
    @Id
    private int codigoPub;
    private String titulo;
    private int ano;
    private String autor;
    private String tipo;

    public Publicacao() { }

    public Publicacao(int codigoPub, String titulo, int ano, String autor, String tipo) {
        this.codigoPub = codigoPub;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.tipo = tipo;
    }
```

## Arquivo persistence.xml

Este arquivo contém as definições para conexão com o banco usando JPA.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
  <persistence-unit name="biblioteca" transaction-type="RESOURCE_LOCAL">
    <class>entidades.Aluno</class>
    <class>entidades.Emprestimo</class>
    <class>entidades.Publicacao</class>
    <properties>
      <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/biblioteca"/>
      <property name="javax.persistence.jdbc.user" value="sa"/>
      <property name="javax.persistence.jdbc.password" value=""/>
      <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
      <property name="javax.persistence.schema-generation.database.action" value="create"/>
    </properties>
  </persistence-unit>
</persistence>
```

## Arquivo scripts.sql

Conjunto de códigos SQL para inicialização das tabelas no banco de dados h2.

_**Atenção**: Este arquivo está incompleto e pode conter erros._

## Classe Biblioteca

Classe executável utilizada para inserir, remover, alterar e consultar o banco de dados via linha de comando.

_**Atenção**: Esta classe está incompleta e contém inconsistencias._
