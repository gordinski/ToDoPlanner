import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToDo {

private static final Pattern p = Pattern.compile("[^\\d]+([\\d]+)");
private static final Pattern p2 = Pattern.compile("[^\\d]*[\\d]");

    public static void main(String[] args) {
        String answer;
        ArrayList<String> toDoList = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Я принимаю команды list, add text, edit num text и delete num");
            System.out.println("Что прикажете?");
            answer = input.nextLine();
            if (answer.equals("list"))
            {
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                System.out.println("СПИСОК ЗАДАЧ");
                for (int i = 0; i < toDoList.size(); i++) {
                    System.out.println("\t" + i + "." + " " + toDoList.get(i));
                }
            }
            else if (answer.startsWith("add"))
            {
                toDoList.add(answer.replaceFirst("add ", ""));
                System.out.println("✓ Новая задача добавлена!");
            }
            else if (answer.startsWith("edit"))
            {
                Matcher m = p.matcher(answer);
                int number = 0;
                String text = null;
                if (m.find()) {
                    number = Integer.parseInt(m.group(1));
                }
                toDoList.set(number, answer.replaceFirst("[^\\d]*[\\d]\s", ""));
                System.out.println("Задача №" + number + " изменена успешно!");
            }
            else if (answer.startsWith("delete"))
            {
                Matcher m = p.matcher(answer);
                int number = 0;
                if (m.find()) {
                    number = Integer.parseInt(m.group(1));
                }
                toDoList.remove(number);
                System.out.println("Задача №" + number + " удалена!");
            }
        }
    }
}
