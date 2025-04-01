import  java.sql.*;
public class P7_jdbc {
    //in this jdbc example we retrieve data from the db
        public static void main(String[] args) throws ClassNotFoundException{
//        now first step to load the driver related to the jdbc connection
//        which  are present inside the java.sql.* package in static block

//        these three credentials required to connect database
            String url = "jdbc:mysql://127.0.0.1:3306/pblj";
            String user = "root";
            String pass = "Arpit(7837)!94.8";

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Drive loaded Successfully...");
            }
            catch (ClassNotFoundException e){
                System.out.println("Driver not loaded : "+e.getMessage());
            }
//        forName method can through exception to classNotFound, so we have to handle it
//        next step to create connection
            try{
                Connection con = DriverManager.getConnection(url,user,pass);
                System.out.println("Connection established successfully..");

//            next step to create a statement
                Statement st = con.createStatement();
//            execute query and store the value in resultset
                ResultSet res = st.executeQuery("select * from employee;");

                while(res.next()){
                    System.out.println(res.getInt("empid") +"  "+res.getString("name") +"   "+res.getInt("salary"));
//                System.out.println(res);
                }
                res.close();
                st.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Exception occur : "+e.getMessage());
            }
//        now we know that this line can through sqlException so we have to handle it
        }
    }

