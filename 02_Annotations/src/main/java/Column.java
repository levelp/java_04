/// Аннотация для столбца (поля) в базе данных
//-->
@interface Column {
    String value();

    // Максимальное количество символов
    // По-умолчанию: 0
    int maxLen() default 0;

    // Свойства аннотаций могут быть
    // любых примитивных типов + String + enum
    boolean isPassword() default false;
}
//<--
