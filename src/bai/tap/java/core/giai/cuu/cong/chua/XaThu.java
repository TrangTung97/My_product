package bai.tap.java.core.giai.cuu.cong.chua;

public class XaThu extends NhanVat {

    private float hpStart;


    // sat thuong cua xa thu tang gap doi binh thuong
    XaThu(String name){
        super(name);
        this.setDamge(this.getDamge() *2);
        this.hpStart = this.getHp();
    }

    public float getHpStart() {
        return hpStart;
    }

    public void setHpStart(float hpStart) {
        this.hpStart = hpStart;
    }



    // phuong thuc ne don cua xa thu
    public boolean skillNeTranh(){
        if( this.getMana() >=20) {
            this.setMana(this.getMana() - 20);
            System.out.println("Xa thu "+this.getName() +" da ne dc don");
            return true;
        }
        else
            return false;
    }
}
