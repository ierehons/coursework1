import java.util.Objects;

public class Employee {

    /**
     * приватныеполя класса
     */
    private String lastName;
    private String firstName;
    private String middleName;

    private String department;
    private double salary;
    private final long id = count;
    private static long count = 1L;

    /**
     * конструктор
     *
     * @param lastName
     * @param firstName
     * @param middleName
     * @param department
     * @param salary
     */
    public Employee(String lastName, String firstName, String middleName, String department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        if (Utilit.isDepartment(department)) {
            this.department = department;
        } else {
            System.out.println("Такого отдела не существует");
        }
        this.salary = salary;
        count++;
    }

    /**
     * геттеры и сеттеры
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Employee.count = count;
    }

    /**
     * toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "Работник № " + id + ", ФИО: " + lastName + " " + firstName + " " + middleName + ", работает в отделе: " +
                department + ", с зарплатой: " + String.format("%.2f", salary);
    }

    /**
     * equals,  hashCode
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && id == employee.id && Objects.equals(lastName, employee.lastName) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(middleName, employee.middleName) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, department, salary, id);
    }
}
