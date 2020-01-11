package bai.tap.java.core.giai.cuu.cong.chua;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DauTruong {
    private static Random random= new Random();

    public static void main(String args[]) throws InterruptedException {
        boolean flag = true;
          Scanner input= new Scanner(System.in);
            while (flag) {
                Dragon dragon = new Dragon();
                printChoiceGroup();
                int i = input.nextInt();
                input.nextLine();
                switch (i) {
                    case 1:
                        System.out.println("Moi nhap ten cua ban: ");
                        String name1 = input.nextLine();
                        ChienBinh chienBinh = new ChienBinh(name1);
                        chienBinhAndDragon(chienBinh, dragon);
                        break;
                    case 2:
                        System.out.println("Moi nhap ten cua ban: ");
                        String name2 = input.nextLine();
                        XaThu xaThu = new XaThu(name2);
                        xaThuAndDragon(xaThu, dragon);
                        break;
                    case 3:
                        System.out.println("Moi nhap ten cua ban: ");
                        String name3 = input.nextLine();
                        PhapSu phapSu = new PhapSu(name3);
                        phapSuAndDragon(phapSu, dragon);
                        break;
                    case 4:
                        String namePoint= "";
                        int k=0;
                        try {
                            FileReader read = new FileReader("ghi.txt");
                            while ((k = read.read()) != -1)
                            namePoint += (char) k;
                            System.out.println("Nguoi chien thang quai vat Dragon gan day la: "+namePoint);
                            read.close();}
                        catch (IOException e){
                            e.getMessage();
                        }
                        break;
                    case 5:
                        System.out.println("Tro choi tu dong nen khong can huong dan hehehe ...");
                        break;
                    case 6:
                        System.out.println("See you again. ");
                        flag = false;
                }
            }
    }

    public static void printChoiceGroup(){
        System.out.println("                                    Giai Cuu Cong Chua");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Moi ban chon: ");
        System.out.println("1. Chien binh");
        System.out.println("2. Xa thu");
        System.out.println("3. Phap su");
        System.out.println("4: Nguoi chien thang gan day");
        System.out.println("5. Huong dan choi");
        System.out.println("6. Thoat game");
    }

    public static void chienBinhAndDragon(ChienBinh chienBinh, Dragon dragon){
        boolean flag= true;
        while (flag){
            int randomNhanVat = random.nextInt(11);
            int randomDragon = random.nextInt(11);
            System.out.println(" Nhan vat va dragon ti le ra don lan luot la: "+ randomNhanVat+" : "+randomDragon );
            if( chienBinh.getHp() > 0) {
                switch (randomNhanVat) {
                    case 4:
                        chienBinh.regen(dragon);
                        break;
                    case 3:
                        chienBinh.critical(dragon);
                        break;
                    default:
                        chienBinh.hitSimple(dragon);
                }
            }
            if( dragon.getHp() > 0) {
                switch (randomDragon) {
                    case 2:
                        dragon.fireHeath(chienBinh, chienBinh.getPhanTramGiam(), false, chienBinh.getHpStart());
                        break;
                    default:
                        dragon.hitSimple(chienBinh, chienBinh.getPhanTramGiam(), false);
                }
                if ( randomNhanVat == 10 && randomDragon != 2) chienBinh.blockDam(dragon);
                System.out.println("Mau cua nhan vat la: "+ chienBinh.getHp()+" va mau cua dragon la: "+dragon.getHp());
                System.out.println("_______________________________");
            }
            if( chienBinh.getHp() <= 0 || dragon.getHp() <= 0)
            {
                flag= false;
                if(chienBinh.getHp() <= 0) {
                    System.out.println("Game over. Cong chua khong duoc giai cuu.");

                }
                if(dragon.getHp() <= 0) {
                    System.out.println("Chuc mung nguoi anh hung. Cong chua la cua ban. @ - @");
                    try {
                        FileWriter write= new FileWriter("ghi.txt");
                        write.write(chienBinh.getName());
                        write.close();
                    }
                    catch (IOException e){
                        e.getMessage();
                    }
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
    public static void xaThuAndDragon(XaThu xaThu, Dragon dragon){
        boolean flag= true;
        while (flag){
            int randomNhanVat = random.nextInt(11);
            int randomDragon = random.nextInt(11);
            boolean ne= false;
            System.out.println(" Nhan vat va dragon ti le ra don lan luot la: "+ randomNhanVat+" : "+randomDragon );
            if( xaThu.getHp() > 0) {
                switch (randomNhanVat) {
                    case 4:
                        xaThu.regen(dragon);
                        break;
                    case 3:
                        xaThu.critical(dragon);
                        ne= xaThu.skillNeTranh();
                        break;
                    default:
                        xaThu.hitSimple(dragon);
                }
            }
                if (dragon.getHp() > 0) {
                    switch (randomDragon) {
                        case 2:
                            dragon.fireHeath(xaThu, xaThu.getPhanTramGiam(), ne, xaThu.getHpStart());
                            break;
                        default:
                            dragon.hitSimple(xaThu, xaThu.getPhanTramGiam(), ne);
                    }
                    System.out.println("Mau cua nhan vat la: " + xaThu.getHp() + " va mau cua dragon la: " + dragon.getHp());
                    System.out.println("_______________________________");
                }
            if( xaThu.getHp() <= 0 || dragon.getHp() <= 0)
            {
                flag= false;
                if(xaThu.getHp() <= 0)  {
                    System.out.println("Game over. Cong chua khong duoc giai cuu.");
                }
                if(dragon.getHp() <= 0) {
                    System.out.println("Chuc mung nguoi anh hung. Cong chua la cua ban. @ - @");
                    try {
                        FileWriter write= new FileWriter("ghi.txt");
                        write.write(xaThu.getName());
                        write.close();
                    }
                    catch (IOException e){
                        e.getMessage();
                    }
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void phapSuAndDragon(PhapSu phapSu, Dragon dragon) throws InterruptedException {
        boolean flag= true;
        while (flag){
            int randomNhanVat = random.nextInt(11);
            int randomDragon = random.nextInt(11);
            System.out.println(" Nhan vat va dragon ti le ra don lan luot la: "+ randomNhanVat+" : "+randomDragon );
            if( phapSu.getHp() > 0) {
                switch (randomNhanVat) {
                    case 8:
                        phapSu.regen(dragon);
                        break;
                    case 3:
                        phapSu.skillThunder(dragon);
                        phapSu.critical(dragon);
                        break;
                    default:
                        phapSu.hitSimple(dragon);
                }
            }
            if( dragon.getHp() > 0) {
                switch (randomDragon) {
                    case 2:
                        dragon.fireHeath(phapSu, phapSu.getPhanTramGiam(), false, phapSu.getHpStart());
                        break;
                    default:
                        dragon.hitSimple(phapSu, phapSu.getPhanTramGiam(), false);
                }
                System.out.println("Mau cua nhan vat la: "+ phapSu.getHp()+" va mau cua dragon la: "+dragon.getHp());
                System.out.println("_______________________________");
            }
            if( phapSu.getHp() <= 0 || dragon.getHp() <= 0) {
                flag= false;
                if(phapSu.getHp() <= 0)  {
                    System.out.println("Game over. Cong chua khong duoc giai cuu.");
                }
                if(dragon.getHp() <= 0) {
                    System.out.println("Chuc mung nguoi anh hung. Cong chua la cua ban. @ - @");
                    try {
                        FileWriter write= new FileWriter("C:/Users/ADMIN/Desktop/Study Java Web/LJAVA/homeWork/bt_java_core/ghi.txt");
                        write.write(phapSu.getName());
                        write.close();
                    }
                    catch (IOException e){
                        e.getMessage();
                    }
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
