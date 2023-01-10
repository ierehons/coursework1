public class Utilit {
    public static boolean isDepartment(String department) {
        if (department.equals ("1") || department.equals("2") || department.equals("3") || department.equals("4")
                || department.equals("5")) {
            return true;
        }
        return false;
    }
}

