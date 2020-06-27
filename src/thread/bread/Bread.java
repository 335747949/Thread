package thread.bread;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Bread {

    private Integer id;
    private String productName;

    public Bread() {
    }

    public Bread(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
