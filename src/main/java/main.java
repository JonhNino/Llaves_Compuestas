import com.uptc.fwr.entity.*;
import com.uptc.fwr.feria.PersistenceUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {

    public static void main(String[] args) {

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Bill bill= entityManager.find(Bill.class,20);
        System.out.println(bill);
        System.out.println(bill.getBillDetails());
        BillDetail billDetail = entityManager.find(BillDetail.class,1);
        System.out.println(billDetail);
        System.out.println(billDetail.getBook());

    }

    public static void crearPersonBook(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person1 = new Person(102L, "Jonh","Mesa","Colombiano");
        Person person2 = new Person(301L,"Andrea","Correa","Germany");

        Book book = new Book(300L,"Libro 300",303.33);
        List<Person> autors =new ArrayList<>();
        autors.add(person1);
        autors.add(person2);
        book.setAutors(autors);
        entityManager.getTransaction().begin();
        entityManager.persist(person2);
        entityManager.persist(person1);
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public static void crearPersonBill(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = new Person();
        person.setId(201L);
        person.setName("Juan");
        person.setLastName("Quinchanewa");
        person.setNationality("Brasileño");
        Bill bill = new Bill();
        bill.setId(101L);
        bill.setFecha(new Date());
        bill.setPerson(person);
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.persist(bill);

        entityManager.getTransaction().commit();

    }
     public static void crearLibro(){
         EntityManager entityManager = PersistenceUtil.getEntityManager();
         Book book= new Book();
         book.setTitle("El Coronel no tiene quien le escriba");
         book.setPrice(5000d);
         book.setId(9L);
         Edition edition = new Edition();
         edition.setNumber(13);
         edition.setYear(1993);
         edition.setDescription("Realismo Magico");
         edition.setBook(book);
         entityManager.getTransaction().begin();
         entityManager.persist(edition);
         entityManager.getTransaction().commit();
     }


    public static void testRelationManyToMany(){
        testBillPerson();
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 12);
        System.out.println(person);
        System.out.println(person.getBooks());
        Book book = entityManager.find(Book.class, 10);
        System.out.println(book.getAutors());
    }

  public static void  testBillPerson(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,12);
        System.out.println(person);
        System.out.println(person.getBills().size());
        Bill bill = entityManager.find(Bill.class,20);
        System.out.println(bill);
        System.out.println(bill.getPerson());

    }
    public static void testBook(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Edition edition = entityManager.find(Edition.class,10);
        System.out.println(edition);
        System.out.println(edition.getBook());
        System.out.println();
        Book book =entityManager.find(Book.class,10);
        System.out.println(edition);
        System.out.println(edition.getBook());

    }
    public static void removePerson(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,12);
        System.out.println(person);
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        person.setLastName("Uganda");
        entityManager.persist(person);
        entityManager.getTransaction().commit();

    }
    public static void createPerson(){

        Person person = new Person();
        person.setId(9L);
        person.setName("Juan");
        person.setLastName("Cardenas");
        person.setNationality("Colombiana");
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        System.out.println(person);

    }
    public static void mergePerson(){

        // probarMapeo();
        createPerson();
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,9);
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        person.setLastName("Martinez");
        entityManager.persist(person);
        entityManager.getTransaction().commit();

    }

    public static void detachPerson(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,9);
        entityManager.getTransaction().begin();
        person.setLastName("Martinez");
        entityManager.detach(person);
        Person person1 = entityManager.merge(person);
        entityManager.remove(person1);
        entityManager.getTransaction().commit();
    }
    public static void findPersonRefresh(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,12);
        entityManager.getTransaction().begin();
        entityManager.refresh(person);
        person.setLastName("Bayona");
        entityManager.getTransaction().commit();
        System.out.println(person);

    }
     public static void probarMapeo(){

         EntityManager entityManager = PersistenceUtil.getEntityManager();
         Person person = entityManager.find(Person.class,12);
         System.out.println(person);
         Book book = entityManager.find(Book.class,10);
         System.out.println(book);
         Bill bill = entityManager.find(Bill.class,20);
         System.out.println(bill);
         BillDetail billDetail = entityManager.find(BillDetail.class,1);
         System.out.println(billDetail);
         Edition edition = entityManager.find(Edition.class, 10);
         System.out.println(edition);

     }
}
