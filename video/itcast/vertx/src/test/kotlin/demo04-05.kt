import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun main() {
    //创建Vert.x的App对象
    val app = Vertx.vertx()
    //创建 web 路由
    val router = Router.router(app)
    //配置 web 路由
    router.get("/get").handler { context -> context.response().end("hello get!") }
    router.post("/post").handler { context -> context.response().end("hello post!") }
    router.route("/api/*").handler { context -> context.response().end("hello *!") }
    //创建Http服务器 并 处理request请求
    val server = app.createHttpServer()
    server.requestHandler { request -> router.accept(request) }
    server.listen(8080)

    /**--------------------部分函数式思想---------------------*/
    //配置 web 路由
    router.configGetRouter("/get", "hello get!")
    router.configPostRouter("/post", "hello post!")
    router.configGPRouter("/api/*", "hello *!")
    //创建Http服务器 并 处理request请求
    app.creHSer_ReqHandLis(router, 8080)
}