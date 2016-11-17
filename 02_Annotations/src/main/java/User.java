/// Использование своих аннотаций
///-->
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
//<--
