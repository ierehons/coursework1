public class Main {
    public static void main(String[] args) {
        EmployeesBook employeesBook = new EmployeesBook();
        employeesBook.addEmployee(new Employee("Рогачёв", "Николай", "Михайлович", "5", 49560.0));
        employeesBook.printAllPersonal();
        employeesBook.printSumSalary();
        System.out.println(employeesBook.getEmployeeWithMaxSalary());
        System.out.println(employeesBook.getEmployeeWithMinSalary());
        employeesBook.printAllEmployeeGroupDepartment();
    }
}
