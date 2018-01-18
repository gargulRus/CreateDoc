        /**
         *Стрктура аналогична DocAddressGUI
         *Дополнительно введены JRadioButton для возможности выбора различных адресов и номеров БТИ
         */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DocLeaseGUI {

    public static JLabel documentNameLabel = new JLabel("1. Название Документа:");
    public static JTextField documentName = new JTextField(20);
    public static JLabel contractNumLabel = new JLabel("2. Номер Договора:");
    public static JTextField contractNum = new JTextField(20);
    public  static JLabel dateStartLabel = new JLabel("3. Дата заключения:");
    public static JTextField dateStart = new JTextField(20);
    public static JLabel dateEndLabel = new JLabel("4. Дата окончания:");
    public static JTextField dateEnd = new JTextField(20);
    public static JLabel entityNameLabel = new JLabel("5. Наименование организации:");
    public static JTextField entityName = new JTextField(20);
    public static JLabel rentorNameLabel = new JLabel("6. ФИО Генерального директора:");
    public static JTextField rentorName = new JTextField(20);
    public static JLabel rentorNamePLabel = new JLabel("7. ФИО Генерального директора в Родительном Падеже:");
    public static JTextField rentorNameP = new JTextField(20);
    public static JRadioButton radioAdress1 = new JRadioButton("Такая-то д.10, стр.1");
    public static JRadioButton radioAdress2 = new JRadioButton("Такая-то д.10, стр.2");
    public static JLabel roomNumLabel = new JLabel("9. Номер помещения:");
    public static JTextField roomNum = new JTextField(20);
    public static JLabel roomSpaceLabel = new JLabel("10. Объем помещения (кв.м.):");
    public static JTextField roomSpace = new JTextField(20);
    public static JLabel roomUsageLabel = new JLabel("11. Помещение используется под:");
    public static JTextField roomUsage = new JTextField(20);
    public static JLabel priceLabel = new JLabel("12. Арендная плата составляет: хх(хх) рублей хх коп.");
    public static JTextField price = new JTextField(20);
    public static JLabel priceVatLabel = new JLabel("13. Влючая НДС 18%:");
    public static JTextField priceVat = new JTextField(20);
    public static JLabel entityAdressLabel = new JLabel("14. Юридический адрес:");
    public static JTextField entityAdress = new JTextField(20);
    public static JLabel actualAdressLabel = new JLabel("15. Фактический адрес:");
    public static JTextField actualAdress = new JTextField(20);
    public static JLabel innLabel = new JLabel("16. ИНН:");
    public static JTextField inn = new JTextField(20);
    public static JLabel kppLabel = new JLabel("17. КПП:");
    public static JTextField kpp = new JTextField(20);
    public static JLabel bankLabel = new JLabel("18. Наименование Банка:");
    public static JTextField bank = new JTextField(20);
    public static JLabel rsLabel = new JLabel("19. Расчетный счет:");
    public static JTextField rs = new JTextField(20);
    public static JLabel ksLabel = new JLabel("20. Корр. счет:");
    public static JTextField ks = new JTextField(20);
    public static JLabel bikLabel = new JLabel("21. БИК:");
    public static JTextField bik = new JTextField(20);
    public static JLabel vatCalculateLabel = new JLabel("Расчет НДС");
    public static JTextField vatCalculate1 = new JTextField(20);
    public static JTextField vatCalculate2 = new JTextField(20);

    static String address = "";
    static String bti = "";
    static String roomN = "";

    public DocLeaseGUI(){

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
        JButton btnNdsCalc = new JButton("Расчет НДС");

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
        mainpanel.add(radioAdress1, new GridBagConstraints(1,7,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(radioAdress2, new GridBagConstraints(2,7,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(roomNumLabel, new GridBagConstraints(1,8,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(roomNum, new GridBagConstraints(2,8,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(roomSpaceLabel, new GridBagConstraints(3,8,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(roomSpace, new GridBagConstraints(4,8,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(roomUsageLabel, new GridBagConstraints(1,9,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(roomUsage, new GridBagConstraints(2,9,1,1,0,0,
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
        mainpanel.add(entityAdressLabel, new GridBagConstraints(1,13,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(entityAdress, new GridBagConstraints(2,13,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(actualAdressLabel, new GridBagConstraints(3,13,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(actualAdress, new GridBagConstraints(4,13,1,1,0,0,
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

        //КНОПКИ
        mainpanel.add(btnOk, new GridBagConstraints(5,17,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 1,1)
        );
        mainpanel.add(btnCancel, new GridBagConstraints(6,17,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 1,1)
        );

        mainpanel.add(btnNdsCalc, new GridBagConstraints(3,11,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 1,1)
        );

        btnOk.addActionListener(new ButtonOk());
        btnCancel.addActionListener(new ButtonCancel());
        btnNdsCalc.addActionListener(new ButtonNndsCalculate());


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

            /**
             * Запись в переменные address и bti зависит от выбранной JRadioButton.
             * В зависимости от выбранного объекта изменяетя адрес и выписка из БТИ о праве собственности
             */
            boolean rb1 = radioAdress1.isSelected();
            boolean rb2 = radioAdress2.isSelected();
            if (rb1 == true) {
                address = "Такая-то улица, д.10, корп.2, стр. 1 ";
                bti = "от «22 декабря 2001» г., номер записи о регистрации 11-АА-111111";
            } else if (rb2 == true) {
                address = "Такая-то улица, д.10, корп.2, стр. 2 ";
                bti = "от «11 апреля 2001» г., номер записи о регистрации 22-АН 222222";
            }

            //проверка поля ввода комнаты. Если поле было пустым - подставляет пустоту, вместо null
            roomN = roomNum.getText();
            if (roomN.length() <= 0) {
            } else {
                roomN = "ком." + roomN;
            }

            String roomSp = roomSpace.getText();
            String roomU = roomUsage.getText();
            String prise = price.getText();
            String pVat = priceVat.getText();
            String eAdress = entityAdress.getText();
            String aAdress = actualAdress.getText();
            String rInn = inn.getText();
            String rKpp = kpp.getText();
            String rBank = bank.getText();
            String rRs = rs.getText();
            String rKs = ks.getText();
            String rBik = bik.getText();

            /** После получения всех данных с JTextField и записи значений в переменные, происходит их передача в
             * класс формирующий получившийся документю.
             * После успешного формирования документа приложение закрывается.
             */
            new DocLeaseCreator(cName, cNum, dateS, dateE, eName, rName, rNameP, address, bti, roomN, roomSp,
                    roomU, prise, pVat, eAdress, aAdress, rInn, rKpp, rBank, rRs, rKs, rBik);

            System.exit(0);
        }
    }
    static class ButtonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    static class ButtonNndsCalculate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String ndsint1 = vatCalculate1.getText();
            int a = Integer.parseInt(ndsint1);
            double b = a * (1 - 1 / 1.18);
            String nd = new DecimalFormat("#0.00").format(b);
            vatCalculate2.setText(nd);

        }
    }

}
