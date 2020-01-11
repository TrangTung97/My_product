package bai.tap.java.core.giai.cuu.cong.chua;

public class ChienBinh extends NhanVat {
    private float hpStart;

    //HP tăng gấp đôi , Giam 20% sat thuong nhan vao
    ChienBinh (String name){
        super(name);
        this.setHp(this.getHp()*2);
        this.hpStart = this.getHp();
        this.setPhanTramGiam(0.8f);
    }
    public float getHpStart() {
        return hpStart;
    }

    public void setHpStart(float hpStart) {
        this.hpStart = hpStart;
    }



    // Có thêm skill BlockDame() (ti le 100% Phản lại 50% sát nhận vào)
    public void blockDam(Dragon dragon) {
        dragon.setHp(dragon.getHp() - 50 * 0.5f);
        if (dragon.getHp() <= 0) {
            System.out.println("Dragon da chet");
        }
    }

}
