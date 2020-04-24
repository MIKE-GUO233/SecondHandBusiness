package panels;

import components.Colors;
import components.MKButton;
import components.VerticalFlowLayout;
import frames.AboutFrame;
import frames.ChangePasswordFrame;
import listener.AbstractMouseListener;
import utils.FontUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MePanel extends JPanel {
    private JPanel upPanel;
    private JPanel middlePanel;
    private JPanel downPanel;
    private JLabel welcomeLabel;
    private JLabel collectionLabel;
    private JLabel followLabel;
    private JLabel fanLabel;
    private JLabel postLabel;
    private JLabel sellLabel;
    private JLabel boughtLabel;
    private MKButton changePasswordButton;
    private MKButton clearCacheButton;
    private MKButton aboutButton;
    private MKButton logoutButton;

    public MePanel(){
        initComponents();
        initView();
        setListener();
    }

    private void initComponents() {
        upPanel = new JPanel();
        middlePanel = new JPanel();
        downPanel = new JPanel();
//        upPanel.setBorder(new LineBorder(Colors.MAIN_COLOR));
//        middlePanel.setBorder(new LineBorder(Colors.MAIN_COLOR));
//        downPanel.setBorder(new LineBorder(Colors.MAIN_COLOR));

        ImageIcon postIcon = new ImageIcon("res/image/posted.png");
        ImageIcon sellIcon = new ImageIcon("res/image/sold.png");
        ImageIcon boughtIcon = new ImageIcon("res/image/bought.png");

        welcomeLabel = new JLabel("<html>欢 迎<br>MIKE</html>");
        collectionLabel = new JLabel("0" + "收藏",SwingConstants.CENTER);
        followLabel = new JLabel("0" + "关注",SwingConstants.CENTER);
        fanLabel = new JLabel("0" + "粉丝",SwingConstants.CENTER);
        postLabel = new JLabel("我发布的", postIcon, SwingConstants.CENTER);
        sellLabel = new JLabel("我卖出的", sellIcon, SwingConstants.CENTER);
        boughtLabel = new JLabel("我买到的", boughtIcon, SwingConstants.CENTER);

        changePasswordButton = new MKButton("修改密码");
        clearCacheButton = new MKButton("清除缓存");
        aboutButton = new MKButton("关于");
        logoutButton = new MKButton("退出登录");

        upPanel.setPreferredSize(new Dimension(840,100));
        upPanel.setBackground(Colors.WINDOW_BACKGROUND_LIGHT);
        middlePanel.setPreferredSize(new Dimension(840,330));
        middlePanel.setBackground(Colors.WINDOW_BACKGROUND_LIGHT);
        downPanel.setPreferredSize(new Dimension(840,275));
        downPanel.setBackground(Colors.WINDOW_BACKGROUND_LIGHT);
        welcomeLabel.setFont(FontUtil.getDefaultFont(28));

        setLabel(collectionLabel);
        setLabel(followLabel);
        setLabel(fanLabel);
        setLabel(postLabel);
        setLabel(sellLabel);
        setLabel(boughtLabel);

        setButton(changePasswordButton);
        setButton(clearCacheButton);
        setButton(aboutButton);
        setButton(logoutButton);
    }

    private void initView() {
        upPanel.add(welcomeLabel);

        middlePanel.add(collectionLabel);
        middlePanel.add(followLabel);
        middlePanel.add(fanLabel);
        middlePanel.add(postLabel);
        middlePanel.add(sellLabel);
        middlePanel.add(boughtLabel);
        middlePanel.setLayout(new GridLayout(2, 3, 10, 10));

        downPanel.add(changePasswordButton);
        downPanel.add(clearCacheButton);
        downPanel.add(aboutButton);
        downPanel.add(logoutButton);
        downPanel.setLayout(new VerticalFlowLayout(VerticalFlowLayout.TOP, 330, 10, false, false));

        setBackground(Colors.WINDOW_BACKGROUND_LIGHT);
        setLayout(new BorderLayout());
        add(upPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(downPanel, BorderLayout.SOUTH);
    }

    private void setButton (MKButton button) {
        button.setColor(Colors.MAIN_COLOR, Colors.MAIN_COLOR_DARKER,Colors.MAIN_COLOR_DARKER);
        button.setPreferredSize(new Dimension(180,35));
        button.setFont(FontUtil.getDefaultFont(20));
        button.setForeground(Colors.FONT_WHITE);
    }

    private void setLabel(JLabel label) {
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setFont(FontUtil.getDefaultFont(20));
    }

    private void setListener() {
        logoutButton.addMouseListener(new AbstractMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        clearCacheButton.addMouseListener(new AbstractMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        aboutButton.addMouseListener(new AbstractMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AboutFrame f = new AboutFrame();
            }
        });

        changePasswordButton.addMouseListener(new AbstractMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChangePasswordFrame f = new ChangePasswordFrame();
            }
        });
    }
}
