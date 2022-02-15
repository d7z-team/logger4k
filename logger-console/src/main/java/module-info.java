import org.d7z.logger4k.console.ConsoleLogApi;

module org.d7z.logger4k.ext.console {
    requires kotlin.stdlib;
    requires org.d7z.logger4k.core;
    requires kotlin.reflect;
    exports org.d7z.logger4k.console;
    opens org.d7z.logger4k.console;
    provides ILogApi with ConsoleLogApi;
}
