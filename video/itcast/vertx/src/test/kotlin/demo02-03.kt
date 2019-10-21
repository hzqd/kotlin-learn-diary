import io.vertx.core.Vertx
import io.vertx.ext.web.Router
//你能不用var和val实现下面的主函数吗？
fun main() {
    val app = Vertx.vertx()
    val router = Router.router(app)
    router.route("/").handler { context -> context.response().end("hello root!") }
    router.route("/abc").handler { context ->
        val request = context.request()
        val param = request.getParam("param")
        val header = request.getHeader("header")
        context.response().end("hello abc! $param — $header")
    }
    val server = app.createHttpServer()
    server.requestHandler { request -> router.accept(request) }
    server.listen(8080)
}