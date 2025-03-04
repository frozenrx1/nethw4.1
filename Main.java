import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер: "
                    + "\n 1. Добавить новый доход"
                    + "\n 2. Добавить новый расход"
                    + "\n 3. Выбрать систему налогооблажения");
            String input = scan.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scan.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String minusStr = scan.nextLine();
                    int minus = Integer.parseInt(minusStr);
                    spendings += minus;
                    break;
                case 3:
                    int taxEarnings = taxEarnings(earnings);
                    int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);

                    if (taxEarnings < taxEarningsMinusSpendings) {
                        System.out.println("Мы советуем Вам УСН доходы"
                                + "\n Ваш налог составит: " + taxEarnings
                                + "\n Налог на другой системе: " + taxEarningsMinusSpendings
                                + "\n Экономия: " + (taxEarningsMinusSpendings - taxEarnings));
                    } else if (taxEarningsMinusSpendings < taxEarnings) {
                        System.out.println("Мы советуем Вам УСН доходы минус расходы"
                                + "\n Ваш налог составит: " + taxEarningsMinusSpendings
                                + "\n Налог на другой системе: " + taxEarnings
                                + "\n Экономия: " + (taxEarnings - taxEarningsMinusSpendings));
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения, так как налог на обоих системах одинаковый."
                                + "\n Налог на системе УСН доходы: " + taxEarnings
                                + "\n Налог на системе УСН доходы минус расходы: " + taxEarningsMinusSpendings);
                    }
                    break;
            }

        }
        System.out.println("Программа завершена.");
    }

    public static int taxEarnings(int earnings) {
        System.out.println("Вычисление налога по системе УСН доходы... ");
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        System.out.println("Вычисление налога по системе УСН доходы минус расходы... ");
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}