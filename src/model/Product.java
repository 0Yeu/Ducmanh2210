package model;

public class Product {

        private int Id;
        private String Productname;
        private double Price;
        private int Amount;
        private int IdCategory;

        public int getId() {
                return Id;
        }

        public void setId(int id) {
                this.Id = id;
        }

        public String getProductname() {
                return Productname;
        }

        public void setProductname(String productname) {
                this.Productname = productname;
        }

        public double getPrice() {
                return Price;
        }

        public void setPrice(double price) {
                this.Price = price;
        }

        public int getAmount() {
                return Amount;
        }

        public void setAmount(int amount) {
                this.Amount = amount;
        }

        public int getIdCategory() {
                return IdCategory;
        }

        public void setIdCategory(int idcategory) {
                this.IdCategory = idcategory;
        }

}
