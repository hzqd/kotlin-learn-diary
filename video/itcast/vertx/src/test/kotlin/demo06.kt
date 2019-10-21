import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun main() {
    //创建Vert.x的App对象
    val app = Vertx.vertx()
    //创建 web 路由
    val router = Router.router(app)
    //配置 web 路由
    router.apply {
        //同步处理请求
        get("/sync").handler { context -> context.response().end("同步") }
        Thread.currentThread().name.let(::println)
        //异步处理请求，执行耗时操作 — 数据库访问、服务请求
        get("/async").blockingHandler { context -> context.response().end("异步") }
        Thread.currentThread().name.let(::println)
    }
    //创建Http服务器 并 处理request请求
    val server = app.createHttpServer()
    with(server) {
        requestHandler { request -> router.accept(request) }
        listen(8080)
    }
}