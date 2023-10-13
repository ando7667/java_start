package Java_DevKit.HW1task5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static Java_DevKit.HW1task5.FileOperation.loadChatFromFile;
import static Java_DevKit.HW1task5.FileOperation.saveChatToFile;

public class ChatClient extends JFrame {

    private static boolean isLoginServer;
    private static final int WIN_WIDHT = 500;
    private static final int WIN_HEIGHT = 400;
    private static final int WIN_X = 200;
    private static final int WIN_Y = 200;
    private static final String WIN_NAME = "Chat Client";

    String[] lstUserData = {
            "Андрей",
            "Ольга",
            "Катя",
            "Иван",
            "Коля",
            "Серж",
            "Даня",
            "Саня"
    };
    JPanel panLogin = new JPanel(new GridLayout(2, 3));
    JPanel panSendMsg = new JPanel(new BorderLayout());

    JTextField addrServer = new JTextField("127.0.0.1");
    JTextField portServer = new JTextField("51200");
    JTextField userLogin = new JTextField("login");
    JPasswordField userPass = new JPasswordField("password");
    JButton btnLogin = new JButton("Login");
    JButton btnOut = new JButton("Out");
    JTextArea chatHistory = new JTextArea();

    JList lstUser = new JList(lstUserData);
    JScrollPane scrUserLst = new JScrollPane(lstUser);
    JTextField msgSend = new JTextField();
    JButton btnSend = new JButton("Send");

    ChatClient() {
        isLoginServer = false;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIN_WIDHT, WIN_HEIGHT);
        setTitle(WIN_NAME);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isLoginServer) {
                    if (!Objects.equals(userLogin.getText(), "login")) {
                        isLoginServer = true;
                        chatHistory.append(userLogin.getText() + " подключился к чату\n");
                        try {
                            loadMessageChat();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        chatHistory.append("Введите логин пользователя\n");
                    }
                }
            }
        });

        btnOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLoginServer) {
                    isLoginServer = false;
                    chatHistory.append(userLogin.getText() + " отключился от чата\n");
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sendMessageChat();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        msgSend.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        sendMessageChat();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        panLogin.add(addrServer);
        panLogin.add(portServer);
        panLogin.add(userLogin);
        panLogin.add(userPass);
        panLogin.add(btnLogin);
        panLogin.add(btnOut);
        add(panLogin, BorderLayout.NORTH);

        lstUser.setLayoutOrientation(JList.VERTICAL);
        lstUser.setVisibleRowCount(0);
        scrUserLst.setPreferredSize(new Dimension(100, 30));
        panSendMsg.add(scrUserLst, BorderLayout.WEST);
        panSendMsg.add(msgSend, BorderLayout.CENTER);
        panSendMsg.add(btnSend, BorderLayout.EAST);
        add(panSendMsg, BorderLayout.SOUTH);

        chatHistory.setEditable(false);
        JScrollPane scroll = new JScrollPane(chatHistory);
        add(scroll);

        setVisible(true);
    }

    private void sendMessageChat() throws IOException {
        if (isLoginServer) {
            String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss")).toString() + " " + userLogin.getText() + " -> " + ((lstUser.getSelectedValue()!= null)?lstUser.getSelectedValue():"Всем") + ": " + msgSend.getText() + "\n";
            chatHistory.append(str);
            saveChatToFile(str);
        } else {
            chatHistory.append("Нет подключения к серверу чата!\n");
        }
    }

    private void loadMessageChat() throws IOException {
        if (isLoginServer) {
            chatHistory.append(loadChatFromFile());
            chatHistory.append("\n");
        }
    }
}
