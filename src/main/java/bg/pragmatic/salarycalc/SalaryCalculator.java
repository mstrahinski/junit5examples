package bg.pragmatic.salarycalc;

import java.math.BigDecimal;

public class SalaryCalculator {

    /**
     * If anyone has been working more than 8 hours a day, he gets his salary doubled
     *
     * @param employee the employee to calculate against
     *
     * @return a doubled salary if he/she has overtime or his normal salary
     */
    public BigDecimal calculateSalary(Employee employee) {

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(employee.getWorkHours() > 8) {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(2)));
        }

        return employee.getSalary();
    }
}
