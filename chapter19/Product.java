public class Product 
{
    private String stockNumber;
    private String manufacturer;
    private String item;
    private double unitPrice;

    public Product(String stockNumberIn, String manufacturerIn, String itemIn, double unitPriceIn)
    {
        stockNumber = stockNumberIn;
        manufacturer = manufacturerIn;
        item = itemIn;
        unitPrice = unitPriceIn;
    }
    
    public Product()
    {
    
    }
    
    public String getStockNumber()
    {
        return stockNumber;
    }
    
     public void setStockNumber(String stockNumberIn)
    {
        stockNumber = stockNumberIn;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturerIn)
    {
        manufacturer = manufacturerIn;
    }
    

    public String getItem()
    {
        return item;
    }
    
    public void setItem(String itemIn)
    {
        item = itemIn;
    }
    
    public double getUnitPrice()
    {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPriceIn)
    {
        unitPrice = unitPriceIn;
    }
}