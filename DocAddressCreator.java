/**
 * Класс получает на вход переменные из обработчика кнопки "OK" класса DocAddressGUI
 * Документ формируется путем заранее созданной формы и подстановкой переменных в отведенные для них места.
 * Документ разбит на части - Заголовки (zag) и Текст (text) по пунктам. Их 6 включая реквизиты.
 */

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;

public class DocAddressCreator {
    public DocAddressCreator(String cName, String cNum, String dateS, String dateE, String eName, String rName,
                             String rNameP, String prise, String pVat, String aAdress, String rInn, String rKpp,
                             String rBank, String rRs, String rKs, String rBik, String rPhone, String rEmail) {

        //Создание тела документа
        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph headerMain = doc.createParagraph();
        XWPFRun header = headerMain.createRun();

        header.setText("Договор на оказание услуг № " + cNum+ "/18-юа");
        header.addBreak();
        header.setText("г. Москва                                                                        " +
                "                       " + dateS+ " г.");
        header.addBreak();
        header.setFontSize(10);
        header.setFontFamily("Times New Roman");
        header.setBold(true);
        headerMain.setAlignment(ParagraphAlignment.CENTER);

        XWPFParagraph textMain = doc.createParagraph();
        XWPFRun text = textMain.createRun();

        text.setText("ЗАО «Рога и Копыта», именуемое в дальнейшем «Адресодатель», в лице Генерального директора Иванова В.В., " +
                "действующего на основании Устава, с одной стороны и " + eName + ", именуемое в" +
                " дальнейшем «Адресополучатель», в лице  Генерального директора " + rNameP +
                ", действующего на основании Устава," +
                " с другой стороны, вместе именуемые «Стороны», заключили настоящий Договор о нижеследующем:");
        text.setFontSize(10);
        text.setFontFamily("Times New Roman");
        textMain.setAlignment(ParagraphAlignment.BOTH);
        textMain.setIndentationFirstLine(500);
        textMain.setSpacingAfter(200);

        XWPFParagraph headerFirst = doc.createParagraph();
        XWPFRun header1 = headerFirst.createRun();

        header1.setText("1.  Предмет договора");
        header1.setFontSize(10);
        header1.setFontFamily("Times New Roman");
        header1.setBold(true);
        headerFirst.setSpacingAfter(0);

        XWPFParagraph textFirst = doc.createParagraph();
        XWPFRun tex1 = textFirst.createRun();

        tex1.setText("1.1.  На основании настоящего Договора Адресополучатель получает и оплачивает, " +
                "а Адресодатель обязуется в интересах Адресополучателя оказать услуги по предоставлению Адресополучателю" +
                " юридического адреса: 111222, г. Москва, ул. Такая-то, д. 10, корп. 2, стр. 2.");
        tex1.addBreak();
        tex1.setText("Вышеназванные услуги включают в себя получение и передачу Адресополучателю поступающей для него" +
                " корреспонденции (почты).");
        tex1.addBreak();
        tex1.setText("В рамках настоящего Договора вышеназванный адрес может быть указан как юридический адрес" +
                " в учредительных и иных документах Адресополучателя.");
        tex1.addBreak();
        tex1.setFontSize(10);
        tex1.setFontFamily("Times New Roman");
        textFirst.setSpacingAfter(100);
        textFirst.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerSecond = doc.createParagraph();
        XWPFRun header2 = headerSecond.createRun();

        header2.setText("2.  Срок договора");
        header2.setFontSize(10);
        header2.setFontFamily("Times New Roman ");
        header2.setBold(true);
        headerSecond.setSpacingAfter(0);

        XWPFParagraph textSecond = doc.createParagraph();
        XWPFRun text2 = textSecond.createRun();

        text2.setText("2.1. Срок оказания услуг по предоставлению юридического адреса составляет 1 (один) год и определяется с " + dateS +" г. по "+ dateE + " г.");
        text2.setFontSize(10);
        text2.setFontFamily("Times New Roman ");
        //textSecond.setSpacingAfter(0);
        textSecond.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerThird = doc.createParagraph();
        XWPFRun header3 = headerThird.createRun();
        header3.addBreak();
        header3.setText("3.  Обязанности сторон");
        header3.setFontSize(10);
        header3.setFontFamily("Times New Roman");
        header3.setBold(true);
        headerThird.setSpacingAfter(0);

        XWPFParagraph textThird = doc.createParagraph();
        XWPFRun text3 = textThird.createRun();
        text3.setText("3.1. Адресополучатель обязан:");
        text3.addBreak();
        text3.setText("- в течении 30 (тридцати) календарный дней с момента заключения настоящего Договора " +
                "выплатить Адресодателю вознаграждение в размере, определенном разделом 4 настоящего Договора;");
        text3.addBreak();
        text3.setText("- осуществлять прием корреспонденции по мере поступления, согласно договоренности " +
                "с Адресодателем.");
        text3.addBreak();
        text3.setText("3.2.  Адресодатель обязан:");
        text3.addBreak();
        text3.setText("- способствовать передаче и своевременно извещать Адресополучателя о поступающей для " +
                "него корреспонденции;");
        text3.addBreak();
        text3.setText("- не разглашать и не передавать корреспонденцию, документы и иную информацию, поступающую" +
                " для Адресополучателя, третьим лицам, не являющимся Стороной настоящего Договора.");
        text3.addBreak();
        text3.setFontSize(10);
        text3.setFontFamily("Times New Roman");
        textThird.setSpacingAfter(50);
        textThird.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerFourth = doc.createParagraph();
        XWPFRun header4 = headerFourth.createRun();

        header4.setText("4.  Платежи и расчеты по договору");
        header4.setFontSize(10);
        header4.setFontFamily("Times New Roman");
        header4.setBold(true);
        headerFourth.setSpacingAfter(0);

        XWPFParagraph textFourth = doc.createParagraph();
        XWPFRun text4 = textFourth.createRun();
        text4.setText("4.1.  Стоимость оказания услуг, указанных в п. 1.1. настоящего Договора, составляет "
                + prise + ", включая НДС 18% - " + pVat);
        text4.addBreak();
        text4.setText("4.2. По окончанию срока действия настоящего Договора для взаиморасчетов Стороны составляют" +
                " акт сдачи-приемки оказанных услуг.");
        text4.addBreak();
        text4.setFontSize(10);
        text4.setFontFamily("Times New Roman");
        textFourth.setSpacingAfter(100);
        textFourth.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerFifth = doc.createParagraph();
        XWPFRun header5 = headerFifth.createRun();

        header5.setText("5.  Прочие условия");
        header5.setFontSize(10);
        header5.setFontFamily("Times New Roman");
        header5.setBold(true);
        headerFifth.setSpacingAfter(0);

        XWPFParagraph textFifth = doc.createParagraph();
        XWPFRun text5 = textFifth.createRun();
        text5.setText("5.1. Настоящий Договор составлен в двух экземплярах: по одному для каждой из Сторон и считается " +
                "действительным только при наличии подписей обеих Сторон.");
        text5.addBreak();
        text5.setFontSize(10);
        text5.setFontFamily("Times New Roman");
        textFifth.setSpacingAfter(100);
        textFifth.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerSix = doc.createParagraph();
        headerSix.setPageBreak(true);
        XWPFRun header6 = headerSix.createRun();

        header6.setText("6. Сведения о сторонах");
        header6.setFontSize(10);
        header6.setFontFamily("Times New Roman");
        header6.setBold(true);
        headerSix.setSpacingAfter(100);
        headerSix.setAlignment(ParagraphAlignment.CENTER);

        //Создаем таблицу
        XWPFTable table = doc.createTable();

        XWPFTableRow row0 = table.getRow(0);

        XWPFTableCell cell0 = row0.getCell(0);
        XWPFParagraph tab6text1 = cell0.addParagraph();
        XWPFRun text61 = tab6text1.createRun();
        text61.setText("Адресодатель");
        text61.setFontSize(10);
        text61.setFontFamily("Times New Roman");
        text61.setBold(true);
        tab6text1.setSpacingAfter(100);
        tab6text1.setAlignment(ParagraphAlignment.CENTER);

        XWPFTableCell cell1 = row0.createCell();
        XWPFParagraph tab6text2 = cell1.addParagraph();
        XWPFRun text62 = tab6text2.createRun();
        text62.setText("Адресополучатель");
        text62.setFontSize(10);
        text62.setFontFamily("Times New Roman");
        text62.setBold(true);
        tab6text2.setSpacingAfter(100);
        tab6text2.setAlignment(ParagraphAlignment.CENTER);

        XWPFTableRow row1 = table.createRow();

        //Область для реквизитов Адресодателя
        XWPFTableCell cell2 = row1.getCell(0);
        XWPFParagraph tab6text3 = cell2.addParagraph();
        XWPFRun text63 = tab6text3.createRun();
        text63.setText("ЗАО Рога и Копыта");
        text63.addBreak();
        text63.setText("111222, г. Москва, ул. Такая-то, д. 10, корпус 2, стр. 2");
        text63.addBreak();
        text63.setText("ИНН 1234567890");
        text63.addBreak();
        text63.setText("КПП 123456789");
        text63.addBreak();
        text63.setText("Банковские реквизиты: ");
        text63.addBreak();
        text63.setText("Филиал №2231 Банка ТТК (ПАО) г. Москва");
        text63.addBreak();
        text63.setText("р/с 12345678901112131415");
        text63.addBreak();
        text63.setText("к/с 1234567890121314151");
        text63.addBreak();
        text63.setText("БИК 0445434652");
        text63.addBreak();
        text63.setText("Телефон:  +7 (495) 999-99-99");
        text63.addBreak();
        text63.setText("Эл. почта: 112233@mail.ru");
        text63.addBreak();
        text63.setFontSize(10);
        text63.setFontFamily("Times New Roman");
        text63.setBold(true);
        tab6text3.setSpacingAfter(100);
        tab6text3.setAlignment(ParagraphAlignment.LEFT);

        //Область для реквизитов Адресополучателя
        XWPFTableCell cell3 = row1.getCell(1);
        XWPFParagraph tab6text4 = cell3.addParagraph();
        XWPFRun text64 = tab6text4.createRun();
        text64.setText(eName);
        text64.addBreak();
        text64.setText(aAdress);
        text64.addBreak();
        text64.setText("ИНН "+rInn);
        text64.addBreak();
        text64.setText("КПП "+rKpp);
        text64.addBreak();
        text64.setText("Банковские реквизиты: ");
        text64.addBreak();
        text64.setText(rBank);
        text64.addBreak();
        text64.setText("р/с "+rRs);
        text64.addBreak();
        text64.setText("к/с "+rKs);
        text64.addBreak();
        text64.setText("БИК "+rBik);
        text64.addBreak();
        text64.setText("Телефон: "+ rPhone);
        text64.addBreak();
        text64.setText("Эл. почта: "+ rEmail);
        text64.addBreak();
        text64.setFontSize(10);
        text64.setFontFamily("Times New Roman");
        text64.setBold(true);
        tab6text4.setSpacingAfter(100);
        tab6text4.setAlignment(ParagraphAlignment.LEFT);

        XWPFTableRow row2 = table.createRow();

        //Область для подписи Адресодателя
        XWPFTableCell cell4 = row2.getCell(0);
        XWPFParagraph tab6text5 = cell4.addParagraph();
        XWPFRun text65 = tab6text5.createRun();
        text65.setText("Адресодатель");
        text65.addBreak();
        text65.addBreak();
        text65.setText("______________(Иванов В.В.)");
        text65.addBreak();
        text65.addBreak();
        text65.setText("____  _________2018 г.");
        text65.setFontSize(10);
        text65.setFontFamily("Times New Roman");
        text65.setBold(true);
        tab6text5.setSpacingAfter(100);
        tab6text5.setAlignment(ParagraphAlignment.LEFT);

        //Область для подписи Адресополучателя
        XWPFTableCell cell5 = row2.getCell(1);
        XWPFParagraph tab6text6 = cell5.addParagraph();
        XWPFRun text66 = tab6text6.createRun();
        text66.setText("Адресополучатель");
        text66.addBreak();
        text66.addBreak();
        text66.setText("______________(" + rName + ")");
        text66.addBreak();
        text66.addBreak();
        text66.setText("____  _________2018 г.");
        text66.setFontSize(10);
        text66.setFontFamily("Times New Roman");
        text66.setBold(true);
        tab6text6.setSpacingAfter(100);
        tab6text6.setAlignment(ParagraphAlignment.LEFT);


        try {
            FileOutputStream out = new FileOutputStream(cName);
            doc.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
