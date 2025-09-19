package th.co.ais.rpt.util.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import th.co.ais.rpt.util.enums.EnumDocStyle;

@Retention(RetentionPolicy.RUNTIME)
public @interface PCell {
	// column no **require
	int no();
	// column type **require.
	// auto cast type when domain and column have deference type.
	Class cellType() default Object.class;
	// column style
	EnumDocStyle styleName() default EnumDocStyle.CELL_DEFAULT;
	// set style Name On run time from service.**(manual Style Name Reference to EnumDocStyle on styleList Correction.)
	String manualStyleName() default "";
}
