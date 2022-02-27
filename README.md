# Logger 4K

<p style="text-align: center">
<a href="https://github.com/d7z-team/logger4k" target="_blank"><img alt="Jenkins" src="https://github.com/d7z-team/logger4k/actions/workflows/release.yml/badge.svg?branch=main&color=green&style=flat-square"/></a>
<a href="LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/d7z-team/logger4k"></a>
<a href="#"><img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/d7z-team/logger4k"></a>
<a href="https://jitpack.io/#d7z-team/logger4k" target="_blank"> <img alt="JitPack" src="https://img.shields.io/jitpack/v/github/d7z-team/logger4k"></a>
</p>

`Logger4K` 是一个轻量级`Kotlin JVM`日志框架

## 入门

本项目使用 `Gradle `构建, 覆盖 `Junit` 单元测试，如有发现漏洞或者意见可在项目`Issues` 下反馈,欢迎各位大佬提建议。

### 开始之前

> 在开始之前，你需要将模块引入到项目中，本项目使用 JitPack 作为依赖仓库 。

当前最新版本为：[![JitPack](https://img.shields.io/jitpack/v/github/d7z-team/logger4k?label=version&style=flat-square)](https://jitpack.io/#d7z-team/logger4k)

### 使用

``` kotlin

 logger.debug("DEBUG Message.") 
 //  输出 DEBUG 类型的日志 ( 注意，DEBUG未开启则不会输出日志)

 logger.info("INFO  Message.") 
 //  输出 INFO 类型的日志

 logger.warn("WARN  Message.") 
 //  输出 WARN 类型的日志

 logger.error("ERROR  Message.") 
 //  输出 ERROR 类型的日志

logger.debugOnly { 
    //此代码块仅在调试模式下运行
    info("INFO")
    warn("WARN")
    debug("DEBUG")
    error("ERROR")
}

```

## LICENSE

此项目使用 MIT ，详情请查看 [License](./LICENSE) 文件. 
