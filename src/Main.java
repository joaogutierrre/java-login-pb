import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        ArrayList<User> userList = callUserList();

        System.out.println("Insira seu usuario:");
        String name = user.nextLine();
        System.out.println("Insira sua senha:");
        String psswd = user.nextLine();

        boolean verification = verifyUsersOnList(userList, name, psswd);
//        System.out.println(verification);

        if (!verification) {
            System.out.println("Usuário e/ou senha incorretos!");

        } else {
//            System.out.println("deu certo a lógica de verificação");
            System.out.println(compareHour(generateHour()));
        }

    }

    public static String compareHour(int hour) {
        String msg2 = "você se logou ao nosso sistema.";
        String msg1 = "";
        if (hour >= 0 && hour <= 6) {
            msg1 = "Boa madrugada, " + msg2;
        }
        if (hour >= 6 && hour <= 12) {
            msg1 = "Bom dia, " + msg2;
        }
        if (hour >= 12 && hour <= 18) {
            msg1 = "Boa tarde, " + msg2;
        }
        if (hour >= 18 && hour <= 25) {
            msg1 = "Boa noite, " + msg2;
        }
        return msg1;
    }

    public static int generateHour() {
        int now = Calendar.getInstance().get(Calendar.HOUR);
        int postMeridiem = 0;
        if (Calendar.PM == 1) {
            postMeridiem = 12;
            postMeridiem += now;
        }
        return postMeridiem;
    }

    public static boolean verifyUsersOnList(ArrayList<User> userList, String userName, String userPsswd) {
        boolean result = false;

        for (User userData : userList) {
            String nameData = userData.getUser();
            String psswdData = userData.getPsswd();
            if (userName.equals(nameData) && userPsswd.equals(psswdData)) {
                System.out.println("Deu certo!");
                result = true;
            }
        }
        return result;
    }

    public static ArrayList<User> callUserList() {
        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User("jonas", "1234");
        User user2 = new User("peter", "4321");
        User user3 = new User("eric", "1111");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
