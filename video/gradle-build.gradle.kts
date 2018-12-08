plugins {
    application
    kotlin("jvm")
}
application{
    mainClassName = "Hello"
}
dependencies{
    compile(kotlin("stdlib"))
}
repositories{
    jcenter()
}
