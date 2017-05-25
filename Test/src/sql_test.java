/**
 * Created by OriginalS on 2017/4/20.
 */
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class sql_test {
    static public void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                UserLog frame = new UserLog();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class UserLog extends JFrame {
    private static final int WIDTH = 150;
    private static final int HEIGHT = 400;
    private JPanel Panel;
    private JPanel ButtonPanel;
    private sql_visit sqlCon;
    public UserLog() {
        setSize(HEIGHT, WIDTH);

        sqlCon = new sql_visit();
        JTextField nameInput = new JTextField();
        JPasswordField passwdInput = new JPasswordField("", 20);

        Panel = new JPanel();
        ButtonPanel = new JPanel();
        Panel.setLayout(new GridLayout(2,2));

        Panel.add(new JLabel("User name:", SwingConstants.RIGHT));
        Panel.add(nameInput);

        Panel.add(new JLabel("Passowrd:", SwingConstants.RIGHT));
        Panel.add(passwdInput);

        JButton LogIn = new JButton("Log in");
        ButtonPanel.add(LogIn);
        JButton SignIn = new JButton("Sign in");
        ButtonPanel.add(SignIn);

        add(Panel, BorderLayout.NORTH);
        add(ButtonPanel);
        LogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_name = nameInput.getText();
                char[] user_passwd1 = passwdInput.getPassword();
                String user_passwd = new String(user_passwd1);
                if (user_name.isEmpty() && user_passwd.isEmpty()) {
                    nameInput.setText("");
                    passwdInput.setText("");
                } else {
                    String cmd = String.format("select id from Info where name = \"%s\" and passwd = \"%s\"", user_name, user_passwd);
                    System.out.println(cmd);
                    if (!sqlCon.visit(cmd,1).isEmpty()) {
                        System.out.println("log in successful!");
                        PersonalInfo info = new PersonalInfo(new UserLog(), user_name);
                        setVisible(false);
                        info.setVisible(true);
                    } else {
                        nameInput.setText("");
                        passwdInput.setText("");
                    }
                }
            }
        });

        SignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserSign sign = new UserSign();
                sign.setVisible(true);
            }
        });
    }
}

class PersonalInfo extends JFrame {
    private JPanel textPan;
    private JPanel buttonPan;
    private JPanel Info;
    private sql_visit sqlCon;
    public PersonalInfo(UserLog LogIn, String name) {
       textPan = new JPanel();
       buttonPan = new JPanel();
       Info = new JPanel();
       sqlCon = new sql_visit();

       setSize(200,400);

       textPan.setLayout(new GridLayout(3,2));

       ArrayList<String> getInfo = GetInfo(name);

       textPan.add(new JLabel("name:", SwingConstants.RIGHT));
       textPan.add(new JLabel(getInfo.get(0)));
       getInfo.remove(0);

       textPan.add(new JLabel("id:", SwingConstants.RIGHT));
       textPan.add(new JLabel(getInfo.get(0)));
       getInfo.remove(0);

       Info.setLayout(new GridLayout(9,1));
       Info.add(new JLabel("INFO:"));
       for (String info: getInfo) {
           Info.add(new JLabel(info));
       }
       add(textPan,BorderLayout.NORTH);
       add(Info);
    }
    private ArrayList<String> GetInfo(String name) {
        ArrayList<String> info = new ArrayList<>(10);
        info  = sqlCon.visit(name, 2);
        return info;
    }
}

class UserSign extends JFrame {
    private JPanel SignIn;
    private JPanel Button;
    private sql_visit sqlCon;
    public UserSign() {
        setSize(500,200);
        sqlCon = new sql_visit();
        SignIn = new JPanel();
        Button = new JPanel();

        SignIn.setLayout(new GridLayout(3,2));

        SignIn.add(new JLabel("username",SwingConstants.RIGHT));
        JTextField nameInput = new JTextField();
        SignIn.add(nameInput);

        SignIn.add(new JLabel("password",SwingConstants.RIGHT));
        JPasswordField passwdInput = new JPasswordField();
        SignIn.add(passwdInput);

        SignIn.add(new JLabel("id", SwingConstants.RIGHT));
        JTextField idInput = new JTextField();
        SignIn.add(idInput);

        JButton confirm = new JButton("OK");
        JButton clear = new JButton("CLEAR");
        Button.add(confirm);
        Button.add(clear);

        add(SignIn, BorderLayout.NORTH);
        add(Button);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                char[] pd = passwdInput.getPassword();
                String passwd = new String(pd);
                String id = idInput.getText();
                String cmd1 = String.format("select id from Info where name = \"%s\" and passwd = \"%s\"", name, passwd);
                if (sqlCon.visit(cmd1,1).toString().length() != 0) {
                    String cmd2 = String.format("insert into Info(id, name, passwd) values (\"%s\", \"%s\", \"%s\")",id, name, passwd);
                    sqlCon.insert(cmd2);
                }
                setVisible(false);
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameInput.setText("");
                passwdInput.setText("");
                idInput.setText("");
            }
        });
    }
}

class sql_visit {
    private Connection con;
    private String drive;
    private String url;
    private String user;
    private String passwd;
    public sql_visit () {
        System.out.println("hello,sql");
        drive = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/mytest";
        user = "root";
        passwd = "pannidellx";
    }
    public boolean insert(String cmd) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(cmd);
            ps.executeUpdate();
            System.out.println("ok");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public ArrayList<String> visit(String cmd , int mode) {
        ResultSet rs;
        try {
            Class.forName(drive);
            try {
                con = DriverManager.getConnection(url, user, passwd);
                Statement statement = con.createStatement();
                switch (mode) {
                    case 1: {
                        rs = statement.executeQuery(cmd);
                        if (rs.next()) {
                            System.out.println("successful!");
                            ArrayList<String> s = new ArrayList<>(1);
                            s.add("true");
                            rs.close();
                            return s;
                        }
                        rs.close();
                        break;
                    }
                    case 2: {
                        cmd = String.format("select name,id from Info where name=\"%s\"", cmd);
                        System.out.println(cmd);
                        rs = statement.executeQuery(cmd);
                        ArrayList<String> s = new ArrayList<>(10);
                        if (rs.next()) {
                            System.out.println("get the info successful");
                            String id = rs.getString("id");
                            s.add(rs.getString("name"));
                            s.add(id);
                            cmd = String.format("select * from studentInfo where id = \"%s\"", id);
                            rs = statement.executeQuery(cmd);
                            while (rs.next() && s.size() != 10) {
                                s.add(rs.getString("info"));
                            }
                            rs.close();
                            return s;
                        }
                        rs.close();
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            System.out.println("get the data successful");
        }
        return new ArrayList<>(0);
    }
    public static void main(String[] args) {
        sql_visit a = new sql_visit();
        a.visit("select * from Info", 1);
    }
}
