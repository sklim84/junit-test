package assertion.prev;

public class Employee {
    private int num;
    private String fname;
    private String lname;
    private String email;

    public Employee(int num, String fname, String lname, String email) {
        this.num = num;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public int getNum() {
        return num;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }
}
