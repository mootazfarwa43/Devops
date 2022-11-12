pipeline {
    agent {label "maven"}
   
    stages {
        stage ('GIT STAGE ') {
            steps {
                     git branch : 'MedAmine',url :'https://github.com/mootazfarwa43/Devops.git'
               
            }
           
    }
         stage('MVN COMPILE STAGE ') {
                steps {
                    sh 'mvn clean compile'
                   
                }
               
            }
       stage('MVN CLEAN STAGE'){
                steps{
                    sh 'mvn clean package'
                   
                }
               
            }
        stage('MVN SONAREQUBE STAGE') {
            steps {
                sh'mvn sonar:sonar -Dsonar.login=391699df68dfc88ddb0849f926f00998f3ca24b5'
                }
           
        }
      stage('MVN TEST STAGE') {
        steps{
            sh'mvn test'
        }
        post {
            always {
            junit testResults: '*/target/surefire-reports/.xml', allowEmptyResults: true
        }
        }
          
        }
   
             stage('MVN NEXUS STAGE') {
        steps{
            sh'mvn deploy -DskipTests'
            
        }
        
        
    }
     stage('EMAIL STAGE ') {
        steps{
            mail bcc: '',
            body: 'Heyy , Med Amine Khaili s pipeline is working ',
            cc: '', from: '',
            replyTo: '', subject: '[test valiation] The pipeline is working on something here ...',
            to: 'medamine.khaili@esprit.tn'
        }
        }   
       
    }
}
