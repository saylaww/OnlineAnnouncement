package uz.pdp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static User[] users = new User[10];
    static Announcement[] announcements = new Announcement[10];
    static SubCategory[] subCategories = new SubCategory[2];
    static Message[] messages = new Message[10];
    static int aId = 0;
    static int num = 0;
    static int mId = 0;
    static int uId = 2;
    public static void main(String[] args) {
        System.out.println();


        users[0] = new User("Saylaubay", "Bekmurzaev", "2238061");
        users[1] = new User("Ramazan", "Darmiyanov", "2237140");
//increment(uId)
        Category category = new Category("Avto", "Avtombollar haqida");



        subCategories[0] = new SubCategory("Yengil avto", category);
        subCategories[1] = new SubCategory("Yuk avto", category);

        boolean bool = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("======================================");
            System.out.println("E'lonlar bo'limiga xush kelibsiz");
            System.out.println("---------------------------------------");
            System.out.println("0 - Chiqish");
            System.out.println("1 - Sign Up");
            System.out.println("2 - Sign In");
            System.out.println("---------------------------------------");
            System.out.println("Tanlang - ");
            scanner = new Scanner(System.in);
            int sign = scanner.nextInt();

            switch (sign){
                case 0:{
                    bool = false;
                    break;
                }
                case 1:{
                    System.out.print("name ni kiriting - ");
                    Scanner scanner1 = new Scanner(System.in);
                    String name = scanner1.nextLine();

                    for (int i = 0; i < users.length; i++) {
                        if (!users[i].getName().equals(name)){
                            System.out.println("Familiya kiriting - ");
                            scanner = new Scanner(System.in);
                            String surname = scanner.nextLine();

                            System.out.print("Parolni kiriting -");
                            String pass = scanner.nextLine();
                            addUser(name, surname, pass);
//                            int userId = uId;
//                            users[increment(userId)] = new User(name, surname, pass);
                            System.out.println("Siz muvafaqiyatli ro'yhatdan o'tdingiz!!");
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.print("name ni kiriting - ");
                    Scanner scanner1 = new Scanner(System.in);
                    String name = scanner1.nextLine();

                    for (int i = 0; i < uId; i++) {
                        if (users[i].getName().equals(name)){
                            System.out.print(users[i].getName() + " ning parolini kiriting -");
                            scanner = new Scanner(System.in);
                            String pass = scanner.nextLine();
                            if (users[i].getPassword().equals(pass)){
                                boolean b = true;
                                while (b){
                                    int j = i;
                                    if (checkReadInbox(i) > 0){
                                        System.out.println("Sizga " + checkReadInbox(i) + " ta YANGI XABAR KELDI!!!");
                                    }
                                    System.out.println("---------------------------------");
//                                    System.out.println("0 - Orqaga");
                                    System.out.println("1 - Add announcement");
                                    System.out.println("2 - View announcement(" +(announcements.length-Math.abs(aId - announcements.length)) + ")");
                                    System.out.println("3 - My announcement(" + myAnnouncementCount(j) + ")");
                                    System.out.println("4 - Inbox(" + checkReadInbox(i) + ")");
                                    System.out.println("5 - Log out");
                                    System.out.println("---------------------------------");

                                    System.out.print("Tanlang - ");
                                    Scanner scanner2 = new Scanner(System.in);
                                    int menu = scanner2.nextInt();

                                    switch (menu){
                                        case 0:{
                                            b = false;
                                            break;
                                        }
                                        case 1:{
                                            scanner2 = new Scanner(System.in);
                                            System.out.print("title ni kiriting - ");
                                            String title = scanner2.nextLine();

                                            System.out.print("body ni kiriting - ");
                                            String body = scanner2.nextLine();

                                            System.out.println("Sub category ni tanlang - ");
                                            System.out.println("1 - Yengil avto");
                                            System.out.println("2 - Yuk avto");

                                            scanner2 = new Scanner(System.in);
                                            int categ = scanner2.nextInt();

                                            add(title, body,categ, i);


                                            break;
                                        }
                                        case 2:{
                                            System.out.println("----------------Barcha e'lonlar----------------");
                                            viewAllAnnouncement();
                                            System.out.println("Xabar yozmoqchimisiz? \n1 - Xa\n2 - Yo'q");
                                            Scanner scanner4 = new Scanner(System.in);
                                            int message = scanner4.nextInt();
                                            if (message == 1){
//                                                viewAllAnnouncement();
                                                System.out.println("Qaysi e`longa xabar yozmoqchisiz tanlang - ");
                                                Scanner scanner5 = new Scanner(System.in);
                                                int c = scanner5.nextInt();

                                                Scanner scanner6 = new Scanner(System.in);
                                                System.out.println("title ni kiriting - ");
                                                String title = scanner6.nextLine();

                                                System.out.println("Body ni kiriting - ");
                                                String body = scanner6.nextLine();

                                                sendMessage(title, body, i, c);

                                            }else if (message == 2){
                                                break;
                                            }else {
                                                System.out.println("Bunday buyruq yo'q");
                                            }
                                            break;
                                        }
                                        case 3:{
                                            myAnnouncement(i);
                                            break;
                                        }
                                        case 4:{
                                            chackInbox(i);
//                                            sendMessage();
                                            break;
                                        }
                                        case 5:{
                                            b = false;
                                            break;
                                        }
                                    }
                                }



                            }else {
                                System.out.println("Parol QATEEEEE");
                            }
                        }
                    }
                    break;
                }
            }

        }while (bool);
    }

//    static int increment(int id){
//        id++;
//        return id;
//    }

    static void addUser(String name, String surname, String pass){
        users[uId] = new User(name, surname, pass);
        uId++;
    }

    static int checkReadInbox(int id){
        int counter = 0;
        for (int i = 0; i < mId; i++) {
            if (messages[i].getAnnouncement().getUser().equals(users[id])){
                if (!messages[i].isbool){
                    counter++;
                }
            }
        }
        return counter;
    }

    static void chackInbox(int id){
        int p = 0;
        int counter = 1;
        for (int i = 0; i < mId; i++) {
            if (messages[i].getAnnouncement().getUser().equals(users[id])){
                if (messages[i].isbool == false) {
                    System.out.println("--------------------------------------------");
                    System.out.println(counter + "    Kimdan keldi - " + messages[i].getSender().getName());
                    System.out.println("     Qaysi e'longa keldi - " + messages[i].getAnnouncement().getTitle());
                    System.out.println("     title - " + messages[i].getTitle());
                    System.out.println("     body - " + messages[i].getBody());
                    System.out.println("--------------------------------------------");
//                System.out.println("body - "+messages[i].getgetBody());
                    p++;
                    counter++;
                    messages[i].isbool = true;
                }
            }
        }
        if (p == 0){
            System.out.println("Sizni e'loningizga xabar kelmagan!!");
        }
    }

    static void sendMessage(String title, String body, int id, int c){
        messages[mId] = new Message(title, body, users[id], announcements[c]);
        mId++;
        System.out.println("Xat muvafaqiyatli yuborildi");
    }

    static void myAnnouncement(int id){
        int d = Math.abs(aId - announcements.length);
        for (int i = 0; i < announcements.length-d; i++) {
            if (announcements[i].getUser().equals(users[id])){
                System.out.println(announcements[i].getTitle());
            }
        }
    }
    static int myAnnouncementCount(int id){
        int counter = 0;
        for (int i = 0; i < aId; i++) {
            if (announcements[i].getUser().equals(users[id])){
                counter++;
            }
        }
        return counter;
    }

    static void viewAllAnnouncement(){
        for (int i = 0; i < aId; i++) {
            System.out.println(i+" " + announcements[i].getTitle());
        }
    }

    static void add(String title, String body, int categ, int id){

        announcements[aId] = new Announcement(title, body, users[id], subCategories[categ-1]);
        System.out.println("Announmcement muvafaqiyatli qo'shildi");
//        System.out.println(announcements[aId].getTitle());
        aId++;
    }


}
