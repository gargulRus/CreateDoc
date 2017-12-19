/**
 * Программа формирует типовой договор аренды. Документ создается и размечается с помощью библиотеки ApachePOI 3-17
 * и XMLBeans 2.6.0.
 *@author Nikolay Gabaraev (gargul_rus)
 *@version 0.1
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public class Main {
 /**
  *  Создание полей для ввода данных. Сначала создается Label, затем TextField. Так же создается
  * два объекта JRadioButton, они нужны для добавления возможности выбора адреса объекта аренды.
  */
 private static JLabel docNameLabel = new JLabel("1. Название Документа:");
    private static JTextField docName = new JTextField(20);
    private  static JLabel dogNumLabel = new JLabel("2. Номер Договора:");
    private  static JTextField dogNum = new JTextField(20);
    private static JLabel dateStartLabel = new JLabel("3. Дата заключения:");
    private static JTextField dateStart = new JTextField(20);
    private static JLabel dateEndLabel = new JLabel("4. Дата окончания:");
    private static JTextField dateEnd = new JTextField(20);
    private static JLabel urNameLabel = new JLabel("5. Наименование организации:");
    private static JTextField urName = new JTextField(20);
    private static JLabel arendatorFioLabel = new JLabel("6. ФИО Генерального директора:");
    private static JTextField arendatorFio = new JTextField(20);
    private static JLabel arendatorFioPLabel = new JLabel("7. ФИО Генерального директора в Родительном Падеже:");
    private static JTextField arendatorFioP = new JTextField(20);
    private static JRadioButton radioAdress1 = new JRadioButton("Такая-то улица д.8, стр.1");
    private static JRadioButton radioAdress2 = new JRadioButton("Такая-то улица д.8, стр.2");
    private static JLabel roomNumLabel = new JLabel("9. Номер помещения:");
    private static JTextField roomNum = new JTextField(20);
    private static JLabel roomSpaceLabel = new JLabel("10. Объем помещения (кв.м.):");
    private static JTextField roomSpace = new JTextField(20);
    private static JLabel roomUsageLabel = new JLabel("11. Помещение используется под:");
    private static JTextField roomUsage = new JTextField(20);
    private static JLabel priceLabel = new JLabel("12. Введите цену по аналогии: Арендная плата составляет: хх(хх) рублей хх коп.");
    private static JTextField price = new JTextField(20);
    private static JLabel priceNdsLabel = new JLabel("13. Влючая НДС 18%:");
    private static JTextField priceNds = new JTextField(20);
    private static JLabel urAdressLabel = new JLabel("14. Юридический адрес:");
    private static JTextField urAdress = new JTextField(20);
    private static JLabel fizAdressLabel = new JLabel("15. Фактический адрес:");
    private static JTextField fizAdress = new JTextField(20);
    private static JLabel innLabel = new JLabel("16. ИНН:");
    private static JTextField inn = new JTextField(20);
    private static JLabel kppLabel = new JLabel("17. КПП:");
    private static JTextField kpp = new JTextField(20);
    private static JLabel bankLabel = new JLabel("18. Наименование Банка:");
    private static JTextField bank = new JTextField(20);
    private static JLabel rsLabel = new JLabel("19. Расчетный счет:");
    private static JTextField rs = new JTextField(20);
    private static JLabel ksLabel = new JLabel("20. Корр. счет:");
    private static JTextField ks = new JTextField(20);
    private static JLabel bikLabel = new JLabel("21. БИК:");
    private static JTextField bik = new JTextField(20);

    static String address ="";
    static  String bti = "";
    static String roomN ="";
    public static void main(String[] args) {
         /**
          * Создаем главное окно frame. В нем размещаем mainpamel(JPanel). На mainpanel размещаем элементы интерфейса
          * программы JLabel и JTextField, а так же кнопки "Ok" и "Cancel" (JButton).
          * Разметку задаем через GridBagLayout.
          * Далее создаем скроллбар scroll(JScrollPane). В него передаем mainpanel с объектами.
          * Далее объект scroll добавляем на frame.
          */
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setTitle("Договор Аренда ver 0.2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridBagLayout());

        JButton btnOk = new JButton("Ok");
        JButton btnCancel = new JButton("Cancel");

        mainpanel.add(docNameLabel, new GridBagConstraints(1,0,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(docName, new GridBagConstraints(2,0,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(dogNumLabel, new GridBagConstraints(3,0,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(dogNum, new GridBagConstraints(4,0,1,1,0,0,
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

        mainpanel.add(urNameLabel, new GridBagConstraints(1,2,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(urName, new GridBagConstraints(2,2,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(arendatorFioLabel, new GridBagConstraints(3,2,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(arendatorFio, new GridBagConstraints(4,2,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        mainpanel.add(arendatorFioPLabel, new GridBagConstraints(1,6,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(arendatorFioP, new GridBagConstraints(2,6,1,1,0,0,
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

        mainpanel.add(priceLabel, new GridBagConstraints(3,9,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(price, new GridBagConstraints(4,9,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(priceNdsLabel, new GridBagConstraints(1,10,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(priceNds, new GridBagConstraints(2,10,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(urAdressLabel, new GridBagConstraints(3,10,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(urAdress, new GridBagConstraints(4,10,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(fizAdressLabel, new GridBagConstraints(1,11,1,1,0,
                0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(fizAdress, new GridBagConstraints(2,11,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(innLabel, new GridBagConstraints(3,11,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(inn, new GridBagConstraints(4,11,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(kppLabel, new GridBagConstraints(1,12,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(kpp, new GridBagConstraints(2,12,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(bankLabel, new GridBagConstraints(3,12,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(bank, new GridBagConstraints(4,12,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(rsLabel, new GridBagConstraints(1,13,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(rs, new GridBagConstraints(2,13,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(ksLabel, new GridBagConstraints(3,13,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(ks, new GridBagConstraints(4,13,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );
        mainpanel.add(bikLabel, new GridBagConstraints(1,14,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,2), 0,0)
        );
        mainpanel.add(bik, new GridBagConstraints(2,14,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,20), 0,0)
        );

        //КНОПКИ
        mainpanel.add(btnOk, new GridBagConstraints(5,15,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 0,0)
        );
        mainpanel.add(btnCancel, new GridBagConstraints(6,15,1,1,0,0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(20,10,0,0), 0,0)
        );

        btnOk.addActionListener(new btnOk());
        btnCancel.addActionListener(new btnCancel());

         JScrollPane scroll = new JScrollPane(mainpanel,
                 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        frame.setVisible(true);
        frame.pack();
        }
        /**
         * Создаем слушатель для кнопки "Ок".
         * По нажатию на кнопку в класс btn Ok передаются данные их TextField и записываются в переменные
         * Формирование имени документа:
         * Значение переменной полученной в поле dName записывается в  переменную dogname
         * с подстановкой расширения документа (.docx)
         *
         */
    static class btnOk  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String dName = docName.getText();
            String dogname = dName + ".docx";
            String dNum = dogNum.getText();
            String dateS = dateStart.getText();
            String dateE = dateEnd.getText();
            String uName = urName.getText();
            String arFio = arendatorFio.getText();
            String arFioP = arendatorFioP.getText();

            /**
             * Запись в переменные address и bti зависит от выбранной JRadioButton.
             * В зависимости от выбранного объекта изменяетя адрес и выписка из БТИ о праве собственности
             */
            boolean rb1 = radioAdress1.isSelected();
            boolean rb2 = radioAdress2.isSelected();
            if (rb1 == true) {
                address = "Такая-то улица, д.8, корп.2, стр. 1 ";
                bti = "от «11 декабря 2011» г., номер записи о регистрации 11-АН-111111";
            }else if (rb2 == true) {
                address = "Такая-то улица, д.8, корп.2, стр. 2 ";
                bti = "от «13 апреля 2011» г., номер записи о регистрации 22-АН 222222";
            }

            //проверка поля ввода комнаты.
            roomN = roomNum.getText();
            if (roomN.length()<=0) {
            }else {
                roomN = "ком." + roomN;
            }

            String roomSp = roomSpace.getText();
            String roomU = roomUsage.getText();
            String prise = price.getText();
            String priseNds = priceNds.getText();
            String uAdress = urAdress.getText();
            String fAdress = fizAdress.getText();
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
            new worddoc(dogname, dNum , dateS, dateE, uName, arFio, arFioP, address, bti, roomN, roomSp,
                    roomU, prise, priseNds, uAdress, fAdress, rInn, rKpp, rBank, rRs, rKs,rBik);

            System.exit(0);
        }
    }

    static class btnCancel  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }
    /**
     * Класс получает на вход переменные из обработчика кнопки "OK".
     * Документ формируется путем заранее созданной формы и подстановкой переменных в отведенные для них места.
     * Документ разбит на части - Заголовки (zag) и Текст (text) по пунктам. Их 8 включая реквизиты.
     * После 8-го пункта формируется Акт-приемки.
     */
    static class worddoc {
        public worddoc(String dogname, String dNum , String dateS, String dateE, String uName, String arFio,
        String arFioP, String address, String bti, String roomN, String roomSp,
                    String roomU, String prise, String priseNds, String uAdress, String fAdress, String rInn,
                    String rKpp, String rBank, String rRs, String rKs,String rBik) {

            //Создание тела документа
            XWPFDocument doc = new XWPFDocument();

            XWPFParagraph zagolovok = doc.createParagraph();
            XWPFRun zag = zagolovok.createRun();

            zag.setText("Договор № " + dNum);
            zag.addBreak();
            zag.setText("аренды нежилого помещения");
            zag.addBreak();
            zag.setText("г. Москва                                                                        " +
                    "                       " + dateS);
            zag.addBreak();
            zag.setFontSize(10);
            zag.setFontFamily("Times New Roman");
            zag.setBold(true);
            zagolovok.setAlignment(ParagraphAlignment.CENTER);

            XWPFParagraph text = doc.createParagraph();
            XWPFRun tex = text.createRun();

            tex.setText("ЗАО «Рога и Копыта», именуемое в дальнейшем «Арендодатель», в лице " +
                    "Генерального директора Иванова В.В.," +
                    " действующего на основании Устава, с одной стороны, и " + uName + ", именуемое в" +
                    " дальнейшем «Арендатор»," +
                    " в лице  Генерального директора " + arFioP + " , действующего на основании Устава," +
                    " с другой стороны, вместе именуемые «Стороны», " +
                    "заключили настоящий Договор о нижеследующем:");
            tex.setFontSize(10);
            tex.setFontFamily("Times New Roman");
            text.setAlignment(ParagraphAlignment.BOTH);
            text.setIndentationFirstLine(500);
            text.setSpacingAfter(200);

            XWPFParagraph zagolovok1 = doc.createParagraph();
            XWPFRun zag1 = zagolovok1.createRun();

            zag1.setText("1.  Предмет договора");
            zag1.setFontSize(10);
            zag1.setFontFamily("Times New Roman");
            zag1.setBold(true);
            zagolovok1.setSpacingAfter(0);

            XWPFParagraph text1 = doc.createParagraph();
            XWPFRun tex1 = text1.createRun();

            tex1.setText("1.1.  Арендодатель передаёт в аренду нежилое помещение, далее - Помещение, расположенное" +
                    " по адресу: 109111, Российская Федерация, Москва, " + address + roomN +
                    " общей площадью " + roomSp + " кв.м., а Арендатор обязуется принять Помещение и использовать " +
                    "Помещение по целевому назначению, предусмотренному настоящим Договором.");
            tex1.addBreak();
            tex1.setText("1.2.  Помещение передается Арендатору для использования его под " + roomU + ".");
            tex1.addBreak();
            tex1.setText("1.3.  Помещение передается Арендатору в течение 3 (трёх) дней со дня подписания настоящего " +
                    "Договора по Акту приема - передачи, являющемся неотъемлемой частью настоящего Договора, в котором " +
                    "указывается техническое состояние Помещения (Приложение № 1).");
            tex1.addBreak();
            tex1.setText("1.4.  Помещение принадлежат Арендодателю на праве собственности, что подтверждается " +
                    "Свидетельством о государственной регистрации права собственности, выданным Учреждением юстиции   по  " +
                    " регистрации   прав   на   недвижимое   имущество   и   сделок   с   ним   " + bti + ". Расположение" +
                    " и площадь Помещений определены в соответствии" +
                    " с данными БТИ г. Москвы и приведены в Приложении № 2 к настоящему Договору. Границы и расположение" +
                    " арендуемых помещений обозначены цветом. ");
            tex1.addBreak();
            tex1.setText("1.5.  Реорганизация Арендодателя, а также перемена собственника Помещения не являются " +
                    "основанием для изменения или расторжения настоящего Договора.");
            tex1.setFontSize(10);
            tex1.setFontFamily("Times New Roman");
            text1.setSpacingAfter(200);
            text1.setAlignment(ParagraphAlignment.NUM_TAB);

            XWPFParagraph zagolovok2 = doc.createParagraph();
            XWPFRun zag2 = zagolovok2.createRun();

            zag2.setText("2.  Права и обязанности Сторон");
            zag2.setFontSize(10);
            zag2.setFontFamily("Times New Roman");
            zag2.setBold(true);
            zagolovok2.setSpacingAfter(0);

            XWPFParagraph text2 = doc.createParagraph();
            XWPFRun tex2 = text2.createRun();

            tex2.setText("2.1.1.  Обязанности Арендодателя:");
            tex2.addBreak();
            tex2.setText("2.1.2.  Своевременно передать Арендатору Помещение в состоянии пригодном для использования\n" +
                    "по назначению;");
            tex2.addBreak();
            tex2.setText("2.1.3.  Оказывать услуги, позволяющие создать условия для эффективной  деятельности, " +
                    "а именно:");
            tex2.addBreak();
            tex2.setText("•         Обеспечивать электроэнергией, водоснабжением, отоплением, канализацией;");
            tex2.addBreak();
            tex2.setText("•         Нести расходы по содержанию Помещения, осуществлять уход за территорией предприятия," +
                    " организовывать уборку и вывоз мусора, снега и льда с территории комплекса, в котором находится Помещение (далее- Комплекс);");
            tex2.addBreak();
            tex2.setText("•         Осуществлять охрану Помещения по окончании рабочего дня Арендатора;");
            tex2.addBreak();
            tex2.setText("2.1.4.  Обеспечивать беспрепятственный доступ в Помещения сотрудникам.\n" +
                    "Арендатора.\n");
            tex2.addBreak();
            tex2.setText("2.1.5.  Беспрепятственно входить в Помещение в любое время суток при возникновении аварийных " +
                    "ситуаций, пожара, с немедленным уведомлением Арендатора; в течение рабочего дня Арендатора при его" +
                    "предварительном извещении и в его присутствии для осуществления контроля за целевым использованием" +
                    " Помещения, проверки их технического состояния, присутствовать при проведении проверок у Арендатора " +
                    "контролирующими органами. По\n" +
                    "результатам проверок Арендодатель выносит решения, зафиксированные а Акте, обязательные " +
                    "для исполнения Арендатором.\n");
            tex2.addBreak();
            tex2.setText("2.2.  Обязанности Арендатора");
            tex2.addBreak();
            tex2.setText("2.2.1.  Принять Помещение по Акту приема-передачи в срок, указанный " +
                    "в п. 1.3 настоящего Договора.");
            tex2.addBreak();
            tex2.setText("2.2.2.  Своевременно и в полном объеме вносить арендную плату согласно условиям " +
                    "настоящего Договора.");
            tex2.addBreak();
            tex2.setText("2.2.3.  При прекращении настоящего Договора вернуть Арендодателю Помещение по Акту " +
                    "в том же состоянии; в каком он его получил с учетом нормального износа, а также улучшения," +
                    " составляющие принадлежность Помещения и неотделимые без вреда для конструкции. Арендатор" +
                    " оплачивает платежи, предусмотренные Договором, за период до даты фактического возврата Помещения. " +
                    "В случае задержки возврата Помещения Арендатор выплачивает штраф в размере 0,1 % от месячной" +
                    " арендной платы за каждый день просрочки. При повреждении Помещения Арендатор обязан в течение 5 " +
                    "(пяти) дней возместить стоимость повреждений по рыночной цене, действующей на момент прекращения" +
                    " действия Договора.");
            tex2.addBreak();
            tex2.setText("2.2.4.  Обеспечивать соблюдение правил техники безопасности в арендованном Помещении," +
                    " соблюдать правила по повышению уровня антитеррористической безопасности на территории Комплекса " +
                    "согласно Рекомендациям Правительства г. Москвы, иметь в наличии средства индивидуальной защиты " +
                    "и обеспечить выполнение требований по Г.О.");
            tex2.addBreak();
            tex2.setText("2.2.5.  Не приносить и не хранить в Помещении и на прилегающей территории взрывоопасные," +
                    " ядовитые, радиоактивные, биологические и легковоспламеняющиеся вещества.");
            tex2.setText("2.2.6.  Содержать Помещение и имущество Арендодателя в технически исправном состоянии с " +
                    "соблюдением санитарных и противопожарных правил в Помещении и прилагающей к нему территории, " +
                    "самостоятельно и за свой счет устранять выявленные нарушения обязательств, допущенные" +
                    " по вине Арендатора, согласовать и соблюдать режим, внутренние правила работы Комплекса, правила " +
                    "сдачи Помещения под охрану, а также общественный порядок в Комплексе, обеспечивать " +
                    "уборку Помещения. Соблюдать порядок на территории, прилагающей к Помещению;");
            tex2.addBreak();
            tex2.setText("         - проводить инструктаж своих работников по охране труда, технике безопасности, " +
                    "противопожарной и электробезопасности и обеспечить соблюдение работниками указанных требований" +
                    " действующего законодательства РФ;");
            tex2.addBreak();
            tex2.setText("         - содержать Помещения в соответствии с требованиями пожарной безопасности, " +
                    "соблюдать правила Пожарной безопасности в Российской Федерации ( утвержденные Постановлением" +
                    " Правительства от 25.04.2012 года № 390) и другие пожарные нормы и правила, в том числе обеспечить" +
                    " безопасность людей при пожаре, иметь Инструкцию о мерах пожарной безопасности в арендуемых" +
                    " помещениях и первичные средства пожаротушения (огнетушители и т.д.), обеспечить противопожарную " +
                    "безопасность Помещений. Персональную ответственность за пожарную безопасность арендуемых помещений" +
                    " несут руководители ( назначенные ими представители) Арендатора. Соблюдение положений данного" +
                    " абзаца является существенным условием Договора.");
            tex2.addBreak();
            tex2.setText("         - возместить материальный ущерб Арендодателю в полном объеме в случае пожара" +
                    "или аварии, возникших по вине Арендатора или восстановить Помещения собственными силами " +
                    "и средствами в согласованные с Арендодателем сроки.");
            tex2.addBreak();
            tex2.setText("2.2.7.  Немедленно извещать Арендодателя о всяком повреждении, аварии или ином событии," +
                    " причиняющим или способным причинять ущерб Комплексу или Помещению, а также незамедлительно" +
                    " принять все необходимые меры к устранению повреждений или аварий, а также обеспечить допуск " +
                    "в Помещение представителей Арендодателя или соответствующих служб с целью, " +
                    "устранения неисправностей, аварий и их последствий в любое время. В случае аварий внутренних," +
                    " тепло-, энерго- других сетей по вине Арендатора принимать все необходимые меры к устранению" +
                    " аварий и их последствий за свой счет.");
            tex2.addBreak();
            tex2.setText("2.2.8.  В установленные Договором сроки вносить арендную плату на расчетный счет\n" +
                    "Арендодателя, указанный в настоящем Договоре.\n");
            tex2.addBreak();
            tex2.setText("2.2.9.  Начать использовать Помещение по целевому назначению не позднее 15 (пятнадцати) дней\n" +
                    "со дня приема его по Акту приема-передачи.\n");
            tex2.addBreak();
            tex2.setText("2.2.10.  Осуществлять коммерческую деятельность в Комплексе в соответствии с" +
                    " действующим законодательством РФ.");
            tex2.addBreak();
            tex2.setText("2.2.11.  По первому требованию предоставлять Арендодателю документы по его запросу.");
            tex2.addBreak();
            tex2.setText("2.2.12.  При проведении проверок контролирующими органами Арендатора немедленно извещать " +
                    "Арендодателя об этом. ");
            tex2.addBreak();
            tex2.setText("2.2.13.  В течение рабочего дня Арендатор самостоятельно несет ответственность за сохранность " +
                    "принадлежащего ему имущества. Арендатор по согласованию с Арендодателем вправе дополнительно" +
                    " организовать в Помещении охрану силами лицензированного ЧОП.");
            tex2.addBreak();
            tex2.setText("2.2.1.4. Не производить реконструкцию Помещения, перепланировку, переоборудование и другие " +
                    "капитальные ремонтные работы без письменного согласия Арендодателя. Неотделимые улучшения " +
                    "производить только с письменного разрешения Арендодателя.");
            tex2.addBreak();
            tex2.setText("2.2.15. Арендатор несет материальную ответственность в соответствии с законодательством РФ " +
                    "при привлечении к работам лиц, не имеющих выданного в установленном порядке компетентным" +
                    " органом РФ разрешения на работу.");
            tex2.addBreak();
            tex2.addBreak();
            tex2.setFontSize(10);
            tex2.setFontFamily("Times New Roman");
            text2.setSpacingAfter(200);
            text2.setAlignment(ParagraphAlignment.NUM_TAB);

            XWPFParagraph zagolovok3 = doc.createParagraph();
            XWPFRun zag3 = zagolovok3.createRun();
            zag3.addBreak();
            zag3.setText("3.  Порядок расчетов");
            zag3.setFontSize(10);
            zag3.setFontFamily("Times New Roman");
            zag3.setBold(true);
            zagolovok3.setSpacingAfter(0);

            XWPFParagraph text3 = doc.createParagraph();
            XWPFRun tex3 = text3.createRun();
            tex3.setText("3.1.  Арендная плата составляет " + prise + ", включая НДС 18% - " + priseNds);
            tex3.addBreak();
            tex3.setText("3.2.  Арендатор перечисляет арендную плату и другие платежи за первый месяц аренды в" +
                    " течение 5 (пяти) дней с момента подписания Акта приема-передачи Помещения.");
            tex3.addBreak();
            tex3.setText("3.3.  В дальнейшем Арендатор перечисляет арендную плату ежемесячно не позднее 5-ого" +
                    " числа текущего месяца на расчетный счет Арендодателя, в строгом соответствии с реквизитами, указанными в настоящем Договоре. Любой платеж по настоящему Договору считается произведенным с даты поступления денежных средств на расчетный счет Арендодателя.");
            tex3.addBreak();
            tex3.setText("3.4.  Арендная плата включает в себя плату за пользование Помещением, " +
                    "эксплуатационно-коммунальные платежи, вывоз мусора, уборка снега и льда и другие расходы по содержанию Комплекса.");
            tex3.addBreak();
            tex3.setText("3.5.  Размер арендной платы может быть изменен Арендодателем только в случае изменения" +
                    " тарифов и цен на коммунальные и эксплуатационные услуги. Арендатор извещается об этом в" +
                    " письменном виде не позднее, чем за 30 (Тридцать) дней до введения таких изменений. В случае" +
                    " несогласия Арендатора с изменением арендной платы, Арендодатель вправе досрочно расторгнуть" +
                    " настоящий Договор по истечении вышеуказанного срока предупреждения");
            tex3.addBreak();
            tex3.setFontSize(10);
            tex3.setFontFamily("Times New Roman");
            text3.setSpacingAfter(100);
            text3.setAlignment(ParagraphAlignment.NUM_TAB);

            XWPFParagraph zagolovok4 = doc.createParagraph();
            XWPFRun zag4 = zagolovok4.createRun();

            zag4.setText("4.  Ответственность сторон");
            zag4.setFontSize(10);
            zag4.setFontFamily("Times New Roman");
            zag4.setBold(true);
            zagolovok4.setSpacingAfter(0);

            XWPFParagraph text4 = doc.createParagraph();
            XWPFRun tex4 = text4.createRun();
            tex4.setText("4.1.  За неуплату платежей в сроки, установленные п. 3.2., п. 3.3. настоящего Договора," +
                    " Арендатору начисляется пени в размере 0,1 % от суммы неуплаты за каждый день просрочки. " +
                    "Выплата пени не освобождает Арендатора от выполнения его основного обязательства.");
            tex4.addBreak();
            tex4.setText("4.2.  В случае причинения ущерба Помещению, Комплексу или третьим лицам в результате действий" +
                    " Арендатора или непринятия им необходимых мер для его предотвращения, Арендатор устраняет ущерб " +
                    "своими силами и за свой счет, или возмещает причиненный ущерб Арендодателю и/или третьим лицам " +
                    "в полном объеме в течение 5 (пяти) дней с момента выставления претензии.");
            tex4.addBreak();
            tex4.setText("4.3.  Арендодатель не несет ответственности за отсутствие у Арендатора разрешительной " +
                    "документации на занятие деятельностью, указанной в п. 1.3.Настоящего Договора.");
            tex4.addBreak();
            tex4.setText("4.4.  В случае отсутствия Арендатора в арендуемом Помещении без уведомления Арендодателя " +
                    "в течение 5 (пяти) дней и уклонения от уплаты арендной платы, Арендодатель имеет право " +
                    "с представителями нейтральной стороны вскрыть Помещение, провести снятие " +
                    "остатков товарно-материальных ценностей с составлением акта, и зачесть часть стоимости " +
                    "товарно-материальных ценностей в качестве компенсации задолженности Арендатора перед Арендодателем," +
                    " оставшуюся часть товарно-материальных ценностей вернуть Арендатору. ");
            tex4.addBreak();
            tex4.setText("4.5.  Арендодатель не несет ответственности за перебои в обеспечении круглосуточной работы" +
                    " в Помещении систем центрального отопления, электроснабжения, холодного и горячего водоснабжения, " +
                    "канализации, происшедших по вине организаций, обеспечивающих поддержание и эксплуатацию систем" +
                    " жизнеобеспечения Помещения.");
            tex4.addBreak();
            tex4.setText("4.6.  Споры и разногласия между Сторонами по настоящему Договору разрешаются путем переговоров" +
                    " в течение 15 (пятнадцати) дней. В случае не достижения согласия спор подлежит рассмотрению в " +
                    "Арбитражном суде г. Москвы в установленном законодательством порядке.");
            tex4.addBreak();
            tex4.setFontSize(10);
            tex4.setFontFamily("Times New Roman");
            text4.setSpacingAfter(100);
            text4.setAlignment(ParagraphAlignment.NUM_TAB);

            XWPFParagraph zagolovok5 = doc.createParagraph();
            XWPFRun zag5 = zagolovok5.createRun();

            zag5.setText("5.  Срок действия, порядок изменения и расторжения договора");
            zag5.setFontSize(10);
            zag5.setFontFamily("Times New Roman");
            zag5.setBold(true);
            zagolovok5.setSpacingAfter(0);

            XWPFParagraph text5 = doc.createParagraph();
            XWPFRun tex5 = text5.createRun();
            tex5.setText("5.1.  Помещение сдается в аренду с " + dateS + " по "+ dateE +" включительно и действует" +
                    " в течение указанного срока, при условии исполнения Сторонами всех принятых на себя обязательств " +
                    "по настоящему Договору. Если ни одна из сторон не позднее, чем за 30 (тридцать) календарных дней " +
                    "до истечения срока действия настоящего договора не заявит о своем желании его прекратить," +
                    " последний считается автоматически продленным на срок 11 (одиннадцать) месяцев, на условиях " +
                    "предусмотренных настоящим договором. Количество продлений настоящего договора не ограничено.");
            tex5.addBreak();
            tex5.setText("5.2.  Изменение условий настоящего Договора, его расторжение и прекращение допускаются " +
                    "по соглашению Сторон. Вносимые дополнения и изменения рассматриваются Сторонами в месячный срок" +
                    " и оформляются дополнительным соглашением, подписываемым Сторонами.");
            tex5.addBreak();
            tex5.setText("5.3.  Договор подлежит досрочному расторжению по требованию Арендодателя," +
                    " а Арендатор принудительному выселению в следующих случаях:");
            tex5.addBreak();
            tex5.setText("5.3.1.  При использовании Арендатором Помещения не в соответствии с его целевым назначением," +
                    " установленным в п. 1.2. настоящего Договора, в течение 1 (одного) месяца;");
            tex5.addBreak();
            tex5.setText("5.3.2.  Если Арендатор умышленно ухудшает состояние Помещения;");
            tex5.addBreak();
            tex5.setText("5.3.3.  Если Арендатор не вносит арендную плату по истечении установленного Договором " +
                    "срока платежа свыше 20 (двадцати) дней;");
            tex5.addBreak();
            tex5.setText("5.3.4.  Если Арендатор систематически (два или более раз) нарушает установленные Договором " +
                    "сроки внесения арендной платы;");
            tex5.addBreak();
            tex5.setText("5.3.5.  Ликвидации Арендатора как юридического лица;");
            tex5.addBreak();
            tex5.setText("5.3.6.  В случае препятствия проведения проверок, предусмотренных п.п. 2.1.5. настоящего " +
                    "Договора, неисполнения в срок решений, вынесенных по результатам проверок, а также неоднократного " +
                    "несоблюдения режима работы Комплекса;");
            tex5.addBreak();
            tex5.setText("5.3.7.  В случае систематического (два и более раз) нарушения Арендатором обязательств " +
                    "по настоящему Договору, которые должны быть зафиксированы протоколом в присутствии" +
                    " нейтральной стороны.");
            tex5.addBreak();
            tex5.setText("5.4.  Арендодатель реализует свое право на одностороннее расторжение настоящего Договора " +
                    "согласно вышеуказанным положениям только после предоставления Арендатору права на устранение" +
                    " выявленных нарушений. Арендодатель письменно уведомляет Арендатора о выявленном нарушении " +
                    "и устанавливает разумный срок для его устранения.");
            tex5.addBreak();
            tex5.setText("Арендодатель имеет право расторгнуть настоящий Договор в одностороннем порядке в случае " +
                    "принятия решения реконструкции Помещения или самостоятельном его пользовании.");
            tex5.addBreak();
            tex5.setText("5.5.  Договор подлежит досрочному расторжению по требованию Арендатора:");
            tex5.addBreak();
            tex5.setText("5.6.1.  Если Помещение в силу обстоятельств, за которые Арендатор не отвечает, " +
                    "окажется в состоянии непригодном для использования;");
            tex5.addBreak();
            tex5.setText("5.6.2.  В случае несогласии с изменением арендной платы.");
            tex5.addBreak();
            tex5.setText("5.7.  Договор, может быть, расторгнут по соглашению Сторон.");
            tex5.addBreak();
            tex5.setText("5.8.  Сторона, по требованию которой досрочно расторгается настоящий Договор, обязана\n" +
                    "письменно уведомить другую Сторону за 4 (четыре) недели до даты расторжения Договора.\n" +
                    "Арендатор по истечении этого срока в течение З(трех) дней обязан сдать Помещение по Акту\n" +
                    "приема-передачи в исправном состоянии, с учетом нормального износа.\n");
            tex5.addBreak();
            tex5.setFontSize(10);
            tex5.setFontFamily("Times New Roman");
            text5.setSpacingAfter(100);
            text5.setAlignment(ParagraphAlignment.NUM_TAB);

            XWPFParagraph zagolovok6 = doc.createParagraph();
            XWPFRun zag6 = zagolovok6.createRun();

            zag6.setText("6.  Особые условия");
            zag6.setFontSize(10);
            zag6.setFontFamily("Times New Roman");
            zag6.setBold(true);
            zagolovok6.setSpacingAfter(0);

            XWPFParagraph text6 = doc.createParagraph();
            XWPFRun tex6 = text6.createRun();
            tex6.setText("6.1. Если Договор подлежит досрочному расторжению, а Арендатор - выселению, " +
                    "согласно п. 5.4. настоящего Договора, то Арендодатель, после письменного уведомления " +
                    "Арендатора вправе:");
            tex6.addBreak();
            tex6.setText("•         Удерживать .имущество Арендатора в качестве обеспечения выполнения " +
                    "последним обязательств по настоящему Договору;");
            tex6.addBreak();
            tex6.setText("•         Прекратить предоставление Арендатору возможности пользования электросетью и т.д.");
            tex6.addBreak();
            tex6.setText("•         Прекратить допуск в Помещение сотрудников Арендатора.");
            tex6.addBreak();
            tex6.setFontSize(10);
            tex6.setFontFamily("Times New Roman");
            text6.setSpacingAfter(100);
            text6.setAlignment(ParagraphAlignment.NUM_TAB);

            XWPFParagraph zagolovok7 = doc.createParagraph();
            XWPFRun zag7 = zagolovok7.createRun();

            zag7.setText("7.  Заключительные положения");
            zag7.setFontSize(10);
            zag7.setFontFamily("Times New Roman");
            zag7.setBold(true);
            zagolovok7.setSpacingAfter(0);

            XWPFParagraph text7 = doc.createParagraph();
            XWPFRun tex7 = text7.createRun();
            tex7.setText("7.1.  Условия  настоящего  Договора Сторонами  определены как конфиденциальные " +
                    "и не в нежащие разглашению;");
            tex7.addBreak();
            tex7.setText("7.2.  В случаях, не урегулированных настоящим Договором," +
                    " применяется гражданское законодательство РФ;");
            tex7.addBreak();
            tex7.setText("7.3.  Стороны обязаны в течение 5 (пяти) календарных дней информировать друг друга об\n" +
                    "изменении организационно-правовой форм, наименования, адреса местонахождения, банковских\n" +
                    "реквизитах, о предстоящей реорганизации или ликвидации;\n");
            tex7.addBreak();
            tex7.setText("7.4.  Стороны обязуются рассматривать полученные друг от друга документы и письма и давать на " +
                    "них ответ в течение 72(семидесяти двух) часов с момента их получения;");
            tex7.addBreak();
            tex7.setText("7.5.  Настоящий Договор составлен в двух экземплярах, имеющих равную юридическую силу, по" +
                    " одному экземпляру для каждой из сторон.");
            tex7.addBreak();
            tex7.setFontSize(10);
            tex7.setFontFamily("Times New Roman");
            text7.setSpacingAfter(100);
            text7.setAlignment(ParagraphAlignment.NUM_TAB);

            XWPFParagraph zagolovok8 = doc.createParagraph();
            zagolovok8.setPageBreak(true);
            XWPFRun zag8 = zagolovok8.createRun();

            zag8.setText("8. РЕКВИЗИТЫ И ПОДПИСИ СТОРОН");
            zag8.setFontSize(10);
            zag8.setFontFamily("Times New Roman");
            zag8.setBold(true);
            zagolovok8.setSpacingAfter(100);
            zagolovok8.setAlignment(ParagraphAlignment.CENTER);

            //Создаем таблицу
            XWPFTable table = doc.createTable();

            XWPFTableRow row0 = table.getRow(0);

            XWPFTableCell cell0 = row0.getCell(0);
            XWPFParagraph tab8text1 = cell0.addParagraph();
            XWPFRun text81 = tab8text1.createRun();
            text81.setText("Арендодатель");
            text81.setFontSize(10);
            text81.setFontFamily("Times New Roman");
            text81.setBold(true);
            tab8text1.setSpacingAfter(100);
            tab8text1.setAlignment(ParagraphAlignment.CENTER);

            XWPFTableCell cell1 = row0.createCell();
            XWPFParagraph tab8text2 = cell1.addParagraph();
            XWPFRun text82 = tab8text2.createRun();
            text82.setText("Арендатор");
            text82.setFontSize(10);
            text82.setFontFamily("Times New Roman");
            text82.setBold(true);
            tab8text2.setSpacingAfter(100);
            tab8text2.setAlignment(ParagraphAlignment.CENTER);

            XWPFTableRow row1 = table.createRow();

            //Область для реквизитов Арендодателя
            XWPFTableCell cell2 = row1.getCell(0);
            XWPFParagraph tab8text3 = cell2.addParagraph();
            XWPFRun text83 = tab8text3.createRun();
            text83.setText("ЗАО Рога и Копыта");
            text83.addBreak();
            text83.setText("Юр. Адрес 109111, г. Москва, ул.Такая-то, д. 8, корпус 2");
            text83.addBreak();
            text83.setText("Фактический адрес: 109111, г. Москва, ул.Такая-то, д.8, корпус 2 ");
            text83.addBreak();
            text83.setText("ИНН 77217777777");
            text83.addBreak();
            text83.setText("КПП 7727777777");
            text83.addBreak();
            text83.setText("Банковские реквизиты: ВТБ 24 (ЗАО) г. Москва");
            text83.addBreak();
            text83.setText("р/с 40702777777777776099");
            text83.addBreak();
            text83.setText("к/с 30177777777777777716");
            text83.addBreak();
            text83.setText("БИК 077777777");
            text83.addBreak();
            text83.setFontSize(10);
            text83.setFontFamily("Times New Roman");
            text83.setBold(true);
            tab8text3.setSpacingAfter(100);
            tab8text3.setAlignment(ParagraphAlignment.LEFT);

            //Область для реквизитов Аредатора
            XWPFTableCell cell3 = row1.getCell(1);
            XWPFParagraph tab8text4 = cell3.addParagraph();
            XWPFRun text84 = tab8text4.createRun();
            text84.setText(uName);
            text84.addBreak();
            text84.setText("Юр. Адрес: " + uAdress);
            text84.addBreak();
            text84.setText("Фактический адрес: "+fAdress);
            text84.addBreak();
            text84.setText("ИНН "+rInn);
            text84.addBreak();
            text84.setText("КПП "+rKpp);
            text84.addBreak();
            text84.setText("Банковские реквизиты: ");
            text84.addBreak();
            text84.setText(rBank);
            text84.addBreak();
            text84.setText("р/с "+rRs);
            text84.addBreak();
            text84.setText("к/с "+rKs);
            text84.addBreak();
            text84.setText("БИК "+rBik);
            text84.addBreak();
            text84.setFontSize(10);
            text84.setFontFamily("Times New Roman");
            text84.setBold(true);
            tab8text4.setSpacingAfter(100);
            tab8text4.setAlignment(ParagraphAlignment.LEFT);

            XWPFTableRow row2 = table.createRow();

            //Область для подписи Арендотателя
            XWPFTableCell cell4 = row2.getCell(0);
            XWPFParagraph tab8text5 = cell4.addParagraph();
            XWPFRun text85 = tab8text5.createRun();
            text85.setText("За Арендодателя");
            text85.addBreak();
            text85.addBreak();
            text85.setText("______________(Иванов В.В.)");
            text85.addBreak();
            text85.addBreak();
            text85.setText("____  _________2017 г.");
            text85.setFontSize(10);
            text85.setFontFamily("Times New Roman");
            text85.setBold(true);
            tab8text5.setSpacingAfter(100);
            tab8text5.setAlignment(ParagraphAlignment.LEFT);

            //Область для подписи Арендатора
            XWPFTableCell cell5 = row2.getCell(1);
            XWPFParagraph tab8text6 = cell5.addParagraph();
            XWPFRun text86 = tab8text6.createRun();
            text86.setText("За Арендатора");
            text86.addBreak();
            text86.addBreak();
            text86.setText("______________(" + arFio + ")");
            text86.addBreak();
            text86.addBreak();
            text86.setText("____  _________2017 г.");
            text86.setFontSize(10);
            text86.setFontFamily("Times New Roman");
            text86.setBold(true);
            tab8text6.setSpacingAfter(100);
            tab8text6.setAlignment(ParagraphAlignment.LEFT);

            // Создание листа приложения
            XWPFParagraph prilozenie = doc.createParagraph();
            prilozenie.setPageBreak(true);
            XWPFRun pril = prilozenie.createRun();

            pril.setText("Приложение №1");
            pril.addBreak();
            pril.setText("к договору аренды № " + dNum + " от " + dateS);
            pril.setFontSize(10);
            pril.setFontFamily("Times New Roman");
            pril.setBold(true);
            prilozenie.setSpacingAfter(200);
            prilozenie.setAlignment(ParagraphAlignment.RIGHT);

            XWPFParagraph prilzagolovok = doc.createParagraph();
            XWPFRun prilzag = prilzagolovok.createRun();

            prilzag.setText("АКТ ПРИЕМА-ПЕРЕДАЧИ");
            prilzag.addBreak();
            prilzag.setText("в аренду нежилого помещения, расположенного по адресу 109111, Москва, " + address);
            prilzag.addBreak();
            prilzag.addBreak();
            prilzag.setText("г. Москва                                " +
                    "                                                                               " + dateS);
            prilzag.addBreak();
            prilzag.setFontSize(10);
            prilzag.setFontFamily("Times New Roman");
            prilzag.setBold(true);
            prilzagolovok.setAlignment(ParagraphAlignment.CENTER);


            XWPFParagraph priltext = doc.createParagraph();
            XWPFRun ptext = priltext.createRun();

            ptext.setText("ЗАО «Рога и Копыта», именуемое в дальнейшем «Арендодатель», в лице " +
                    "Генерального директора Иванов В.В.," +
                    " действующего на основании Устава, с одной стороны, и " + uName + ", именуемое в" +
                    " дальнейшем «Арендатор»," +
                    " в лице  Генерального директора " + arFioP + " , действующего на основании Устава," +
                    " с другой стороны, вместе именуемые «Стороны», " +
                    "заключили настоящий Акт о нижеследующем:");
            ptext.setFontSize(10);
            ptext.setFontFamily("Times New Roman");
            priltext.setAlignment(ParagraphAlignment.BOTH);
            priltext.setIndentationFirstLine(500);
            priltext.setSpacingAfter(200);

            XWPFParagraph priltext2 = doc.createParagraph();
            XWPFRun ptext2 = priltext2.createRun();

            ptext2.setText("1. Арендодатель передает, а Арендатор принимает в аренду в соответствии с условиями\n" +
                    "Договора аренды нежилого помещения №" + dNum + " от " + dateS + " Помещение, общей площадью " +
                    roomSp + " кв.м., " +
                    "расположенное в здании по адресу: Москва, " + address + roomN + ".");
            ptext2.addBreak();
            ptext2.setText("2.\tТехническое состояние Помещения на момент подписания Акта приемки-передачи позволяет " +
                    "использовать его в целях, предусмотренных п. 1.2 указанного договора аренды.");
            ptext2.addBreak();
            ptext2.setText("3.\tТехнические характеристики помещения соответствуют требованиям Арендатора.");
            ptext2.addBreak();
            ptext2.setText("4.\tАрендная плата за пользование вышеуказанным Помещением взимается со дня\n" +
                    "подписания настоящего Акта.\n");
            ptext2.addBreak();
            ptext2.setText("5.\tНастоящий Акт составлен в 2 (Двух) подлинных экземплярах, имеющих одинаковую\n" +
                    " юридическую силу, по одному экземпляру для каждой из Сторон.\n");
            ptext2.addBreak();
            ptext2.setFontSize(10);
            ptext2.setFontFamily("Times New Roman");
            priltext2.setAlignment(ParagraphAlignment.BOTH);
            //priltext2.setIndentationFirstLine(500);
            priltext2.setSpacingAfter(500);

            XWPFParagraph priltext3 = doc.createParagraph();
            XWPFRun ptext3 = priltext3.createRun();

            ptext3.setText("ПОДПИСИ СТОРОН");
            ptext3.addBreak();
            ptext3.setFontSize(10);
            ptext3.setFontFamily("Times New Roman");
            priltext3.setAlignment(ParagraphAlignment.CENTER);
            priltext3.setIndentationFirstLine(500);
            priltext3.setSpacingAfter(200);

            XWPFParagraph priltext4 = doc.createParagraph();
            XWPFRun ptext4 = priltext4.createRun();

            ptext4.setText("Арендодатель:                                               " +
                    "                                         Арендатор:");
            ptext4.addBreak();
            ptext4.setFontSize(10);
            ptext4.setFontFamily("Times New Roman");
            ptext4.setBold(true);
            priltext4.setAlignment(ParagraphAlignment.CENTER);
            priltext4.setIndentationFirstLine(200);
            priltext4.setSpacingAfter(200);

            XWPFParagraph priltext5 = doc.createParagraph();
            XWPFRun ptext5 = priltext5.createRun();

            ptext5.setText("Генеральный директор:                                                                   " +
                    "                     Генеральный директор:");
            ptext5.addBreak();
            ptext5.setFontSize(10);
            ptext5.setFontFamily("Times New Roman");
            priltext5.setAlignment(ParagraphAlignment.CENTER);
            priltext5.setIndentationFirstLine(500);
            priltext5.setSpacingAfter(200);

            XWPFParagraph priltext6 = doc.createParagraph();
            XWPFRun ptext6 = priltext6.createRun();

            ptext6.setText("_______________Иванов В.В.                                                  " +
                    "                     _________________" + arFio);
            ptext6.addBreak();
            ptext6.setFontSize(10);
            ptext6.setFontFamily("Times New Roman");
            priltext5.setAlignment(ParagraphAlignment.CENTER);
            priltext5.setIndentationFirstLine(500);
            priltext5.setSpacingAfter(200);

            try {
                FileOutputStream out = new FileOutputStream(dogname);
                doc.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}