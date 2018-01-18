import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartGUI {

    public StartGUI() {
        /**
         * Создаем первичное окно frame.
         * В нем помещаем три кнопки btnDocLease, btnDocAddress и btnExit
         * При нажатии на кнопку btnDocLease создается форма для создания договора Аренды помещения(DocAddressGUI)
         * При нажатии на кнопку btnDocAddress создается форма для создания договора на Юр.Адрес(DocLealeGUI)
         * При нажатии на кнопку btnExit программа закрывается.
         */
        final JFrame frame = new JFrame();
        frame.setSize(600, 200);
        frame.setTitle(Main.frameName);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridBagLayout());

        JButton btnDocLease = new JButton("Договор на Аренду помещения");
        JButton btnDocAddress = new JButton("Договор на Юр. Адрес");
        JButton btnExit = new JButton("Выход");
        
        mainpanel.add(btnDocLease, new GridBagConstraints(1, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20, 10, 0, 2), 0, 0)
        );

        mainpanel.add(btnDocAddress, new GridBagConstraints(3, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20, 10, 0, 2), 0, 0)
        );

        mainpanel.add(btnExit, new GridBagConstraints(5, 15, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20, 10, 0, 0), 1, 1)
        );

        frame.add(mainpanel);
        frame.setVisible(true);
        frame.pack();

        btnDocLease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DocLeaseGUI();
                frame.setVisible(false);
            }
        });

        btnDocAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DocAddressGUI();
                frame.setVisible(false);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
