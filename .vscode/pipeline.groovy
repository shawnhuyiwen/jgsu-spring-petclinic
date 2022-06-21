pipeline {
    agent any

    stages {
        stage('Ckeckout'){
            steps {
                git branch: 'main', url: 'https://github.com/shawnhuyiwen/jgsu-spring-petclinic.git'
            }
        }
        
        stage('Build') {
            steps {
                
                bat 'mvnw.cmd clean package'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
               }
            }
        }
    }
}
