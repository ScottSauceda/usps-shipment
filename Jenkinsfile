pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args ' -v /tmp/.m2:/tmp/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
         stage('Test') {
                     steps {
                         sh 'mvn test -Dspring.profiles.active=qa'
                     }
                     post {
                         always {
                             junit 'target/surefire-reports/*.xml'
                         }
                     }
                 }
    }
}