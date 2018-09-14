import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

def f = new File("/home/jenkins/workspace/calculator/test.txt")
def src = new File("/home/jenkins/workspace/calculator/script.src")
def src2 = new File("/home/jenkins/workspace/calculator/script-update.src")
src2 << src.text
src2 << f.text
ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream("update.zip"))
src.text.eachLine {
    zipFile.putNextEntry(new ZipEntry(it))
    def buffer = new byte[file.size()]
    file.withInputStream {
        zipFile.write(buffer, 0, it.read(buffer))
    }
    zipFile.closeEntry()
}
zipFile.close()

