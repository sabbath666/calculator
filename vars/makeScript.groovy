def call(def filepath){

    def f = new File(filepath)
    def src = new File("script.src")
    src << f.text
    println("current dir ${new File("./home").listFiles()}")

    println ("script.src: ${src.text}")
}
