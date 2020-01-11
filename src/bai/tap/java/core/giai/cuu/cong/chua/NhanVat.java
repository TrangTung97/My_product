package bai.tap.java.core.giai.cuu.cong.chua;

import java.util.ArrayList;

public class NhanVat {
    private float hp =250, damge= 100, mana = 100;
    private float phanTramGiam= 1;
    private String name;

    NhanVat(String name){
        this.name = name;
    }

    public float getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(float phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getDamge() {
        return damge;
    }

    public void setDamge(float damge) {
        this.damge = damge;
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hitSimple(Dragon dragon){
        dragon.setHp(dragon.getHp() - this.getDamge());
        if (dragon.getHp() <= 0) {
            System.out.println("Dragon da chet");
        }
        System.out.println("Mau cua nhan vat la: "+ this.getHp()+" va mau cua dragon la: "+ dragon.getHp());
        System.out.println("_______________________________");
    }

    public void regen(Dragon dragon){
        if( this.mana >= 20){
            this.hp += this.damge;
            this.mana -= 20;
            dragon.setHp(dragon.getHp() - this.damge);
            if (dragon.getHp() <= 0) {
                System.out.println("Dragon da chet");
            }
        }
        else System.out.println("Xa thu danh truot dragon");
        System.out.println("Mau cua nhan vat la: "+ this.getHp()+" va mau cua dragon la: "+ dragon.getHp());
        System.out.println("_______________________________");
    }

    public void critical(Dragon dragon) {
        dragon.setHp(dragon.getHp() - 2* this.damge);
        if (dragon.getHp() <= 0) {
            System.out.println("Dragon da chet");
        }
        System.out.println("Mau cua nhan vat la: "+ this.getHp()+" va mau cua dragon la: "+ dragon.getHp());
        System.out.println("_______________________________");
    }
}
