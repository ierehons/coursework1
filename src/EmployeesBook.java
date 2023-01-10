import java.util.ArrayList;
import java.util.List;

public class EmployeesBook {
    private static Employee[] employees = new Employee[10];

    {
        employees[0] = new Employee("Петренко", "Михаил", "Сергеевич", "1", 58236.0);
        employees[1] = new Employee("Сидов", "Пётор", "Моисеевич", "2", 88136.0);
        employees[2] = new Employee("Петров", "Никита", "Сергеевич", "3", 28536.0);
        employees[3] = new Employee("Семёнов", "Аркадий", "Паровозов", "4", 59236.0);
        employees[4] = new Employee("Крот", "Аристарх", "Вернидубович", "5", 68836.0);
        employees[5] = new Employee("Васильев", "Максим", "Геннадьевич", "2", 78206.0);
        employees[6] = new Employee("Иванов", "Сергей", "Сергеевич", "1", 90036.0);
        employees[7] = new Employee("Павлович", "Михаил", "Андреевич", "3", 68216.0);
        employees[8] = new Employee("Ткачук", "Ольга", "Михайловна", "5", 48236.0);
        employees[9] = new Employee("Мост", "Татьяна", "Викторовна", "1", 78236.0);
    }

    /**
     * Добавление работника в массив
     *
     * @param employee
     */
    public void addEmployee(Employee employee) {
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
        System.out.println("Нет свободных мест");
    }

    /**
     * удаление работника
     *
     * @param lastName
     * @param firstName
     * @param middleName
     */
    public void removeEmployee(String lastName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && firstName.equals(employees[i].getFirstName())
                    && lastName.equals(employees[i].getLastName())
                    && middleName.equals(employees[i].getMiddleName())) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Работника с таким Ф.И.О. не существует");
    }

    /**
     * вывод всех работников
     */
    public void printAllPersonal() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * общая зарплата
     *
     * @return
     */
    public double sumSalary() {
        double sum = 0d;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /**
     * метод вывода суммы зарплаты
     */
    public void printSumSalary() {
        System.out.println(sumSalary());
    }

    /**
     * вывод ошибки
     *
     * @return
     */
    public int getFirstNotNullSalaryIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                return i;
            }
        }
        throw new RuntimeException("Нет ни одного работника");
    }

    /**
     * min зарплата работника
     *
     * @return
     */
    public Employee getEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = employees[getFirstNotNullSalaryIndex()];
        for (int i = getFirstNotNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    /**
     * max зарплата работника
     *
     * @return
     */
    public Employee getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employees[getFirstNotNullSalaryIndex()];
        for (int i = getFirstNotNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    /**
     * проверка на департамент
     *
     * @param department
     */
    public void printAllEmployeeByDepartment(String department) {
        for (Employee employee : employees) {
            if (employee != null && department.equals(employee.getDepartment())) {
                System.out.println(employee);
            }
        }
    }

    public void printAllEmployeeGroupDepartment() {
        List<String> departments = findAllDepartment();
        for (String department : departments) {
            System.out.println("В отделе №" + department + " работают следующие сотрудники: ");
            printAllEmployeeByDepartment(department);

        }
    }

    public List<String> findAllDepartment() {
        List<String> allDepartment = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null && !allDepartment.contains(employee.getDepartment())) {
                allDepartment.add(employee.getDepartment());

            }
        }
        return allDepartment;
    }
}
