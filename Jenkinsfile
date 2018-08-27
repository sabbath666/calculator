pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage("Compile") {
            steps {
                sh "chmod 777 -R *"
                sh "./gradlew compileJava"
            }
        }

        stage("Unit tests") {
            steps {
                sh "./gradlew test"
            }
        }

        stage("Code coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML(target: [
                        reportDir  : 'build/reports/jacoco/test/html',
                        reportFiles: 'index.html',
                        reportName : 'Code Coverage Report']
                )
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
    }

    post{
        always{
            mail to : 'sergeysabbath@gmail.com'
            subject:  'Completed Pipeline: ${currentBuild.fullDisplayName}'
            body: 'Сборка завершена, результат тут ---> {env.BUILD_URL}'
        }
    }
}