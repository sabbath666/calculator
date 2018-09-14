def f = new File("/home/jenkins/workspace/calculator/test.txt")
def src = new File("/home/jenkins/workspace/calculator/script-update.src")
src << f.text
