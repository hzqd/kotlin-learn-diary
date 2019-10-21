import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun <R> R.configGetRouter(path: String, chunk: String) where R : Router =
    get(path).handler { context -> context.response().end(chunk) }

fun <R> R.configPostRouter(path: String, chunk: String) where R : Router =
    post(path).handler { context -> context.response().end(chunk) }

fun <R> R.configGPRouter(path: String, chunk: String) where R : Router =
    route(path).handler { context -> context.response().end(chunk) }

fun <V> V.creHSer_ReqHandLis(router: Router, port: Int) where V : Vertx =
    createHttpServer().apply { requestHandler(router::accept) }.listen(port)

fun main() {
    /**--------------------函数式思想---------------------*/
    //创建Vert.x  ==>     创建 web 路由器
    Vertx.vertx().apply {
        Router.router(this).apply {
            // ==> 配置 web 路由
            configGetRouter("/get", "hello get!")
            configPostRouter("/post", "hello post!")
            configGPRouter("/api/*", "hello *!")
        }.also {
            // ==> 创建Http服务器 并 处理request请求
            creHSer_ReqHandLis(it, 8080)
        }
    }
}