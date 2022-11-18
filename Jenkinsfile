pipeline {
  agent {label "maven"}

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                echo "Getting Project from Git"; 
                git branch: "akram", 
                url: "https://github.com/mootazfarwa43/Devops.git";
                sh "mvn -version"
                

            }

        }
       stage('Maven build'){
            
            steps{
                
                script{
                    
                    sh 'mvn clean install -Dmaven.test.skip=true'
                }
            }
        }
      
      stage('PACKAGING '){
                steps{
                    sh 'mvn package  -Dmaven.test.skip=true'
                }
            }
      
      
          stage('UNIT testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn test'
                }
            }
        }
        
         stage('Integration testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn verify -DskipUnitTests'
                }
            }
        }
        
        
        
         stage('MVN SONAREQUBE STAGE') {
            steps {
                sh'mvn sonar:sonar -Dsonar.login=2f76bab51dad5b5a9c1f1bd16ae8deb05886e3d0'
                }
           
        }
      
      stage ('Mockito Test') {
             steps {

            sh "mvn test"
                echo """les tests sont pris en charge"""
                }
            }
      
        stage('JUNIT Test') {
            steps {
            sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.FournisseurServiceImplTest  -Dmaven.test.failure.ignore=true'  
            }
        }
        /*
 stage('MVN NEXUS STAGE') {
         steps{
            sh'mvn deploy -DskipTests'
            }   
        }
         */
        stage('DOCKER BUILD IMG STAGE'){
                steps{
                    script{
                        sh 'docker build -t tpAchatProject-1.0 .'
                    }
                }
            }
      
        stage('DOCKER PUSH IMG STAGE '){
        steps{
            script{
                withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                sh 'docker login -u akramfezzani -p ${dockerhubpwd}'
                     }
                sh 'docker tag tpachat-1.0 akramfezzani/tpachat-1.0:latest'     
                sh 'docker push akramfezzani/tpachat-1.0'     
            }

        }

    }

        stage('DOCKER COMPOSE STAGE') {
            steps{
                script{
                        sh 'docker-compose up -d'
                    }
            }
        }
      
           stage('EMAIL STAGE ') {
        steps{
            mail bcc: '',
            body: ' pipeline is working ',
            cc: '', from: '',
            replyTo: '', subject: '[test valiation] The pipeline is working on something here ...',
            to: 'akram.fezzani@esprit.tn'
        }
        }  
    }
}
