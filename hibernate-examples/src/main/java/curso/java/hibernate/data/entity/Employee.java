package curso.java.hibernate.data.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBL_EMPLOYEE")
public class Employee implements Serializable {

  @Serial
  private static final long serialVersionUID = -1;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Integer id;

  @Column
  private String email;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "employeeId")
  private Set<Task> tasks = new HashSet<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public Set<Task> getTasks() {
    return tasks;
  }
  public void setTasks(Set<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", tasks=" + tasks +
            '}';
  }
}
