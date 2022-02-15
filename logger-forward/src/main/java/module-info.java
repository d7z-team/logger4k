import org.d7z.logger4k.forward.ForwardSearch;

module logger4k.forward {
    requires kotlin.stdlib;
    requires org.d7z.logger4k.core;
    requires kotlin.reflect;
    requires java.logging;
    requires org.apache.logging.log4j;
    requires org.slf4j;
    exports org.d7z.logger4k.forward;
    opens org.d7z.logger4k.forward;
    uses ILogApi;
    uses ILoggerSearch;
    provides ILoggerSearch with ForwardSearch;
}
