import com.uptc.fwr.entity.*;
import com.uptc.fwr.entity.key.BookPk;
import com.uptc.fwr.feria.PersistenceUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {

    public static void main(String[] args) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Person person = new Person("Juana","Quiñonez");
        Nationality nationality = new Nationality("Colombiano");
        NationalityPerson nationalityPerson= new NationalityPerson(nationality,person,2023);
        entityManager.persist(person);
        entityManager.persist(nationality);
        entityManager.persist(nationalityPerson);
        entityManager.getTransaction().commit();
    }

    public static void createBookCompuesta(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        createBook();
        BookPk bookPk = new BookPk(5000L,"234523");
        Book book = entityManager.find(Book.class, bookPk);
        System.out.println(book);
    }

    public static void createBook() {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Book book = new Book("234523", "Libro", 234235.2);
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public static void createNacionality() {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Nationality nationality = new Nationality("Ingles");
        entityManager.persist(nationality);
        entityManager.getTransaction().commit();
        System.out.println(nationality);
    }

}
