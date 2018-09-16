package bg.pragmatic.salarycalc.parameterizedtest;

public enum EmployeeNames {
    GEORGI("Georgi Ivanov"),
    MARIA1("Maria Ignatova"),
    MARIA2("Maria Petkova"),
    BAI_MILE("Bai Mile maistorcheto"),
    PAPI_HANS("Papi Hans"),
    BOJINKATA("Nikoleri Bojinov"),
    IVAN("Vanio");

    private String employeeName;

    EmployeeNames(String employeeName){
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
