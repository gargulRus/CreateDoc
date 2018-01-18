import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DocAddressGUI {

    private static JLabel documentNameLabel = new JLabel("1. Название Документа:");
    private static JTextField documentName = new JTextField(20);
    private  static JLabel contractNumLabel = new JLabel("2. Номер Договора:");
    private  static JTextField contractNum = new JTextField(20);
    private static JLabel dateStartLabel = new JLabel("3. Дата заключения:");
    private static JTextField dateStart = new JTextField(20);
    private static JLabel dateEndLabel = new JLabel("4. Дата окончания:");
    private static JTextField dateEnd = new JTextField(20);
    private static JLabel entityNameLabel = new JLabel("5. Наименование организации:");
    private static JTextField entityName = new JTextField(20);
    private static JLabel rentorNameLabel = new JLabel("6. ФИО Генерального директора:");
    private static JTextField rentorName = new JTextField(20);
    private static JLabel rentorNamePLabel = new JLabel("7. ФИО Генерального директора в Родительном Падеже:");
    private static JTextField rentorNameP = new JTextField(20);
    private static JLabel priceLabel = new JLabel("8. Стоимость оказания услуг: хх(хх) рублей хх коп.");
    private static JTextField price = new JTextField(20);
    private static JLabel priceVatLabel = new JLabel("9. Влючая НДС 18%:");
    private static JTextField priceVat = new JTextField(20);
    private static JLabel actualAdressLabel = new JLabel("10. Фактический адрес:");
    private static JTextField actualAdress = new JTextField(20);
    private static JLabel innLabel = new JLabel("11. ИНН:");
    private static JTextField inn = new JTextField(20);
    private static JLabel kppLabel = new JLabel("12. КПП:");
    private static JTextField kpp = new JTextField(20);
    private static JLabel bankLabel = new JLabel("13. Наименование Банка:");
    private static JTextField bank = new JTextField(20);
    private static JLabel rsLabel = new JLabel("14. Расчетный счет:");
    private static JTextField rs = new JTextField(20);
    private static JLabel ksLabel = new JLabel("15. Корр. счет:");
    private static JTextField ks = new JTextField(20);
    private static JLabel bikLabel = new JLabel("16. БИК:");
    private static JTextField bik = new JTextField(20);
    private static JLabel phoneLabel = new JLabel("17. Телефон:");
    private static JTextField phone = new JTextField(20);
    private static JLabel emailLabel = new JLabel("18. Эл. почта:");
    private static  JTextField email = new JTextField(20);
    private static JLabel vatCalculateLabel = new JLabel("Расчет НДС");
    private static JTextField vatCalculate1 = new JTextField(20);
    private static JTextField vatCalculate2 = new JTextField(20);

    public DocAddressGUI (){
        /**
         * Создаем главное окно frame. В нем размещаем mainpamel(JPanel). На mainpanel размещаем элементы интерфейса
         * программы JLabel и JTextField, а так же кнопки "Ok" и "Cancel" (JButton).
         * Разметку задаем через GridBagLayout.
         * Далее создаем скроллбар scroll(JScrollPane). В него передаем mainpanel с объектами.
         * Далее объект scroll добавляем на frame.
         */
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setTitle(Main.frameName);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridBagLayout());

        JButton btnOk = new JButton("Ok");
        JButton btnCancel = new JButton("Cancel");
        JButton btnVatCalc = new JButton("Расчет НДС");

        mainpanel.add(documentNameLabel, new GridBagConstraints(1,0,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(documentName, new GridBagConstraints(2,0,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(contractNumLabel, new GridBagConstraints(3,0,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(contractNum, new GridBagConstraints(4,0,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(dateStartLabel, new GridBagConstraints(1,1,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(dateStart, new GridBagConstraints(2,1,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(dateEndLabel, new GridBagConstraints(3,1,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(dateEnd, new GridBagConstraints(4,1,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(entityNameLabel, new GridBagConstraints(1,2,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(entityName, new GridBagConstraints(2,2,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(rentorNameLabel, new GridBagConstraints(3,2,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(rentorName, new GridBagConstraints(4,2,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(rentorNamePLabel, new GridBagConstraints(1,6,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(rentorNameP, new GridBagConstraints(2,6,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        //поле расчета НДС
        mainpanel.add(vatCalculateLabel, new GridBagConstraints(1,10,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(vatCalculate1, new GridBagConstraints(1,11,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(vatCalculate2, new GridBagConstraints(2,11,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(priceLabel, new GridBagConstraints(1,12,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(price, new GridBagConstraints(2,12,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(priceVatLabel, new GridBagConstraints(3,12,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(priceVat, new GridBagConstraints(4,12,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(actualAdressLabel, new GridBagConstraints(1,13,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(actualAdress, new GridBagConstraints(2,13,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(innLabel, new GridBagConstraints(1,14,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(inn, new GridBagConstraints(2,14,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(kppLabel, new GridBagConstraints(3,14,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(kpp, new GridBagConstraints(4,14,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(bankLabel, new GridBagConstraints(1,15,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(bank, new GridBagConstraints(2,15,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(rsLabel, new GridBagConstraints(3,15,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(rs, new GridBagConstraints(4,15,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(ksLabel, new GridBagConstraints(1,16,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(ks, new GridBagConstraints(2,16,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(bikLabel, new GridBagConstraints(3,16,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(bik, new GridBagConstraints(4,16,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(phoneLabel, new GridBagConstraints(1,17,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(phone, new GridBagConstraints(2,17,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(emailLabel, new GridBagConstraints(3,17,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(email, new GridBagConstraints(4,17,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        //КНОПКИ
        mainpanel.add(btnOk, new GridBagConstraints(5,18,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 1,1)
        );
        mainpanel.add(btnCancel, new GridBagConstraints(6,18,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 1,1)
        );

        mainpanel.add(btnVatCalc, new GridBagConstraints(3,11,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 1,1)
        );

        btnOk.addActionListener(new ButtonOk());
        btnCancel.addActionListener(new ButtonCancel());
        btnVatCalc.addActionListener(new ButtonVatCalculate());

        JScrollPane scroll = new JScrollPane(mainpanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        frame.setVisible(true);
        frame.pack();
    }

    /**
     * Создаем слушатель для кнопки "Ок".
     * По нажатию на кнопку в класс передаются данные их TextField и записываются в переменные
     * Формирование имени документа:
     * Значение переменной полученной в поле dName записывается в  переменную dogname
     * с подстановкой расширения документа (.docx)
     */
    static class ButtonOk implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String dName = documentName.getText();
            String cName = dName + ".docx";
            String cNum = contractNum.getText();
            String dateS = dateStart.getText();
            String dateE = dateEnd.getText();
            String eName = entityName.getText();
            String rName = rentorName.getText();
            String rNameP = rentorNameP.getText();
            String prise = price.getText();
            String pVat = priceVat.getText();
            String aAdress = actualAdress.getText();
            String rInn = inn.getText();
            String rKpp = kpp.getText();
            String rBank = bank.getText();
            String rRs = rs.getText();
            String rKs = ks.getText();
            String rBik = bik.getText();
            String rPhone = phone.getText();
            String rEmail = email.getText();

            /** После получения всех данных с JTextField и записи значений в переменные, происходит их передача в
             * класс формирующий получившийся документ(DocAddressCreator).
             * После успешного формирования документа приложение закрывается.
             */
            new DocAddressCreator(cName, cNum, dateS, dateE, eName, rName, rNameP,
                    prise, pVat, aAdress, rInn, rKpp, rBank, rRs, rKs, rBik, rPhone, rEmail);

            System.exit(0);
        }
    }

    static class ButtonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }
    
    //Расчет суммы НДС
    static class ButtonVatCalculate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String ndsint1 = vatCalculate1.getText();
            int a = Integer.parseInt(ndsint1);
            double b = a * (1 - 1 / 1.18);
            String d = new DecimalFormat("#0.00").format(b);
            vatCalculate2.setText(d);

        }
    }

}