package in.abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

 
public class Db implements AutoCloseable{
    public final static String URL = "jdbc:oracle:thin:@localhost";
    public final static String USERNAME = "dhavan";
    private  final static String PASSWORD="dhavan";
    private final static String DRIVER = "oracle.jdbc.OracleDriver";
    
    static {
        try {
            Class.forName(DRIVER);
             System.out.println("Driver Loaded successfully.s");
        } catch (Exception e) {
            System.out.println("Cannot load driver " + e);
        }
    } 
    
    private Connection cn;
    private PreparedStatement st;
    private ResultSet rs;
    
    public static Connection getCn() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
     //Constructor
    public Db(String sql) throws Exception {
        cn = getCn();
        st = cn.prepareStatement(sql);
    }
    public PreparedStatement getSt() throws Exception {
        return st;
    }
    
    public int execute() throws Exception {
        return st.executeUpdate();
    }
    public Object[] row() throws Exception {
        Object []ar=null;
        rs = st.executeQuery();
        if(rs.next()){
            int column = rs.getMetaData().getColumnCount();
            ar = new Object[column];
            for(int i=0;i<column;i++){
                ar[i]  = rs.getObject(i+1);
            }
        }
        return ar;
    }
    public List<Object[]> rows() throws Exception {
        List<Object[]> list=new ArrayList<>();
       
        rs = st.executeQuery();
        while(rs.next()){
            int column = rs.getMetaData().getColumnCount();
            Object []ar = new Object[column];
            for(int i=0;i<column;i++){
                ar[i]  = rs.getObject(i+1);
            }
            list.add(ar);
        }
        return list;
    }
    public void dispose() {
        if(cn!=null){
            try {
                cn.close();
            } catch (Exception e) { /* */  }
        }
        if(st!=null){
            try {
                st.close();
            } catch (Exception e) { /* */  }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) { /* */  }
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Auto Disposing resources...");
        dispose();
    }
    
}
