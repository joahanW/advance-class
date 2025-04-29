pipeline{
    agent any

    environment{
        AUTHOR = 'Joahan'
        EMAIL = 'johanwork@gmail.com'
        WEB = 'www.johanwork.com'
    }

    stages {
        stage('Environment'){
            environment{
                APP = credentials('secret')
            }
            steps{
                echo "AUTHOR ${AUTHOR}"
                echo "Email ${EMAIL}"
                echo "Start Job: ${env.JOB_NAME}"
                echo "Start Build Number: ${env.BUILD_NUMBER}"
                echo "APP USER: ${APP_USR}"
                echo "APP PASSWORD: ${APP_PSW}"
            }
        }

        stage('Build'){
            steps{
                echo "Start Build"
                sh "./mvnw clean compile"
                echo "End Build"
            }
        }

        stage('Test'){
            steps{
                echo "Start Testing"
                sh "./mvnw test"
                echo "End Testing"
            }
        }

        stage('Deploy'){
            steps{
                echo "Start Deploy"
                sleep(5)
                echo "End Deploy"
            }
        }

    }

    post{
        always{
            echo 'This will always run'
        }
        success{
            echo 'This will run only if successful'
        }
        failure{
            echo 'This will run only if failed'
        }
    }
}