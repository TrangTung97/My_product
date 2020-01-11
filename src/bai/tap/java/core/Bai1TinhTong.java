package bai.tap.java.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai1TinhTong
{
    public static void main(String args[]){
        System.out.println("Hi, Try to!");
        System.out.println("Moi nhap so can tinh:");
        Scanner input= new Scanner(System.in);
        long var1=input.nextLong();
        System.out.println("Tong cua tat ca cac so trong so "+ var1 +" la :"+sumNumbers(var1));
        bai2();
        bai3();

    }
    public static long sumNumbers(long var){
        long tong=0;
        while (var != 0){
            tong += var % 10;
            var /=10;
        }
        return tong;
    }

    // bai nay muon nói rằng phải khai báo đúng cú pháp với kiểu long thì phải có L phía sau, vs liểu double phải có d phía sau
    public static void bai2(){
        long a=123456789101112L,b= 121110987654321L;
        System.out.println("Tong 2 so nguyen dai la:  "+(a+b));
    }

    public static void bai3(){
        int array1[] = {1,2,5,6,7};
        int sum= 8;
        boolean flag= false;
        System.out.println("Dang tim kiem cac cap so co tong bang "+sum);
        for(int i=0; i< array1.length; i++ ) {
            for (int j = i + 1; j < array1.length; j++) {
                if (sum == (array1[i] + array1[j])) {
                    System.out.print(" ( "+array1[i] + " " + array1[j] + " ) ");
                    flag = true;
                }
            }
        }
        if( flag = false) System.out.println(" Khong co cap so nao thoa man yeu cau");
    }
}
