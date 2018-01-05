JPA - Java Persistence API
--------------------------

 

-   When you are inside a transaction and you are managing something with the
    Entity Manager(updating,deleting,inserting), that particular thing continues
    to be used/managed by the Entity Manager until the end of the transaction.

-   em.flush() - changes up to that point are sent to the database

-   em.detach(entity2) - changes on entity2 are no longer tracked by the Entity
    Manager

-   em.clear() - another way of not tracking everything that is in Entity
    Manager

-   em.refresh(entity) - refresh with content from database and changes are lost

-   all the entities that are being saved through the Entity Manager are saved
    to something called the Persistence Context

-   Persistence Context - keeps track of all the entities that are changed
    during a specific transaction, and all the changes that need to be stored to
    the database

 

**JPQL** - like SQL but will query the Entities instead of Tables; Entities are
Java classes with [@Entity;] eg. Select c from Course c

eg.

em.createQuery(”Select c From Course c”).getResultList(); - List

em.createQuery(”Select c From Course c”, course.Class.getResultList(); -
TypedQuery

 

\@NamedQuery(name=”query_name”,query=”the_query_itself”)

\@NamedQueries({})

 

**Annotations**

\@Table(name=”table_name”)

\@Column(name=”column_name”, nullable=false)

 

\@UpdateTimestamp/CreationTimestamp - Update Time and Create Time columns
available only using Hibernate

 

 

**Native Queries** - compared to JPQL

-   are SQL statements and can use parameters(with position) and named
    parameters(:id)

-   are fit for massive updates

-   are fit where there is something specific to database

  \@OneToOne - relationship is Eager fetched

 

**Session & Session Factory**

**Entity Manager & Persistence Context**

**Transaction** - everything succeeded or all fail; every time to define a
transaction you also create a Persistence Context; if \\\@Transactional is
missing, each call will act as a separate transaction; at the start of a
transaction a Persistence Context is created; without transaction we don’t have
a database connection

**Persistence Context** - is the place where all the entities which you are
operating upon are stored; all changes are kept track of; acts as 2 things -
store of changes and gives you access to database

**Entity Manager** - is the way we can interact with the Persistent Context;
when you call a method on the Entity Manager you are actually playing with the
Persistence Context; is the interface to the Persistence Context; has one
default transaction

 

In Hibernate Terminology, Session = Persistence Context

 

\@DirtiestContext in \@Test will leve the data in the consistent state. All the
changes that are made in the test will be rolled back.

 

\@ManyToOne and \@OneToMany relationships and “mappedBy” on non relathinship
owner

 

\@ManyToMany - new join table is created

\@JoinTable

joinColumns=\@JoinColumn

inverseJoinColumns=\@JoinColumn

 

Rule is that

\*\*\*ToOne : default is Eager Fetching

\*\*\*ToMany : default is Lazy Fetching

 

Inheritance Hierarchies and Mappings

If we have one entity class that is extended by other classes, to keep the
columns on the same table we must use \@Inheritance on the abstract class and
here we can specify the strategy InheritanceType.SINGLE_TABLE; DTYPE compumn can
be specified using \@DiscriminatorColumn

 

TABLE_PER_CLASS - creates a table per concrete entity class

JOINED - fields that are specific to a subclass are mapped to a separate table
than the fields that are common to the parent class, and a join is performed to
instantiate the subclass

 

\@MappedSuperclass - used when you don’t want to use inheritance at all; this
class cannot be an \@Entity

 

 

 

 

 

 

 

 

 

 
