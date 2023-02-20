import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OnlineShop onlineShop = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());

        Product p1 = new Product("Laptop", 3200.5, 1,1, 1123, new Date());
        Product p2 = new Product("Frigider", 207.95, 1,2, 1245, new Date());

        Product p3 = new Product(p1);

        p3.setQty(5);
        p3.setName("Paine");

        onlineShop.modifyProductsList(1,p1);
        onlineShop.modifyProductsList(1,p2);

        onlineShop.modifyProductsList(2, p1);
        System.out.println(p1.equals(p2));
    }
}

class OnlineShop {
    private String name;
    private String image;
    private ArrayList<Product> products;

    OnlineShop(String name, String image, ArrayList<Product> products)
    {
        this.products = new ArrayList<Product>();
        this.image = image;
        this.name = name;
    }

    public void modifyProductsList(int what, Product p)
    {
        if(what == 1)
        {
            this.products.add(p);
        }
        else
            this.products.remove(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String img) {
        this.image = img;
    }
}

class Product
{
    private int id;
    private String name;
    private double price;
    private int type;
    private int category;
    private int qty;
    private Date expiryDate; //expiry date - only for goods
    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)

    public Product(String name, double price, int type, int category, int id, Date expiryDate)
    {
        this.name = name;
        this.price = price;
        this.type = type;
        this.category = category;
        this.id = id;
        this.expiryDate = expiryDate;
    }

    public Product(Product p)
    {
        this.name = p.name;
        this.price = p.price;
        this.type = p.type;
        this.category = p.category;
        this.id = p.id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //Compares the id,name,price and category
    public boolean equals(Product p)
    {
        if(p.id != this.id)
            return false;
        if(!p.name.equals(this.name))
            return false;
        if(p.price != this.price)
            return false;
        if(p.type != p.type)
            return false;
        if(p.category != this.category)
            return false;

        return true;
    }

    public void modifyPrice(boolean flag, double val)
    {
        if(flag)
            this.price+=this.price*val;
        if(!flag)
            this.price-=this.price*val/100;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

class User
{
    private String username;
    private String id;
    private ArrayList<Order> orders;
    private ArrayList<Order> c;

    public User(String username, String id)
    {
        this.username = username;
        this.id = id;
        orders=new ArrayList<Order>();
        c=new ArrayList<Order>();
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }

    public void addO2(Order order)
    {
        this.c.add(order);
    }
}

class Order
{
    private ArrayList<Product> products;
    private String address;

    public Order()
    {
        products = new ArrayList<Product>();
    }
    public void addProduct(Product p)
    {
        if(products.size() > 99)
            return;

        products.add(p);
    }

    public void removeProduct(Product p)
    {
        products.remove(p);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class InventoryProduct
{
    private Product product;
    private int quantity;

    public InventoryProduct(Product p, int q)
    {
        this.product = new Product(p);
        this.quantity = q;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product p) {
        this.product = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }
}


