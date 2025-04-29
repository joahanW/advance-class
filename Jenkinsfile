pipeline{

    agent any
    stages{
        stage('prepare'){
            environment{
                APP = credentials("johan_secret")
            }
            steps{
                echo ("App User: ${APP_USR}")
                echo ("App Password: ${APP_PSW}")
                sh('echo "App Password: ${APP_PSW}" > "secret.txt"')
            }
        }
        stage('Hello'){
            steps{
                echo 'Hello'
            }
        }
    }

    post{
        always{
            echo 'I am always here'
        }
        success{
            echo 'I am success'
        }
        failure{
            echo 'I am failure'
        }
        cleanup{
            echo 'I am cleanup'
        }
    }
}