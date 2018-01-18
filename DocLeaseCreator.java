/**
 * Класс получает на вход переменные из обработчика кнопки "OK" класса DocLeaseGUI
 * Документ формируется путем заранее созданной формы и подстановкой переменных в отведенные для них места.
 * Документ разбит на части - Заголовки (zag) и Текст (text) по пунктам. Их 8 включая реквизиты.
 * После 8-го пункта формируется Акт-приемки.
 */

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;

public class DocLeaseCreator {
    public DocLeaseCreator(String cName, String cNum , String dateS, String dateE, String eName, String rName,
                               String rNameP, String address, String bti, String roomN, String roomSp,
                               String roomU, String prise, String pVat, String eAdress, String aAdress, String rInn,
                               String rKpp, String rBank, String rRs, String rKs,String rBik) {

        //Создание тела документа
        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph headerMain = doc.createParagraph();
        XWPFRun header = headerMain.createRun();

        header.setText("Договор № " + cNum);
        header.addBreak();
        header.setText("аренды нежилого помещения");
        header.addBreak();
        header.setText("г. Москва                                                                        " +
                "                       " + dateS + " г.");
        header.addBreak();
        header.setFontSize(10);
        header.setFontFamily("Times New Roman");
        header.setBold(true);
        headerMain.setAlignment(ParagraphAlignment.CENTER);

        XWPFParagraph textMain = doc.createParagraph();
        XWPFRun text = textMain.createRun();

        text.setText("ЗАО «Рога и Копыта», именуемое в дальнейшем «Арендодатель», в лице " +
                "Генерального директора Иванова В.В.," +
                " действующего на основании Устава, с одной стороны, и " + eName + ", именуемое в" +
                " дальнейшем «Арендатор»," +
                " в лице  Генерального директора " + rNameP + " , действующего на основании Устава," +
                " с другой стороны, вместе именуемые «Стороны», " +
                "заключили настоящий Договор о нижеследующем:");
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

        tex1.setText("1.1.  Арендодатель передаёт в аренду нежилое помещение, далее - Помещение, расположенное" +
                " по адресу: 111222, Российская Федерация, Москва, " + address + roomN +
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
        textFirst.setSpacingAfter(200);
        textFirst.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerSecond = doc.createParagraph();
        XWPFRun header2 = headerSecond.createRun();

        header2.setText("2.  Права и обязанности Сторон");
        header2.setFontSize(10);
        header2.setFontFamily("Times New Roman");
        header2.setBold(true);
        headerSecond.setSpacingAfter(0);

        XWPFParagraph textSecond = doc.createParagraph();
        XWPFRun text2 = textSecond.createRun();

        text2.setText("2.1.1.  Обязанности Арендодателя:");
        text2.addBreak();
        text2.setText("2.1.2.  Своевременно передать Арендатору Помещение в состоянии пригодном для использования\n" +
                "по назначению;");
        text2.addBreak();
        text2.setText("2.1.3.  Оказывать услуги, позволяющие создать условия для эффективной  деятельности, " +
                "а именно:");
        text2.addBreak();
        text2.setText("•         Обеспечивать электроэнергией, водоснабжением, отоплением, канализацией;");
        text2.addBreak();
        text2.setText("•         Нести расходы по содержанию Помещения, осуществлять уход за территорией предприятия," +
                " организовывать уборку и вывоз мусора, снега и льда с территории комплекса, в котором находится Помещение (далее- Комплекс);");
        text2.addBreak();
        text2.setText("•         Осуществлять охрану Помещения по окончании рабочего дня Арендатора;");
        text2.addBreak();
        text2.setText("2.1.4.  Обеспечивать беспрепятственный доступ в Помещения сотрудникам.\n" +
                "Арендатора.\n");
        text2.addBreak();
        text2.setText("2.1.5.  Беспрепятственно входить в Помещение в любое время суток при возникновении аварийных " +
                "ситуаций, пожара, с немедленным уведомлением Арендатора; в течение рабочего дня Арендатора при его " +
                "предварительном извещении и в его присутствии для осуществления контроля за целевым использованием" +
                " Помещения, проверки их технического состояния, присутствовать при проведении проверок у Арендатора " +
                "контролирующими органами. По\n" +
                "результатам проверок Арендодатель выносит решения, зафиксированные а Акте, обязательные " +
                "для исполнения Арендатором.\n");
        text2.addBreak();
        text2.setText("2.2.  Обязанности Арендатора");
        text2.addBreak();
        text2.setText("2.2.1.  Принять Помещение по Акту приема-передачи в срок, указанный " +
                "в п. 1.3 настоящего Договора.");
        text2.addBreak();
        text2.setText("2.2.2.  Своевременно и в полном объеме вносить арендную плату согласно условиям " +
                "настоящего Договора.");
        text2.addBreak();
        text2.setText("2.2.3.  При прекращении настоящего Договора вернуть Арендодателю Помещение по Акту " +
                "в том же состоянии; в каком он его получил с учетом нормального износа, а также улучшения," +
                " составляющие принадлежность Помещения и неотделимые без вреда для конструкции. Арендатор" +
                " оплачивает платежи, предусмотренные Договором, за период до даты фактического возврата Помещения. " +
                "В случае задержки возврата Помещения Арендатор выплачивает штраф в размере 0,1 % от месячной" +
                " арендной платы за каждый день просрочки. При повреждении Помещения Арендатор обязан в течение 5 " +
                "(пяти) дней возместить стоимость повреждений по рыночной цене, действующей на момент прекращения" +
                " действия Договора.");
        text2.addBreak();
        text2.setText("2.2.4.  Обеспечивать соблюдение правил техники безопасности в арендованном Помещении," +
                " соблюдать правила по повышению уровня антитеррористической безопасности на территории Комплекса " +
                "согласно Рекомендациям Правительства г. Москвы, иметь в наличии средства индивидуальной защиты " +
                "и обеспечить выполнение требований по Г.О.");
        text2.addBreak();
        text2.setText("2.2.5.  Не приносить и не хранить в Помещении и на прилегающей территории взрывоопасные," +
                " ядовитые, радиоактивные, биологические и легковоспламеняющиеся вещества.");
        text2.setText("2.2.6.  Содержать Помещение и имущество Арендодателя в технически исправном состоянии с " +
                "соблюдением санитарных и противопожарных правил в Помещении и прилагающей к нему территории, " +
                "самостоятельно и за свой счет устранять выявленные нарушения обязательств, допущенные" +
                " по вине Арендатора, согласовать и соблюдать режим, внутренние правила работы Комплекса, правила " +
                "сдачи Помещения под охрану, а также общественный порядок в Комплексе, обеспечивать " +
                "уборку Помещения. Соблюдать порядок на территории, прилагающей к Помещению;");
        text2.addBreak();
        text2.setText("         - проводить инструктаж своих работников по охране труда, технике безопасности, " +
                "противопожарной и электробезопасности и обеспечить соблюдение работниками указанных требований" +
                " действующего законодательства РФ;");
        text2.addBreak();
        text2.setText("         - содержать Помещения в соответствии с требованиями пожарной безопасности, " +
                "соблюдать правила Пожарной безопасности в Российской Федерации ( утвержденные Постановлением" +
                " Правительства от 25.04.2012 года № 390) и другие пожарные нормы и правила, в том числе обеспечить" +
                " безопасность людей при пожаре, иметь Инструкцию о мерах пожарной безопасности в арендуемых" +
                " помещениях и первичные средства пожаротушения (огнетушители и т.д.), обеспечить противопожарную " +
                "безопасность Помещений. Персональную ответственность за пожарную безопасность арендуемых помещений" +
                " несут руководители ( назначенные ими представители) Арендатора. Соблюдение положений данного" +
                " абзаца является существенным условием Договора.");
        text2.addBreak();
        text2.setText("         - возместить материальный ущерб Арендодателю в полном объеме в случае пожара" +
                "или аварии, возникших по вине Арендатора или восстановить Помещения собственными силами " +
                "и средствами в согласованные с Арендодателем сроки.");
        text2.addBreak();
        text2.setText("2.2.7.  Немедленно извещать Арендодателя о всяком повреждении, аварии или ином событии," +
                " причиняющим или способным причинять ущерб Комплексу или Помещению, а также незамедлительно" +
                " принять все необходимые меры к устранению повреждений или аварий, а также обеспечить допуск " +
                "в Помещение представителей Арендодателя или соответствующих служб с целью, " +
                "устранения неисправностей, аварий и их последствий в любое время. В случае аварий внутренних," +
                " тепло-, энерго- других сетей по вине Арендатора принимать все необходимые меры к устранению" +
                " аварий и их последствий за свой счет.");
        text2.addBreak();
        text2.setText("2.2.8.  В установленные Договором сроки вносить арендную плату на расчетный счет\n" +
                "Арендодателя, указанный в настоящем Договоре.\n");
        text2.addBreak();
        text2.setText("2.2.9.  Начать использовать Помещение по целевому назначению не позднее 15 (пятнадцати) дней\n" +
                "со дня приема его по Акту приема-передачи.\n");
        text2.addBreak();
        text2.setText("2.2.10.  Осуществлять коммерческую деятельность в Комплексе в соответствии с" +
                " действующим законодательством РФ.");
        text2.addBreak();
        text2.setText("2.2.11.  По первому требованию предоставлять Арендодателю документы по его запросу.");
        text2.addBreak();
        text2.setText("2.2.12.  При проведении проверок контролирующими органами Арендатора немедленно извещать " +
                "Арендодателя об этом. ");
        text2.addBreak();
        text2.setText("2.2.13.  В течение рабочего дня Арендатор самостоятельно несет ответственность за сохранность " +
                "принадлежащего ему имущества. Арендатор по согласованию с Арендодателем вправе дополнительно" +
                " организовать в Помещении охрану силами лицензированного ЧОП.");
        text2.addBreak();
        text2.setText("2.2.1.4. Не производить реконструкцию Помещения, перепланировку, переоборудование и другие " +
                "капитальные ремонтные работы без письменного согласия Арендодателя. Неотделимые улучшения " +
                "производить только с письменного разрешения Арендодателя.");
        text2.addBreak();
        text2.setText("2.2.15. Арендатор несет материальную ответственность в соответствии с законодательством РФ " +
                "при привлечении к работам лиц, не имеющих выданного в установленном порядке компетентным" +
                " органом РФ разрешения на работу.");
        text2.addBreak();
        text2.addBreak();
        text2.setFontSize(10);
        text2.setFontFamily("Times New Roman");
        textSecond.setSpacingAfter(200);
        textSecond.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerThird = doc.createParagraph();
        XWPFRun header3 = headerThird.createRun();
        header3.addBreak();
        header3.setText("3.  Порядок расчетов");
        header3.setFontSize(10);
        header3.setFontFamily("Times New Roman");
        header3.setBold(true);
        headerThird.setSpacingAfter(0);

        XWPFParagraph textThird = doc.createParagraph();
        XWPFRun text3 = textThird.createRun();
        text3.setText("3.1.  Арендная плата составляет " + prise + ", включая НДС 18% - " + pVat);
        text3.addBreak();
        text3.setText("3.2.  Арендатор перечисляет арендную плату и другие платежи за первый месяц аренды в" +
                " течение 5 (пяти) дней с момента подписания Акта приема-передачи Помещения.");
        text3.addBreak();
        text3.setText("3.3.  В дальнейшем Арендатор перечисляет арендную плату ежемесячно не позднее 5-ого" +
                " числа текущего месяца на расчетный счет Арендодателя, в строгом соответствии с реквизитами, указанными в настоящем Договоре. Любой платеж по настоящему Договору считается произведенным с даты поступления денежных средств на расчетный счет Арендодателя.");
        text3.addBreak();
        text3.setText("3.4.  Арендная плата включает в себя плату за пользование Помещением, " +
                "эксплуатационно-коммунальные платежи, вывоз мусора, уборка снега и льда и другие расходы по содержанию Комплекса.");
        text3.addBreak();
        text3.setText("3.5.  Размер арендной платы может быть изменен Арендодателем только в случае изменения" +
                " тарифов и цен на коммунальные и эксплуатационные услуги. Арендатор извещается об этом в" +
                " письменном виде не позднее, чем за 30 (Тридцать) дней до введения таких изменений. В случае" +
                " несогласия Арендатора с изменением арендной платы, Арендодатель вправе досрочно расторгнуть" +
                " настоящий Договор по истечении вышеуказанного срока предупреждения");
        text3.addBreak();
        text3.setFontSize(10);
        text3.setFontFamily("Times New Roman");
        textThird.setSpacingAfter(100);
        textThird.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerFourth = doc.createParagraph();
        XWPFRun header4 = headerFourth.createRun();

        header4.setText("4.  Ответственность сторон");
        header4.setFontSize(10);
        header4.setFontFamily("Times New Roman");
        header4.setBold(true);
        headerFourth.setSpacingAfter(0);

        XWPFParagraph textFourth = doc.createParagraph();
        XWPFRun text4 = textFourth.createRun();
        text4.setText("4.1.  За неуплату платежей в сроки, установленные п. 3.2., п. 3.3. настоящего Договора," +
                " Арендатору начисляется пени в размере 0,1 % от суммы неуплаты за каждый день просрочки. " +
                "Выплата пени не освобождает Арендатора от выполнения его основного обязательства.");
        text4.addBreak();
        text4.setText("4.2.  В случае причинения ущерба Помещению, Комплексу или третьим лицам в результате действий" +
                " Арендатора или непринятия им необходимых мер для его предотвращения, Арендатор устраняет ущерб " +
                "своими силами и за свой счет, или возмещает причиненный ущерб Арендодателю и/или третьим лицам " +
                "в полном объеме в течение 5 (пяти) дней с момента выставления претензии.");
        text4.addBreak();
        text4.setText("4.3.  Арендодатель не несет ответственности за отсутствие у Арендатора разрешительной " +
                "документации на занятие деятельностью, указанной в п. 1.3.Настоящего Договора.");
        text4.addBreak();
        text4.setText("4.4.  В случае отсутствия Арендатора в арендуемом Помещении без уведомления Арендодателя " +
                "в течение 5 (пяти) дней и уклонения от уплаты арендной платы, Арендодатель имеет право " +
                "с представителями нейтральной стороны вскрыть Помещение, провести снятие " +
                "остатков товарно-материальных ценностей с составлением акта, и зачесть часть стоимости " +
                "товарно-материальных ценностей в качестве компенсации задолженности Арендатора перед Арендодателем," +
                " оставшуюся часть товарно-материальных ценностей вернуть Арендатору. ");
        text4.addBreak();
        text4.setText("4.5.  Арендодатель не несет ответственности за перебои в обеспечении круглосуточной работы" +
                " в Помещении систем центрального отопления, электроснабжения, холодного и горячего водоснабжения, " +
                "канализации, происшедших по вине организаций, обеспечивающих поддержание и эксплуатацию систем" +
                " жизнеобеспечения Помещения.");
        text4.addBreak();
        text4.setText("4.6.  Споры и разногласия между Сторонами по настоящему Договору разрешаются путем переговоров" +
                " в течение 15 (пятнадцати) дней. В случае не достижения согласия спор подлежит рассмотрению в " +
                "Арбитражном суде г. Москвы в установленном законодательством порядке.");
        text4.addBreak();
        text4.setFontSize(10);
        text4.setFontFamily("Times New Roman");
        textFourth.setSpacingAfter(100);
        textFourth.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerFifth = doc.createParagraph();
        XWPFRun header5 = headerFifth.createRun();

        header5.setText("5.  Срок действия, порядок изменения и расторжения договора");
        header5.setFontSize(10);
        header5.setFontFamily("Times New Roman");
        header5.setBold(true);
        headerFifth.setSpacingAfter(0);

        XWPFParagraph textFifth = doc.createParagraph();
        XWPFRun text5 = textFifth.createRun();
        text5.setText("5.1.  Помещение сдается в аренду с " + dateS + " по "+ dateE +" включительно и действует" +
                " в течение указанного срока, при условии исполнения Сторонами всех принятых на себя обязательств " +
                "по настоящему Договору. Если ни одна из сторон не позднее, чем за 30 (тридцать) календарных дней " +
                "до истечения срока действия настоящего договора не заявит о своем желании его прекратить," +
                " последний считается автоматически продленным на срок 11 (одиннадцать) месяцев, на условиях " +
                "предусмотренных настоящим договором. Количество продлений настоящего договора не ограничено.");
        text5.addBreak();
        text5.setText("5.2.  Изменение условий настоящего Договора, его расторжение и прекращение допускаются " +
                "по соглашению Сторон. Вносимые дополнения и изменения рассматриваются Сторонами в месячный срок" +
                " и оформляются дополнительным соглашением, подписываемым Сторонами.");
        text5.addBreak();
        text5.setText("5.3.  Договор подлежит досрочному расторжению по требованию Арендодателя," +
                " а Арендатор принудительному выселению в следующих случаях:");
        text5.addBreak();
        text5.setText("5.3.1.  При использовании Арендатором Помещения не в соответствии с его целевым назначением," +
                " установленным в п. 1.2. настоящего Договора, в течение 1 (одного) месяца;");
        text5.addBreak();
        text5.setText("5.3.2.  Если Арендатор умышленно ухудшает состояние Помещения;");
        text5.addBreak();
        text5.setText("5.3.3.  Если Арендатор не вносит арендную плату по истечении установленного Договором " +
                "срока платежа свыше 20 (двадцати) дней;");
        text5.addBreak();
        text5.setText("5.3.4.  Если Арендатор систематически (два или более раз) нарушает установленные Договором " +
                "сроки внесения арендной платы;");
        text5.addBreak();
        text5.setText("5.3.5.  Ликвидации Арендатора как юридического лица;");
        text5.addBreak();
        text5.setText("5.3.6.  В случае препятствия проведения проверок, предусмотренных п.п. 2.1.5. настоящего " +
                "Договора, неисполнения в срок решений, вынесенных по результатам проверок, а также неоднократного " +
                "несоблюдения режима работы Комплекса;");
        text5.addBreak();
        text5.setText("5.3.7.  В случае систематического (два и более раз) нарушения Арендатором обязательств " +
                "по настоящему Договору, которые должны быть зафиксированы протоколом в присутствии" +
                " нейтральной стороны.");
        text5.addBreak();
        text5.setText("5.4.  Арендодатель реализует свое право на одностороннее расторжение настоящего Договора " +
                "согласно вышеуказанным положениям только после предоставления Арендатору права на устранение" +
                " выявленных нарушений. Арендодатель письменно уведомляет Арендатора о выявленном нарушении " +
                "и устанавливает разумный срок для его устранения.");
        text5.addBreak();
        text5.setText("Арендодатель имеет право расторгнуть настоящий Договор в одностороннем порядке в случае " +
                "принятия решения реконструкции Помещения или самостоятельном его пользовании.");
        text5.addBreak();
        text5.setText("5.5.  Договор подлежит досрочному расторжению по требованию Арендатора:");
        text5.addBreak();
        text5.setText("5.6.1.  Если Помещение в силу обстоятельств, за которые Арендатор не отвечает, " +
                "окажется в состоянии непригодном для использования;");
        text5.addBreak();
        text5.setText("5.6.2.  В случае несогласии с изменением арендной платы.");
        text5.addBreak();
        text5.setText("5.7.  Договор, может быть, расторгнут по соглашению Сторон.");
        text5.addBreak();
        text5.setText("5.8.  Сторона, по требованию которой досрочно расторгается настоящий Договор, обязана\n" +
                "письменно уведомить другую Сторону за 4 (четыре) недели до даты расторжения Договора.\n" +
                "Арендатор по истечении этого срока в течение З(трех) дней обязан сдать Помещение по Акту\n" +
                "приема-передачи в исправном состоянии, с учетом нормального износа.\n");
        text5.addBreak();
        text5.setFontSize(10);
        text5.setFontFamily("Times New Roman");
        textFifth.setSpacingAfter(100);
        textFifth.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerSixth = doc.createParagraph();
        XWPFRun header6 = headerSixth.createRun();

        header6.setText("6.  Особые условия");
        header6.setFontSize(10);
        header6.setFontFamily("Times New Roman");
        header6.setBold(true);
        headerSixth.setSpacingAfter(0);

        XWPFParagraph textSixth = doc.createParagraph();
        XWPFRun text6 = textSixth.createRun();
        text6.setText("6.1. Если Договор подлежит досрочному расторжению, а Арендатор - выселению, " +
                "согласно п. 5.4. настоящего Договора, то Арендодатель, после письменного уведомления " +
                "Арендатора вправе:");
        text6.addBreak();
        text6.setText("•         Удерживать имущество Арендатора в качестве обеспечения выполнения " +
                "последним обязательств по настоящему Договору;");
        text6.addBreak();
        text6.setText("•         Прекратить предоставление Арендатору возможности пользования электросетью и т.д.");
        text6.addBreak();
        text6.setText("•         Прекратить допуск в Помещение сотрудников Арендатора.");
        text6.addBreak();
        text6.setFontSize(10);
        text6.setFontFamily("Times New Roman");
        textSixth.setSpacingAfter(100);
        textSixth.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerSeventh = doc.createParagraph();
        XWPFRun header7 = headerSeventh.createRun();

        header7.setText("7.  Заключительные положения");
        header7.setFontSize(10);
        header7.setFontFamily("Times New Roman");
        header7.setBold(true);
        headerSeventh.setSpacingAfter(0);

        XWPFParagraph textSeventh = doc.createParagraph();
        XWPFRun text7 = textSeventh.createRun();
        text7.setText("7.1.  Условия  настоящего  Договора Сторонами  определены как конфиденциальные " +
                "и не в нежащие разглашению;");
        text7.addBreak();
        text7.setText("7.2.  В случаях, не урегулированных настоящим Договором," +
                " применяется гражданское законодательство РФ;");
        text7.addBreak();
        text7.setText("7.3.  Стороны обязаны в течение 5 (пяти) календарных дней информировать друг друга об\n" +
                "изменении организационно-правовой форм, наименования, адреса местонахождения, банковских\n" +
                "реквизитах, о предстоящей реорганизации или ликвидации;\n");
        text7.addBreak();
        text7.setText("7.4.  Стороны обязуются рассматривать полученные друг от друга документы и письма и давать на " +
                "них ответ в течение 72(семидесяти двух) часов с момента их получения;");
        text7.addBreak();
        text7.setText("7.5.  Настоящий Договор составлен в двух экземплярах, имеющих равную юридическую силу, по" +
                " одному экземпляру для каждой из сторон.");
        text7.addBreak();
        text7.setFontSize(10);
        text7.setFontFamily("Times New Roman");
        textSeventh.setSpacingAfter(100);
        textSeventh.setAlignment(ParagraphAlignment.NUM_TAB);

        XWPFParagraph headerEighth = doc.createParagraph();
        headerEighth.setPageBreak(true);
        XWPFRun header8 = headerEighth.createRun();

        header8.setText("8. РЕКВИЗИТЫ И ПОДПИСИ СТОРОН");
        header8.setFontSize(10);
        header8.setFontFamily("Times New Roman");
        header8.setBold(true);
        headerEighth.setSpacingAfter(100);
        headerEighth.setAlignment(ParagraphAlignment.CENTER);

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
        text83.setText("ЗАО «Рога и Копыта»");
        text83.addBreak();
        text83.setText("Юр. Адрес 111222, г. Москва, ул. Такая-то, д. 10, корпус 2");
        text83.addBreak();
        text83.setText("Фактический адрес: 111222, г. Москва, ул. Такая-то, д.10, корпус 2 ");
        text83.addBreak();
        text83.setText("ИНН 1234567890");
        text83.addBreak();
        text83.setText("КПП 123456789");
        text83.addBreak();
        text83.setText("Банковские реквизиты: ");
        text83.addBreak();
        text83.setText("Филиал №2231 Банка ТТК (ПАО) г. Москва");
        text83.addBreak();
        text83.setText("р/с 12345678901112131415");
        text83.addBreak();
        text83.setText("к/с 1234567890121314151");
        text83.addBreak();
        text83.setText("БИК 0445434652");
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
        text84.setText(eName);
        text84.addBreak();
        text84.setText("Юр. Адрес: " + eAdress);
        text84.addBreak();
        text84.setText("Фактический адрес: "+aAdress);
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
        text85.setText("____  _________2018 г.");
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
        text86.setText("______________(" + rName + ")");
        text86.addBreak();
        text86.addBreak();
        text86.setText("____  _________2018 г.");
        text86.setFontSize(10);
        text86.setFontFamily("Times New Roman");
        text86.setBold(true);
        tab8text6.setSpacingAfter(100);
        tab8text6.setAlignment(ParagraphAlignment.LEFT);

        // Создание листа приложения
        XWPFParagraph attachmentHeaderFirst = doc.createParagraph();
        attachmentHeaderFirst.setPageBreak(true);
        XWPFRun attachmentFirst = attachmentHeaderFirst.createRun();

        attachmentFirst.setText("Приложение №1");
        attachmentFirst.addBreak();
        attachmentFirst.setText("к договору аренды № " + cNum + " от " + dateS);
        attachmentFirst.setFontSize(10);
        attachmentFirst.setFontFamily("Times New Roman");
        attachmentFirst.setBold(true);
        attachmentHeaderFirst.setSpacingAfter(200);
        attachmentHeaderFirst.setAlignment(ParagraphAlignment.RIGHT);

        XWPFParagraph attachmentHeaderSecond = doc.createParagraph();
        XWPFRun attachmentSecond = attachmentHeaderSecond.createRun();

        attachmentSecond.setText("АКТ ПРИЕМА-ПЕРЕДАЧИ");
        attachmentSecond.addBreak();
        attachmentSecond.setText("в аренду нежилого помещения, расположенного по адресу 111222, Москва, " + address);
        attachmentSecond.addBreak();
        attachmentSecond.addBreak();
        attachmentSecond.setText("г. Москва                                " +
                "                                                                               " + dateS);
        attachmentSecond.addBreak();
        attachmentSecond.setFontSize(10);
        attachmentSecond.setFontFamily("Times New Roman");
        attachmentSecond.setBold(true);
        attachmentHeaderSecond.setAlignment(ParagraphAlignment.CENTER);


        XWPFParagraph attachmentTextFirst = doc.createParagraph();
        XWPFRun attachmentText1 = attachmentTextFirst.createRun();

        attachmentText1.setText("ЗАО «Рога и Копыта», именуемое в дальнейшем «Арендодатель», в лице " +
                "Генерального директора Иванова В.В.," +
                " действующего на основании Устава, с одной стороны, и " + eName + ", именуемое в" +
                " дальнейшем «Арендатор»," +
                " в лице  Генерального директора " + rNameP + " , действующего на основании Устава," +
                " с другой стороны, вместе именуемые «Стороны», " +
                "заключили настоящий Акт о нижеследующем:");
        attachmentText1.setFontSize(10);
        attachmentText1.setFontFamily("Times New Roman");
        attachmentTextFirst.setAlignment(ParagraphAlignment.BOTH);
        attachmentTextFirst.setIndentationFirstLine(500);
        attachmentTextFirst.setSpacingAfter(200);

        XWPFParagraph attachmentTextSecond = doc.createParagraph();
        XWPFRun attachmentText2 = attachmentTextSecond.createRun();

        attachmentText2.setText("1. Арендодатель передает, а Арендатор принимает в аренду в соответствии с условиями\n" +
                "Договора аренды нежилого помещения №" + cNum + " от " + dateS + " Помещение, общей площадью " +
                roomSp + " кв.м., " +
                "расположенное в здании по адресу: Москва, " + address + roomN + ".");
        attachmentText2.addBreak();
        attachmentText2.setText("2.\tТехническое состояние Помещения на момент подписания Акта приемки-передачи позволяет " +
                "использовать его в целях, предусмотренных п. 1.2 указанного договора аренды.");
        attachmentText2.addBreak();
        attachmentText2.setText("3.\tТехнические характеристики помещения соответствуют требованиям Арендатора.");
        attachmentText2.addBreak();
        attachmentText2.setText("4.\tАрендная плата за пользование вышеуказанным Помещением взимается со дня\n" +
                "подписания настоящего Акта.\n");
        attachmentText2.addBreak();
        attachmentText2.setText("5.\tНастоящий Акт составлен в 2 (Двух) подлинных экземплярах, имеющих одинаковую\n" +
                " юридическую силу, по одному экземпляру для каждой из Сторон.\n");
        attachmentText2.addBreak();
        attachmentText2.setFontSize(10);
        attachmentText2.setFontFamily("Times New Roman");
        attachmentTextSecond.setAlignment(ParagraphAlignment.BOTH);
        //priltext2.setIndentationFirstLine(500);
        attachmentTextSecond.setSpacingAfter(500);

        XWPFParagraph attachmentTextThird = doc.createParagraph();
        XWPFRun attachmentText3 = attachmentTextThird.createRun();

        attachmentText3.setText("ПОДПИСИ СТОРОН");
        attachmentText3.addBreak();
        attachmentText3.setFontSize(10);
        attachmentText3.setFontFamily("Times New Roman");
        attachmentTextThird.setAlignment(ParagraphAlignment.CENTER);
        attachmentTextThird.setIndentationFirstLine(500);
        attachmentTextThird.setSpacingAfter(200);

        XWPFParagraph attachmentTextFourth = doc.createParagraph();
        XWPFRun attachmentText4 = attachmentTextFourth.createRun();

        attachmentText4.setText("Арендодатель:                                               " +
                "                                         Арендатор:");
        attachmentText4.addBreak();
        attachmentText4.setFontSize(10);
        attachmentText4.setFontFamily("Times New Roman");
        attachmentText4.setBold(true);
        attachmentTextFourth.setAlignment(ParagraphAlignment.CENTER);
        attachmentTextFourth.setIndentationFirstLine(200);
        attachmentTextFourth.setSpacingAfter(200);

        XWPFParagraph attachmentTextFifth = doc.createParagraph();
        XWPFRun attachmentText5 = attachmentTextFifth.createRun();

        attachmentText5.setText("Генеральный директор:                                                                   " +
                "                     Генеральный директор:");
        attachmentText5.addBreak();
        attachmentText5.setFontSize(10);
        attachmentText5.setFontFamily("Times New Roman");
        attachmentTextFifth.setAlignment(ParagraphAlignment.CENTER);
        attachmentTextFifth.setIndentationFirstLine(500);
        attachmentTextFifth.setSpacingAfter(200);

        XWPFParagraph attachmentTextSixth = doc.createParagraph();
        XWPFRun attachmentText6 = attachmentTextSixth.createRun();

        attachmentText6.setText("_____________Иванов В.В.                                              " +
                "                   _______________" + rName);
        attachmentText6.addBreak();
        attachmentText6.setFontSize(10);
        attachmentText6.setFontFamily("Times New Roman");
        attachmentTextSixth.setAlignment(ParagraphAlignment.CENTER);
        attachmentTextSixth.setIndentationFirstLine(500);
        attachmentTextSixth.setSpacingAfter(200);

        try {
            FileOutputStream out = new FileOutputStream(cName);
            doc.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
