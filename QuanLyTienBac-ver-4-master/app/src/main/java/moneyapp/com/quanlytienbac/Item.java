package moneyapp.com.quanlytienbac;

public class Item {
    private int id;
    private String ten;
    private String ngay;
    private String tien;


    public Item(int id, String ten, String ngay,String tien) {
        this.id = id;
        this.ten = ten;
        this.ngay = ngay;
        this.tien = tien;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
