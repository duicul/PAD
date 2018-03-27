import java.rmi.Remote;
import java.util.List;

public interface StudentData extends Remote {
  public List<Student> getStudents();
}
