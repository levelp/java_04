<!-- doc.py -->
﻿[![Build Status](https://travis-ci.org/levelp/java_04.svg?branch=master)](https://travis-ci.org/levelp/java_04)
[![Coverage Status](https://coveralls.io/repos/github/levelp/java_04/badge.svg?branch=master)](https://coveralls.io/github/levelp/java_04?branch=master)

Системы сборки Java
===================

ant
---
**ant** - утилита для автоматизации процесса сборки программного продукта. Является платформонезависимым аналогом утилиты make, где все команды записываются в XML-формате.
**Императивная** сборка проекта.

Пример **build.xml**:
``` xml
<?xml version="1.0"?>
<project default="build" basedir=".">
    <property name="name" value="AntBuildJar"/>
    <property name="src.dir" location="${basedir}/src"/>
    <property name="build" location="${basedir}/build"/>
    <property name="build.classes" location="${build}/classes"/>
    <path id="libs.dir">
	<fileset dir="lib" includes="**/*.jar"/>
    </path>
    <!-- Сборка приложения -->
    <target name="build" depends="clean" description="Builds the application">
        <!-- Создание директорий -->
        <mkdir dir="${build.classes}"/>

        <!-- Компиляция исходных файлов -->
        <javac srcdir="${src.dir}"
               destdir="${build.classes}"
               debug="false"
               deprecation="true"
               optimize="true" >
            <classpath refid="libs.dir"/>
        </javac>

        <!-- Копирование необходимых файлов -->
        <copy todir="${build.classes}">
            <fileset dir="${src.dir}" includes="**/*.*" excludes="**/*.java"/>
        </copy>

        <!-- Создание JAR-файла -->
        <jar jarfile="${build}/${name}.jar">
            <fileset dir="${build.classes}"/>
        </jar>
    </target>

    <!-- Очистка -->
    <target name="clean" description="Removes all temporary files">
        <!-- Удаление файлов -->
        <delete dir="${build.classes}"/>
    </target>
</project>
```

maven
-----
Фреймворк для автоматизации сборки проектов, специфицированных на XML-языке POM (Project Object Model).
Декларативная сборка проекта.

**POM** - Project Object Model

Установка и настройка
---------------------
* Загрузить: http://maven.apache.org/download.cgi
* Добавить путь к **mvn.bat** в PATH
* **M2_HOME** на каталог c **maven**: M2_HOME=C:\apache-maven-3.2.5

Центральный репозиторий Maven
-----------------------------
* Поискать артефакт: http://search.maven.org/

* Локальный репозиторий: %USERPROFILE%\\.m2

Свои репозитории (Sonatype nexus)
---------------------------------
* Скачиваем + ставим: http://www.sonatype.org/nexus/
* Доступ из локальной сети
* Можно публиковать свои артефакты

Консольный запуск
-----------------
``` bat
mvn
mvn test
mvn clean
mvn clean install
```

Как работает инкрементная сборка в maven?
-----------------------------------------


``` xml
<project>
  <!-- версия модели для POM-ов Maven 2.x всегда 4.0.0 -->
  <modelVersion>4.0.0</modelVersion>

  <!-- координаты проекта, то есть набор значений, который
       позволяет однозначно идентифицировать этот проект -->

  <groupId>com.mycompany.app</groupId>
  <artifactId>my-app</artifactId>
  <version>1.0</version>

  <!-- зависимости от библиотек -->

  <dependencies>
    <dependency>

      <!-- координаты необходимой библиотеки -->

      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>

      <!-- эта библиотека используется только для запуска и компилирования тестов -->

      <scope>test</scope>

    </dependency>
  </dependencies>
</project>
```

**Структура maven-проекта**
Корневой каталог проекта: файл **pom.xml** и все дальнейшие подкаталоги
* src: все исходные файлы
 * src/main: исходные файлы собственно для продукта
   * src/main/java: Java-исходный текст
   * src/main/resources: другие файлы, которые используются при компиляции или исполнении, например Properties-файлы
 * src/test: исходные файлы, необходимые для организации автоматического тестирования
   * src/test/java: JUnit-тест-задания для автоматического тестирования
* target: все создаваемые в процессе работы Мавена файлы
 * target/classes: компилированные Java-классы

gradle
------
Система автоматической сборки, построенная на принципах Apache Ant и Apache Maven, но предоставляющая DSL на языке Groovy вместо XML.

Внутренние классы. Параметризация. MVC, CRUD, DAO
=================================================

Внутренние классы (статические, нестатические, анонимные)
---------------------------------------------------------

Реализация анонимного маппера. Параметризация. Стирание типов. Ограничения
--------------------------------------------------------------------------

Слои приложения. MVC. CRUD. DAO
-------------------------------

Дополнительные примеры
----------------------
Калькулятор: git@github.com:levelp/JavaCalc.git

Домашнее задание
----------------
* Создать интерфейс DAO работы с моделью.
* Реализовать этот интерфейс через коллекции.

Литература:
-----------
* Структуры данных в картинках.
* Часто-задаваемые-на-собеседованиях-вопросы-по-классам-коллекций.
* Коллекции Java (Java Collections Framework)
* Пакет java.util



Утверждения
-----------
Книга: Программист-прагматик. Путь от подмастерья к мастеру
http://www.ozon.ru/context/detail/id/1657382/
"Мёртвые программы не лгут"
Подсказка 32: Пусть аварийное завершение работы программы произойдет как можно раньше
Проверка утверждения
assert Утверждение;
assert Утверждение : Сообщение_об_ошибке;
``` java
        assert a > 4 : "a = " + a;
        assert a > 1; // Вариант без сообщения об ошибке
```

Должно быть сообщение:
Exception in thread "main" java.lang.AssertionError:
a = 9
Для включения нужен ключ VM: -ea (-enableAssertions)
[01_Assert/src/main/java/AssertDemo.java](01_Assert/src/main/java/AssertDemo.java)


Аннотация для столбца (поля) в базе данных
``` java
@interface Column {
    String value();

    // Максимальное количество символов
    // По-умолчанию: 0
    int maxLen() default 0;

    // Свойства аннотаций могут быть
    // любых примитивных типов + String + enum
    boolean isPassword() default false;
}
```

[02_Annotations/src/main/java/Column.java](02_Annotations/src/main/java/Column.java)

Является ли поле первичным ключом?
``` java
@Retention(RetentionPolicy.RUNTIME)
@interface PrimaryKey {
}
```

[02_Annotations/src/main/java/PrimaryKey.java](02_Annotations/src/main/java/PrimaryKey.java)

Объявление аннотации
--------------------
@Retention - служебная аннотация, которая
задаёт область видимости аннотаций
Значение "без имени" называется value()
[02_Annotations/src/main/java/TableName.java](02_Annotations/src/main/java/TableName.java)

Использование своих аннотаций
``` java
// users
@TableName("main_users")
class User {

    @PrimaryKey
    @Column("id")
    public int id;
    @Column(value = "password", isPassword = true)
    public String password;
    @Column(value = "NAME_STR", maxLen = 20)
    String name;

    /**
     * Альтернативный способ получения имя таблицы
     *
     * @return имя таблицы
     */
    String tableName() {
        return "main_users";
    }
}
```

[02_Annotations/src/main/java/User.java](02_Annotations/src/main/java/User.java)

Подключить все методы: assertEquals можно с помощью
``` java
import static org.junit.Assert.*;
```
Или сделав класс с тестами наследником Assert
``` java
public class UserTest extends Assert {
    @Test
    public void testUser() {
        User user = new User();
        user.name = "Иван Иванович Иванов";

        // Метаинформация о классе User
        Class userClass = user.getClass();
        TableName tableName = (TableName) userClass.getAnnotation(TableName.class);
        // Если нет такой аннотации
        assertNotNull(tableName);
        assertEquals("main_users", tableName.value());
    }
}
```

[02_Annotations/src/test/java/UserTest.java](02_Annotations/src/test/java/UserTest.java)

Модульное тестирование JUnit4
=============================
JUnit = Java Unit - библиотека для модульного тестирования (unit tests)
В JUnit4 при создании тестов используются Java-аннотации
Сслыка: http://habrahabr.ru/post/120101/ - статья про JUnit

Аннотации JUnit4
----------------
Основная: @Test - помечаем все "тестовые" методы (каждый метод - тест)
Аннотация @BeforeClass обозначает методы, которые будут вызваны до создания экземпляра тест-класса,
методы должны быть public static void.
Имеет смысл размещать предустановки для теста в случае, когда класс содержит несколько тестов использующих
различные предустановки, либо когда несколько тестов используют одни и те же данные, чтобы
не тратить время на их создание для каждого теста.
``` java
    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass - перед всеми тестами");
    }
```


Аннотация @Before обозначает методы, которые будут вызваны до исполнения теста, методы должны быть public void.
Здесь обычно размещаются предустановки для теста (например генерация тестовых данных).
``` java
    @Before
    public void beforeEveryTest() {
        System.out.println("@Before - Перед каждым тестом");
    }
```

Если в тестируемом коде мы ожимдаем исключение (исключение сообщает об ощибке),
то используем параметр expected
``` java
    @Test(expected = NumberFormatException.class)
    public void testToHexStringWrong() {
        int x = Integer.parseInt("null");
        System.out.println("x = " + x);
    }
```

Аннотация @Ignore - Отключаем тест (например, чтобы исправить его в когда-нибудь в будущем)
[03_JUnitAnnotations/src/test/java/JUnitTest.java](03_JUnitAnnotations/src/test/java/JUnitTest.java)


Тесты на JUnit3

Тестовый класс должен быть наследником TestCase (junit.framework.TestCase)
``` java
public class JUnit3Demo extends TestCase {

    private final Map<String, byte[]> toHexStringData = new HashMap<String, byte[]>();

    protected static void setUpClass() {
        System.out.println("JUnit3Demo.setUpClass");
    }

    protected static void tearDownClass() {
        System.out.println("JUnit3Demo.tearDownClass");
    }

    public void testIsEmpty() {
        boolean actual = StringUtils.isEmpty(null);
        assertTrue(actual);

        actual = StringUtils.isEmpty("");
        assertTrue(actual);

        actual = StringUtils.isEmpty(" ");
        assertFalse(actual);

        actual = StringUtils.isEmpty("some string");
        assertFalse(actual);
    }

    // Аналог @Before из JUnit4
    protected void setUp() throws Exception {
        toHexStringData.put("", new byte[0]);
        toHexStringData.put("01020d112d7f", new byte[]{1, 2, 13, 17, 45, 127});
        toHexStringData.put("00fff21180", new byte[]{0, -1, -14, 17, -128});
        //...
    }

    // Аналог @After из JUnit4
    protected void tearDown() throws Exception {
        toHexStringData.clear();
    }

    public void testToHexString() {
        for (Object o : toHexStringData.keySet()) {
            final String expected = (String) o;
            final byte[] testData = toHexStringData.get(expected);
            final String actual = StringUtils.toHexString(testData);
            assertEquals(expected, actual);
        }
    }
}
```

[04_JUnit3/src/test/java/JUnit3Demo.java](04_JUnit3/src/test/java/JUnit3Demo.java)


Бинарное дерево поиска
Левый наследник всегда меньше правого.
Для балансировки: CartesianTree? Декартово дерево поиска?
``` java
public class BinaryTree<T extends Comparable<T>> implements SearchTree<T> {
    /**
     * Корневой элемент дерева
     */
    public TreeNode root = null;

    /**
     * Добавление нового значения в дерево поиска
     *
     * @param value добавляемое значение
     */
    @Override
    public void add(T value) {
        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode cur = root;
        // Бесконечный цикл, т.к. мы выходим только когда нашли узел
        // к которому можем "подвесить" новый узел, и тогда мы выходим
        // по return
        while (true) {
            if (value.compareTo(cur.value) > 0) {
                if (cur.right == null) {
                    // Мы нашли нужный узел, подвешиваем
                    cur.right = newNode;
                    return;
                }
                // Спускаемся "направо"
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    // Мы нашли нужный узел
                    cur.left = newNode;
                    return;
                }
                // Спускаемся "налево"
                cur = cur.left;
            }
        }
    }

    /**
     * Поиск значения в дереве поиска
     *
     * @param value Значение
     * @return найдено ли значение?
     */
    @Override
    public boolean find(T value) {
        // Спускаемся вниз по дереву поиска
        TreeNode cur = root;
        while (cur != null) {
            // Нашли узел с нужным значением
            if (cur.value.equals(value))
                return true;
            // Выбираем куда идти дальше
            cur = (value.compareTo(cur.value) > 0) ? cur.right : cur.left;
        }
        return false;

    }

    @Override
    public int deep() {
        return (root == null) ? 0 : root.deep();
    }

    /**
     * Узел дерева
     */
    class TreeNode {
        public T value;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(T value) {
            this.value = value;
        }

        /**
         * @return глубина дерева
         */
        public int deep() {
            int res = 1;
            if (left != null)
                res = max(res, left.deep() + 1);
            if (right != null)
                res = max(res, right.deep() + 1);
            return res;
        }
    }
}
```

[06_Collections/src/main/java/BinaryTree.java](06_Collections/src/main/java/BinaryTree.java)

``` java
        // Интерфейс =  Класс с реализацией этого интерфейса
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>();
        assertFalse(tree.find(3));
        tree.add(3);
        assertTrue(tree.find(3));
        assertFalse(tree.find(2));

        // Добавить новое значение
        tree.add(2);
        assertTrue(tree.find(2));
        assertTrue(tree.find(3));

        // Добавляем узел с большим значением
        tree.add(334);
        assertTrue(tree.find(2));
        assertTrue(tree.find(3));
        assertTrue(tree.find(334));
        assertFalse(tree.find(7789));
```

[06_Collections/src/test/java/BinaryTreeTest.java](06_Collections/src/test/java/BinaryTreeTest.java)

Set - множество элементов
-------------------------
Основные операции на множествах
add(value) добавить в множество
isEmpty() - пусто ли множество?
size() - количество элементов в списке
``` java
        assertTrue("Множество пусто", s.isEmpty());
        s.add(7);
        assertFalse("Теперь уже не пусто", s.isEmpty());
        s.add(7);
        assertEquals("В множестве 1 элемент т.к. значения совпадают", 1, s.size());
        s.add(10);
        assertEquals("В множестве 2 элемента", 2, s.size());
```

get(index) - получить элемент с заданным индексом
Добавляем сразу массив элементов
remove(Object o) - удаление элемента по значению
contains(Object o) - проверяет наличие элемента в множестве
Проверка, содержит ли одно множество другое множество
[06_Collections/src/test/java/SetTest.java](06_Collections/src/test/java/SetTest.java)

``` java
        Date date = new Date();
        System.out.println("date = " + date);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("'Дата и время:' dd.MM.yyyy HH:mm:ss");

        System.out.println(dateFormat.format(date));

        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        Date date2 = russianDate.parse("11.10.2014");
        System.out.println(date2);

        System.out.println(dateFormat.format(date2));

        // Изменяю время, ставлю 10 часов
        date.setHours(10);
```

[08_DateTime/src/main/java/A_DateDemo.java](08_DateTime/src/main/java/A_DateDemo.java)

``` java
        Calendar now = Calendar.getInstance();
        System.out.println("День месяца: " +
                now.get(Calendar.DAY_OF_MONTH));
        // Месяц нумеруется с нуля
        // 0 - январь
        // 11 - декабрь
        System.out.println("Месяц: " +
                (now.get(Calendar.MONTH) + 1));
        System.out.println("Год: " +
                now.get(Calendar.YEAR));

        System.out.println("Час: " +
                now.get(Calendar.HOUR));
        System.out.println("Минута: " +
                now.get(Calendar.MINUTE));
        System.out.println("Секунда: " +
                now.get(Calendar.SECOND));

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("'Дата и время:' dd.MM.yyyy HH:mm:ss");
        System.out.println(dateFormat.format(now.getTime()));

        SimpleDateFormat dateFormat2 =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        Date parsedDate = dateFormat2.parse("03.03.2015 22:34:11");
        cal.setTime(parsedDate);
        assertEquals(2015, cal.get(Calendar.YEAR));
        // Час HOUR_OF_DAY: 00..23
        // HOUR - 00..11
        assertEquals(22, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(34, cal.get(Calendar.MINUTE));
        assertEquals(11, cal.get(Calendar.SECOND));

        SimpleDateFormat rusMonth =
                new SimpleDateFormat("MMMMM", LOCALE_RU);

        System.out.println(rusMonth.format(now.getTime()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rusMonth.parse("Сентябрь"));
        System.out.println(
                (calendar.get(Calendar.MONTH) + 1)
        );

        // Дата через 2 месяца
        Calendar afterTwoMonths = (Calendar) now.clone();
        afterTwoMonths.add(Calendar.MONTH, 2);

        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(russianDate.format(afterTwoMonths.getTime()));

        Calendar date2 = (Calendar) now.clone();
        date2.add(Calendar.HOUR, -30);
        System.out.println(dateFormat.format(date2.getTime()));
```

[08_DateTime/src/main/java/B_CalendarDemo.java](08_DateTime/src/main/java/B_CalendarDemo.java)

``` java
        LocalDate nowDate = new LocalDate();
        LocalDateTime now = new LocalDateTime();
        System.out.println(showDateTime(now));
        System.out.println(now.dayOfMonth().getAsText());
        System.out.println("День недели: " + now.dayOfWeek().getAsShortText());
        System.out.println("Через 10 дней: " + showDateTime(now.plusDays(10)));
        System.out.println(now.minusMonths(4).plusDays(3));

        System.out.println("Через 3 месяца и 10 дней и 2 часа: " +
                showDateTime(now.plusMonths(3).plusDays(10).plusHours(2)));

        System.out.println("Верхний предел: " + showDateTime(now.plusYears(100000)));
        System.out.println("Нижний предел: " + showDateTime(now.minusYears(100000)));

        System.out.println("US: " + dateFormat2.format(now.minusYears(100000).toDate()));

        // Печать даты
        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(russianDate.format(now.toDate()));

        LocalDate date = new LocalDate(2013, 5, 3);
        System.out.println(russianDate.format(date.toDate()));
```

[08_DateTime/src/main/java/C_JodaTimeDemo.java](08_DateTime/src/main/java/C_JodaTimeDemo.java)


Создание сайта
==============

Ядро системы
------------
Предметная область
* Объекты, их свойства, и действия с ними
 * ОО Моделирование / абстрагирование
* Бизнес-процессы

Технологии:
 * Java-классы (изучаем Java SE)
 * Unit-тестирование (JUnit)

База данных / хранилище
-----------------------
 Как с ним работать, запросы, SQL

Технологии:
 * Hibernate + Spring ORM
 * PostgreSQL (или MySQL)

Интерфейс
---------
 * Функциональность
  * Что пользователь может делать и как
   * Авторизация (регистрация).
     * Роли (виды) пользователей и т.д.
     * Spring Security
   * Ввод данных (в зависимости от роли)
     * Spring + виджеты
   * Поиск по данным (в том числе отчёты) + просмотр
 * GUI / Дизайн (как это выглядит)
   * GWT или Bootstrap / jQuery UI
   * CSS + HTML5 + jQuery.

Взаимодействие с другими системами
----------------------------------
 * Web-сервисы
 * REST-интерфейс для Android-приложений
 * Импорт-экспорт

Домашнее задание
----------------

1. Посмотреть примеры к уроку.
 И задать вопросы по электронной почте.
Запустить tomcat и посмотреть примеры:
http://localhost:8080/examples/jsp/
2. Сделать начальную страницу для своего приложения
(так, чтобы она открывалась при запуске)
 * Подумать и написать что должно быть на начальной странице при запуске
 * Какие страницы ещё нужны
 * Какие ссылки нужны с основной страницы



