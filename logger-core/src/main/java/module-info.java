import org.d7z.logger4k.core.api.ILoggerFactory;


module org.d7z.logger4k.core {
    requires kotlin.stdlib;
    requires kotlin.reflect;
    exports org.d7z.logger4k.core;
    exports org.d7z.logger4k.core.api;
    exports org.d7z.logger4k.core.utils;
    uses ILoggerFactory;
}
