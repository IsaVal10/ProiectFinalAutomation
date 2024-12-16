package pages;

public class ProductPage {
    private String name;
    private String price;
    private String url;

    public ProductPage (String name, String price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price='" + price + "', url='" + url + "'}";
    }

    public boolean isProductValid() {
    return (name != null && !name.isEmpty()) &&
    (price != null && !price.isEmpty()) &&
    (url != null && !url.isEmpty());
    }
}

