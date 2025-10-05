package epsilongtmyon.common.db;

import jakarta.enterprise.context.ApplicationScoped;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;

// 必要かどうか微妙...
// DaoImplにApplicationScopedをつける

@AnnotateWith(annotations = {
		@Annotation(target = AnnotationTarget.CLASS, type = ApplicationScoped.class),
		//@Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Inject.class)
})
public @interface InjectConfig {
}
