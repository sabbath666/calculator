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

        stage("Code  coverage") {
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

        stage("Build") {
            steps {
                sh "./gradlew build"
            }
        }

        stage("Docker build") {
            steps {
                sh "docker build -t 142.93.68.244/calculator ."
            }
        }

        stage("Docker login") {
            steps {
                sh 'docker login -u admin -p hoog0ree 142.93.68.244'
            }
        }

        stage("Docker push") {
            steps {
                sh "docker push 142.93.68.244/calculator"
            }
        }

        stage("Deploy to staging") {
            steps {
                sh "docker run --rm  --name=ansible -v $HOME/.ssh:/root/.ssh -v ~/ansible:/etc/ansible williamyeh/ansible:ubuntu16.04 ansible-playbook /etc/ansible/playbooks/deploy.yml"
                sleep 30
            }
        }

        stage("Acceptance test") {
            steps {
                sh "./acceptance_test.sh 45.55.43.205"
            }
        }

    }
//    post{
//        always{
//            mail to : 'sergeysabbath@gmail.com',
//            subject:  "Completed Pipeline: ${currentBuild.fullDisplayName}",
//            body: "Сборка завершена, результат тут ---> {env.BUILD_URL}"
//        }
//    }
}