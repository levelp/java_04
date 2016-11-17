import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/// Является ли поле первичным ключом?
//-->
@Retention(RetentionPolicy.RUNTIME)
@interface PrimaryKey {
}
//<--
