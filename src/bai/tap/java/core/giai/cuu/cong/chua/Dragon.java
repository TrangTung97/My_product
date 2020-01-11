package bai.tap.java.core.giai.cuu.cong.chua;

import java.util.*;

public class Dragon {
    private float hp= 2000 , damge = 50;

    public Dragon() {

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

    public void hitSimple(NhanVat hero, float phanTramGiam, boolean ne){
        if( ne == false){
            hero.setHp(hero.getHp() - this.getDamge()* phanTramGiam);
            if( hero.getHp() <= 0){
                System.out.println("Hero "+ hero.getName() +" da hy sinh");
            }
        }
    }

    public void fireHeath(NhanVat hero, float phanTramGiam, boolean ne, float hpHeroStart) {
        if (ne == false) {
            if (hero.getHp() < (hpHeroStart / 2)) {
                hero.setHp(hero.getHp() - hero.getHp() * phanTramGiam);
                System.out.println("Hero " + hero.getName() + " da hy sinh");
            } else hero.setHp(hero.getHp() - ((hero.getHp() / 2) * phanTramGiam));
        }
    }

}
