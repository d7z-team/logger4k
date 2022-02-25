import org.d7z.logger4k.core.api.ILoggerFactory;
import org.d7z.logger4k.forward.ForwardLoggerFactory;

module logger4k.forward {
    requires kotlin.stdlib;
    requires org.d7z.logger4k.core;
    requires kotlin.reflect;
    requires org.slf4j;
    exports org.d7z.logger4k.forward;
    opens org.d7z.logger4k.forward;
    provides ILoggerFactory with ForwardLoggerFactory;
}
