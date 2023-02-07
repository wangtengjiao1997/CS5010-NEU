package visitor;

import visitor.Manager;
import visitor.Person;

public class Test {
    public static void main(String[] args) {
        Manager ceo = new Manager(5);
        ceo.addSub(new Manager(4));
        ceo.addSub(new Engineer(3));

        SalaryAmpifyVisitor saVisitor1 =
                new SalaryAmpifyVisitor();
        System.out.println(ceo.accept(saVisitor1));

//        // total_salary:
//        // 2 * engineer_salary + 10 * manager_salary
//        int totalSalary = 0;
//        //visitor.SalaryAmplifier sa = new visitor.SalaryAmplifier();
//        SalaryAmpifyVisitor saVisitor =
//                new SalaryAmpifyVisitor();
//
//        int totalDeductedSalary = 0;
//        for (int i = 0; i < p_array.length; i++) {
//            Person p = p_array[i];
//
//            //totalSalary += p.amplifySalary();
//            // the following line does not even compile
//            //totalSalary += sa.amplifySalary(p);
//            totalSalary += p.accept(saVisitor);
//            //totalDeductedSalary += p.accept(sdVisitor);
//            /*
//            if (p instanceof Engineer) {
//                totalSalary += p.getSalary() * 2;
//            } else if (p instanceof visitor.Manager) {
//                totalSalary += p.getSalary() * 10;
//            }
//            */
//
//            // if engineer
//            // ..
//
//            // else if manager
//            // ..
//        }
//
//        System.out.println(totalSalary);
//        System.out.println(totalDeductedSalary);


    }
}
