package curso.java.hibernate;

import curso.java.hibernate.data.EmployeeRepository;
import curso.java.hibernate.data.entity.Employee;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestBootstrappingSession {

  @Autowired
  TestEntityManager em;

  private Session session;

  @Autowired
  private EmployeeRepository repository;

  @BeforeEach
  public void setup(){
    session = em.getEntityManager().unwrap(Session.class);
  }

  @Test
  public void contextLoads() {
    Assertions.assertNotNull(session);
  }

  @Test
  @Transactional
  void verifyBootstrappingByPersistingAnEmployee() {
    Employee emp = new Employee();
    emp.setEmail("demo-user@email.com");
    emp.setFirstName("demo");
    emp.setLastName("user");

    Assertions.assertNull(emp.getId());
    session.persist(emp);
    Assertions.assertNotNull(emp.getId());
  }

  @Test
  @Transactional
  void verifyRepositoryByPersistingAnEmployee() {
    Employee emp = new Employee();
    emp.setEmail("demo-user@email.com");
    emp.setFirstName("demo");
    emp.setLastName("user");

    Assertions.assertNull(emp.getId());
    repository.save(emp);
    Assertions.assertNotNull(emp.getId());
  }
}
