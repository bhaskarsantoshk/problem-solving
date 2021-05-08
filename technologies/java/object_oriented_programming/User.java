package technologies.java.object_oriented_programming;

 class User {

     private String userName;
     private String password;

     public User(String userName, String password){
         this.userName = userName;
         this.password = password;
     }

     public void login(String userName, String password){
         if(this.userName.toLowerCase().equals(userName.toLowerCase())
                 && this.password.equals(password)){
             System.out.println("Login success");
         } else {
             System.out.println("Invalid Creds");
         }
     }

}

class Main{
     public static void main(String[] args){
         User user1 = new User("Batman", "1234");
         user1.login("Batman", "1234");
         user1.login("Alfred", "1234");
     }
}
