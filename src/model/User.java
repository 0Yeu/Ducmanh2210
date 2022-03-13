package model;

public class User {

        private int Id;
        private String Name;
        private String Phone;
        private String Username;
        private String Password;
        private String Role;
        private String Favourites;
        private String About;

        public int getId() {
                return Id;
        }

        public void setId(int id) {
                this.Id = id;
        }

        public String getName() {
                return Name;
        }

        public void setName(String name) {
                this.Name = name;
        }

        public String getPhone() {
                return Phone;
        }

        public void setPhone(String phone) {
                this.Phone = phone;
        }

        public String getUsername() {
                return Username;
        }

        public void setUsername(String username) {
                this.Username = username;
        }

        public String getPassword() {
                return Password;
        }

        public void setPassword(String password) {
                this.Password = password;
        }

        public String getRole() {
                return Role;
        }

        public void setRole(String role) {
                this.Role = role;
        }

        public String getFavourites() {
                return Favourites;
        }

        public void setFavourites(String favourites) {
                this.Favourites = favourites;
        }

        public String getAbout() {
                return About;
        }

        public void setAbout(String about) {
                this.About = about;
        }

}
