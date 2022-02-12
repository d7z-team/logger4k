module org.d7z.logger4k.core {
    requires kotlin.stdlib;
    requires kotlin.reflect;
    exports org.d7z.logger4k.core;
    exports org.d7z.logger4k.core.api;
    exports org.d7z.logger4k.core.utils;
    uses org.d7z.logger4k.core.api.ILogApi;
    uses org.d7z.logger4k.core.api.ILoggerSearch;
    uses org.d7z.logger4k.core.utils.IClassNameFormat;
    uses org.d7z.logger4k.core.utils.IMessageFormat;
}
