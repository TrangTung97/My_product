package bai.tap.java.core.giai.cuu.cong.chua;

public class PhapSu extends NhanVat {

    private int i=0;

    private float hpStart;

    // mana tang len gap doi
    PhapSu(String name){
        super(name);
        this.setMana(this.getMana() * 2);
        this.hpStart = this.getHp();
    }

    public float getHpStart() {
        return hpStart;
    }

    public void setHpStart(float hpStart) {
        this.hpStart = hpStart;
    }

    // ti le regen tang len gap doi


    // tỉ lệ 30% , gây 200 dame  đồng thời gây choáng sau 2 lần đánh ,50 mana
    public void skillThunder(Dragon dragon) throws InterruptedException {
        if( this.getMana() >= 50){
            i++;
            this.setMana(this.getMana() - 50);
            dragon.setHp(dragon.getHp() - 200 - (2000 - dragon.getHp()));
            if(i == 2)
            {
                System.out.println("Dragon bi phap su danh va bi choang trong 2s ");
                Thread.sleep(5000);
                i=0;
            }
            if (dragon.getHp() <= 0) {
                System.out.println("Dragon da chet");
            }
        }
        else System.out.println("Xa thu danh truot dragon");
    }
}
