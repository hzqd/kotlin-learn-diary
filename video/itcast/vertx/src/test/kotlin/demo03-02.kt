import io.vertx.core.Vertx
import io.vertx.ext.web.Router
//不用var和val的实现
fun main() {
    Vertx.vertx().apply {
        Router.router(this).apply {
            route("/").handler { context ->
                context.response().end("hello root!")
            }
        }.apply {
            route("/abc").handler { context ->
                context.apply {
                    request().run {
                        arrayListOf(getParam("param"), getHeader("header"))
                            .joinToString(" — ")
                    }.also {
                        response().end("hello abc! $it")
                    }
                }
            }
        }.also {
            createHttpServer().apply {
                requestHandler(it::accept)  // { request -> it.accept(request) }
            }.listen(8080)
        }
    }
}