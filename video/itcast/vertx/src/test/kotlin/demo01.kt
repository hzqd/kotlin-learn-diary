import io.vertx.core.Vertx

fun main() {
    Vertx.vertx().createHttpServer().apply {
        requestHandler { request -> request.response().end("Hello Vert.x!") }
    }.listen(8080)
}