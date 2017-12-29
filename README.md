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

 

 

 

 

 
