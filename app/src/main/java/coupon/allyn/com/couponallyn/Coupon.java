package coupon.allyn.com.couponallyn;

/**
 * 优惠券列表 on 2017/4/5.
 */

public class Coupon {

    /***
     * 说明：je:优惠券金额
     Lastday:最后使用日期
     Status:状态 0=可使用 1=已使用 2=已过期
     */


    public Coupon(int id, double je, int status, String lastday, String name) {
        this.id = id;
        this.je = je;
        this.status = status;
        this.lastday = lastday;
        this.name = name;
    }

    /**
     * id : 123
     * je : 123.12
     * status : 0
     * lastday : 2017-12-12 12:12:12
     * name : 优惠券名字
     */

    private int id;
    private double je;
    private int status;
    private String lastday;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getJe() {
        return je;
    }

    public void setJe(double je) {
        this.je = je;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLastday() {
        return lastday;
    }

    public void setLastday(String lastday) {
        this.lastday = lastday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
