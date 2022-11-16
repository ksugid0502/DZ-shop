import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Добавить");
        list1.add("Показать");
        list1.add("Удалить");
        ArrayList<String> list2 = new ArrayList<>();
        list(list1);

        System.out.println("Список возможных операций:");

        while (true) {
            System.out.println("Выберите операцию или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            if (digit((input))) {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        System.out.println("Какую покупку хотите добавить?");
                        String purchase = scanner.nextLine();
                        list2.add(purchase);
                        System.out.println("Итого в списке покупок: " + list2.size());
                        break;
                    case 2:
                        System.out.println("Список покупок:");
                        list(list2);
                        break;
                    case 3:
                        System.out.println("Список покупок:");
                        list(list2);
                        System.out.println("Какую хотите удалить? Выберите номер или название");
                        String delete = scanner.nextLine();
                        boolean removed;
                        if (digit(delete)) {
                            removed = deleteIndex(list2, delete);
                        } else {
                            removed = delete2(list2, delete);
                        }
                        delete1(delete, removed);
                        list(list2);
                        break;
                    default:
                        System.out.println("Данной операции не существует");
                }
            } else {
                System.out.println("Вы ввели некорректное значение");
            }

        }
    }

    private static void list(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static void delete1(String delete, boolean removed) {
        if (removed) {
            System.out.println("Покупка \"" + delete + "\" удалена. Список покупок:");
        } else {
            System.out.println("Товара нет в вашем списке");
        }
    }

    private static boolean deleteIndex(List<String> list, String delete) {
        int index = Integer.parseInt(delete);
        if (index > list.size()) {
            return false;
        }
        list.remove(index - 1);
        return true;
    }

    private static boolean delete2(List<String> list, String delete) {
        boolean removed = false;
        for (int i = 0; i < list.size(); i++) {
            if (delete.equals(list.get(i))) {
                list.remove(list.get(i));
                removed = true;
            }
        }
        return removed;
    }

    private static boolean digit(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
