package bai.tap.java.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai4QLCB {
    private static ArrayList<CanBo> arrayEmployee = new ArrayList<CanBo>();
    private static Scanner read = new Scanner(System.in);

    public static void main(String args[] ){
        System.out.println("Welcome to with Trang Tung's company !!");
        boolean flag= true;
        while (flag){
            System.out.println("Moi chon: ");
            printChoice();
            int i= read.nextInt();
            read.nextLine();
            switch (i){
                case 1:
                    addCongNhan();
                    break;
                case 2:
                    addKySu();
                    break;
                case  3:
                    addNhanVien();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    for(int j=0; j < arrayEmployee.size() ; j++)
                        System.out.println(arrayEmployee.get(j).toString());
                    break;
                case 6:
                    flag= true;
                    System.out.println("See you again. My best friend !!");
                    System.out.println("Product of Trang Tung Developer @ - @ ");
            }
        }
    }

    public static void printChoice(){
        System.out.println("1.Them can bo cong nhan");
        System.out.println("2.Them can bo ky su");
        System.out.println("3.Them can bo nhan vien");
        System.out.println("4.Tim kiem theo ho ten");
        System.out.println("5.Hien thi thong tin ve cac can bo");
        System.out.println("6.Thoat chuong trinh");
    }

    public static void searchByName(){
        System.out.println("Moi nhap ho ten can bo muon tim: ");
        String name= read.nextLine();
        boolean flag= false;
        System.out.println("Dang tim kiem thong tin can bo: "+name);
        for(CanBo c: arrayEmployee){
            if( c.getFullName().equalsIgnoreCase(name)) {
                System.out.println(c.toString());
                flag=true;
            }
        }
        if(flag == false) System.out.println("Khong co can bo nay trong cong ty");
    }

    public static void addCongNhan(){
        System.out.println("Moi nhap ho ten: ");
        String fullName= read.nextLine();
        System.out.println("Moi nhap tuoi: ");
        int age= read.nextInt();
        read.nextLine();
        System.out.println("Moi nhap gioi tinh: ");
        String sex= read.nextLine();
        System.out.println("Moi nhap dia chi: ");
        String address= read.nextLine();
        System.out.println("Moi nhap cap do: ");
        String capBac= read.nextLine();
        // create object CongNhan
        CongNhan cn= new CongNhan(fullName,age,sex,address,capBac);
        arrayEmployee.add(cn);
    }

    public static void addKySu(){
        System.out.println("Moi nhap ho ten: ");
        String fullName= read.nextLine();
        System.out.println("Moi nhap tuoi: ");
        int age= read.nextInt();
        read.nextLine();
        System.out.println("Moi nhap gioi tinh: ");
        String sex= read.nextLine();
        System.out.println("Moi nhap dia chi: ");
        String address= read.nextLine();
        System.out.println("Moi nhap nganh dao tao: ");
        String nganh= read.nextLine();
        // create object CongNhan
        KySu ks= new KySu(fullName,age,sex,address,nganh);
        arrayEmployee.add(ks);
    }

    public static void addNhanVien(){
        System.out.println("Moi nhap ho ten: ");
        String fullName= read.nextLine();
        System.out.println("Moi nhap tuoi: ");
        int age= read.nextInt();
        read.nextLine();
        System.out.println("Moi nhap gioi tinh: ");
        String sex= read.nextLine();
        System.out.println("Moi nhap dia chi: ");
        String address= read.nextLine();
        System.out.println("Moi nhap job ");
        String job= read.nextLine();
        // create object CongNhan
        NhanVien jb= new NhanVien(fullName,age,sex,address,job);
        arrayEmployee.add(jb);
    }
}

class CanBo{
    private String fullName;
    private int age;
    private String sex;
    private  String address;

    public CanBo(String fullName, int age, String sex, String address) {
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

class CongNhan extends CanBo {
    private String capBac;

    public CongNhan(String fullName, int age, String sex, String address, String capBac) {
        super(fullName, age, sex, address);
        this.capBac = capBac;
    }

    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "fullName='" + this.getFullName() + '\'' +
                ", age=" + this.getAge() +
                ", sex='" + this.getSex() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", cap bac='" + capBac + '\'' +
                '}';
    }

}

class KySu extends CanBo {

    private String nganhDaoTao;

    public KySu(String fullName, int age, String sex, String address, String nganhDaoTao) {
        super(fullName, age, sex, address);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return "KySu{" +
                "fullName='" + this.getFullName() + '\'' +
                ", age=" + this.getAge() +
                ", sex='" + this.getSex() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", nganh dao tao='" + nganhDaoTao + '\'' +
                '}';
    }

}

class NhanVien extends CanBo {

    private String job;

    public NhanVien(String fullName, int age, String sex, String address, String job) {
        super(fullName, age, sex, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "fullName='" + this.getFullName() + '\'' +
                ", age=" + this.getAge() +
                ", sex='" + this.getSex() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}